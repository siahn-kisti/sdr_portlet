#-*- encoding: utf-8 -*-

#######################
import math
import pandas as pd
import numpy as np

def getValues(df, x):
  for number in range(0,len(df)):
    result= {}
    if x == df.loc[[number]].symbol.values:
      result= df.loc[[number]]
      return result

def getZlist(cif_row, atomtable):
    Zlist = []
    for i in range(0,len(cif_row['_atom_site_type_symbol'])):
        Zlist.append(getValues(atomtable, str(cif_row['_atom_site_type_symbol'][i])).z.values)
    return Zlist

def getAtomicDist(cif_row):
    howmanyatomsincifrow = len(cif_row['_atom_site_type_symbol'])
    distMatrix = [[0 for col in range(howmanyatomsincifrow)] for row in range(howmanyatomsincifrow)]
    #default values
    cell_length_a = float(cif_row['_cell_length_a'])
    cell_length_b = float(cif_row['_cell_length_b'])
    cell_length_c = float(cif_row['_cell_length_c'])
    cell_angle_alpha = float(cif_row['_cell_angle_alpha'])
    cell_angle_beta = float(cif_row['_cell_angle_beta'])
    cell_angle_gamma = float(cif_row['_cell_angle_gamma'])
    for i in range(howmanyatomsincifrow):
        for j in range(howmanyatomsincifrow):
            if i < j:
                delta_x = float(cif_row['_atom_site_fract_x'][j]) - float(cif_row['_atom_site_fract_x'][i])
                delta_y = float(cif_row['_atom_site_fract_y'][j]) - float(cif_row['_atom_site_fract_y'][i])
                delta_z = float(cif_row['_atom_site_fract_z'][j]) - float(cif_row['_atom_site_fract_z'][i])
                distMatrix[i][j] = math.sqrt(abs(
                # a^2*delta_x^2 + b^2*delta_y^2 + c^2*delta_z^2 + ...
                (cell_length_a**2)*(delta_x**2) + (cell_length_b**2)*(delta_y**2) + (cell_length_c**2)*(delta_z**2)
                # 2bccos(alpha)*delta_y*delta_z + 2cacos(beta)*delta_z*delta_x + 2abcos(gamma)*delta_x*delta_y
                + 2*cell_length_b*cell_length_c*math.cos(cell_angle_alpha)*delta_y*delta_z
                + 2*cell_length_c*cell_length_a*math.cos(cell_angle_beta)*delta_z*delta_x
                + 2*cell_length_a*cell_length_b*math.cos(cell_angle_gamma)*delta_x*delta_y))
                distMatrix[j][i] = distMatrix[i][j]
            else:
                continue
    return distMatrix

def getCoulombMatrix(cif_row, atomtable, max_array_size):
    coulombMatrixJSON = {}
    Zlist = getZlist(cif_row, atomtable)
    howmanyatomsincifrow = len(cif_row['_atom_site_type_symbol'])
    distMatrix = [[0 for col in range(howmanyatomsincifrow)] for row in range(howmanyatomsincifrow)]
    distMatrix = getAtomicDist(cif_row)
    
    matrix = [[0 for col in range(max_array_size)] for row in range(max_array_size)]
    matrix_1d = [0 for col in range(max_array_size*max_array_size)]
    for i in range(howmanyatomsincifrow):
        for j in range(howmanyatomsincifrow):
            if i == j:
                #print(0.5*Zlist[i]**2.4)
                matrix[i][j] = 0.5*Zlist[i]**2.4
                matrix_1d[max_array_size*i + j]= matrix[i][j]
                coulombMatrixJSON[max_array_size*i + j] = (float)(matrix[i][j])
            elif i < j:
                #print(Zlist[i]*Zlist[j]/dist)
                matrix[i][j] = Zlist[i]*Zlist[j]/distMatrix[i][j]
                matrix_1d[max_array_size*i + j] = matrix[i][j]
                matrix[j][i] = matrix[i][j]
                matrix_1d[max_array_size*j + i] = matrix[i][j]
                coulombMatrixJSON[max_array_size*i + j] = (float)(matrix[i][j])
                coulombMatrixJSON[max_array_size*j + i] = (float)(matrix[i][j])
            else:
                coulombMatrixJSON[max_array_size*i + j] = 0.0
    return coulombMatrixJSON, matrix, matrix_1d

def getRandCoulombMatrix(cif_row, atomtable, max_array_size):
    
    Zlist = getZlist(cif_row, atomtable)
    howmanyatomsincifrow = len(cif_row['_atom_site_type_symbol'])
    distMatrix = [[0 for col in range(howmanyatomsincifrow)] for row in range(howmanyatomsincifrow)]
    distMatrix = getAtomicDist(cif_row)
    
    matrix = [[0 for col in range(max_array_size)] for row in range(max_array_size)]
    matrix_1d = [0 for col in range(max_array_size*max_array_size)]
    for i in range(howmanyatomsincifrow):
        for j in range(howmanyatomsincifrow):
            if i == j:
                #print(0.5*Zlist[i]**2.4)
                matrix[i][j] = 0.5*Zlist[i]**2.4
                #matrix_1d[howmanyatomsincifrow*i + j]= matrix[i][j]
            elif i < j:
                #print(Zlist[i]*Zlist[j]/dist)
                
                matrix[i][j] = Zlist[i]*Zlist[j]/distMatrix[i][j]
                #matrix_1d[howmanyatomsincifrow*i + j] = matrix[i][j]
                matrix[j][i] = matrix[i][j]
                #matrix_1d[howmanyatomsincifrow*j  i] = matrix[i][j]
            else:
                continue
    matrix = np.array(matrix)
    rval = []
    rval = randomize_coulomb_matrix(matrix, 1, 1234)
    rval = pad_array(rval, max_array_size)
    for i in range(howmanyatomsincifrow):
        for j in range(howmanyatomsincifrow):
            matrix_1d[howmanyatomsincifrow*i + j] = rval[i][j]
    return rval, matrix_1d

def randomize_coulomb_matrix(m, n_samples, seed):
        """
        Randomize a Coulomb matrix as decribed in Montavon et al., _New Journal
        of Physics_ __15__ (2013) 095003:
            1. Compute row norms for M in a vector row_norms.
            2. Sample a zero-mean unit-variance noise vector e with dimension
               equal to row_norms.
            3. Permute the rows and columns of M with the permutation that
               sorts row_norms + e.
        Parameters
        ----------
        m : ndarray
            Coulomb matrix.
        n_samples : int, optional (default 1)
            Number of random matrices to generate.
        seed : int, optional
            Random seed.
        """
        rval = []
        row_norms = np.asarray([np.linalg.norm(row) for row in m], dtype=float)
        rng = np.random.RandomState(seed)
        for i in xrange(n_samples):
            e = rng.normal(size=row_norms.size)
            p = np.argsort(row_norms + e)
            new = m[p][:, p]  # permute rows first, then columns
            rval.append(new)
        return rval

#from vs_utils.utils import (DatasetSharder, pad_array, read_pickle,
#…   
#157         Test pad_matrix.
#158         """
#159         x = np.random.random((5, 6))
#160         assert pad_array(x, (10, 12)).shape == (10, 12)

def pad_array(x, shape, fill=0, both=False):
    """
    Pad an array with a fill value.
    Parameters
    ----------
    x : ndarray
        Matrix.
    shape : tuple or int
        Desired shape. If int, all dimensions are padded to that size.
    fill : object, optional (default 0)
        Fill value.
    both : bool, optional (default False)
        If True, split the padding on both sides of each axis. If False,
        padding is applied to the end of each axis.
    """
    x = np.asarray(x)
    if not isinstance(shape, tuple):
        shape = tuple(shape for _ in xrange(x.ndim))
    pad = []
    for i in xrange(x.ndim):
        diff = shape[i] - x.shape[i]
        assert diff >= 0
        if both:
            a, b = divmod(diff, 2)
            b += a
            pad.append((a, b))
        else:
            pad.append((0, diff))
    pad = tuple(pad)
    x = np.pad(x, pad, mode='constant', constant_values=fill)
    return x