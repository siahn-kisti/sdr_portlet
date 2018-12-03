#-*- encoding: utf-8 -*-
## require pymatgen library
from pymatgen import Composition
from pymatgen.io.cif import CifBlock
from pymatgen.io.vasp.inputs import Poscar
from pymatgen.symmetry.analyzer import SpacegroupAnalyzer

import derivedProperties as derv
import coulombMatrix as CM
import pandas as pd
import numpy as np
import sys
import scipy.sparse
import collections
from sklearn.externals import joblib
import json
import csv
import os
import subprocess

###############################################
#### code modificated @ 20180116
# 연산 시간 측정을 위한 time(), array 
import time
import numpy as np
import pandas as pd
from keras.models import Sequential
from keras.layers import Dense, Dropout, Activation
from keras.models import load_model
from keras.models import model_from_json
from keras.wrappers.scikit_learn import KerasRegressor
from keras.optimizers import adam
from keras import optimizers
from keras import regularizers
from sklearn.model_selection import cross_val_score
from sklearn.model_selection import train_test_split
from sklearn.model_selection import KFold
from sklearn.metrics import mean_absolute_error as calMAE
from sklearn.preprocessing import LabelBinarizer
from sklearn.preprocessing import StandardScaler
import matplotlib.pyplot as plt
#%matplotlib inline 
# import tensorflow for using gpu_options
import tensorflow as tf
gpu_options = tf.GPUOptions(per_process_gpu_memory_fraction=0.1, allow_growth=True)
sess = tf.Session(config=tf.ConfigProto(allow_soft_placement=True, log_device_placement=True, gpu_options=gpu_options))
###############################################

### coulomb matrix parameter for deep learning and an atomic dataset for stochimetric properties calculations
scriptRootPath = str(sys.argv[1])
max_atom_size_for_cm = 300
atomtable=pd.read_csv(str(scriptRootPath) + '/references/Elements_Dataset.csv')

#### code generated@20170828 by Jeongcheol Lee
#### modified@20170830 for python 3.x and pandas 0.20 by Jeongcheol Lee

### part 1. read a poscar string from the web
### part 2. get attributes (composition info. and lattice info.)
### part 3. calculates derived properties through the composition info.
### part 4. calculates coulomb matrix(CM) from the lattice info. *currently, the maximum size of a CM is 900 due to the scalability issue(30x30 atoms)

## part 1 >
##########################################
#to do_
#READING A POSCAR STRING FROM THE WEB
##########################################
#here, we use an sample string

inputFileFullPath = str(sys.argv[2])
outputFilePath = str(sys.argv[3])

#loading a poscar object we handle .structure.composition, .structure.formula, and .structure.lattice

#validate the POSCAR that is not well-defined and/or ambiguous. 
if Poscar.from_file(inputFileFullPath).true_names:
  ps = Poscar.from_file(inputFileFullPath).structure
#
#casting poscar structure to dict and cif format files
ps_dict = ps.composition.as_dict()
ps_reduced_dict, ps_reduced_factor = ps.composition.get_reduced_formula_and_factor()
ps_cif = ps.to("cif")

#cif_sample[0] = "# generated using pymatgen\ndata_Ga2CoS4\n_symmetry_space_group_name_H-M   'P 1'\n_cell_length_a   5.29198729\n_cell_length_b   5.29198728\n_cell_length_c   6.45268046\n_cell_angle_alpha   114.20867693\n_cell_angle_beta   114.20867699\n_cell_angle_gamma   89.99999995\n_symmetry_Int_Tables_number   1\n_chemical_formula_structural   Ga2CoS4\n_chemical_formula_sum   'Ga2 Co1 S4'\n_cell_volume   147.218893696\n_cell_formula_units_Z   1\nloop_\n _symmetry_equiv_pos_site_id\n _symmetry_equiv_pos_as_xyz\n  1  'x, y, z'\nloop_\n _atom_site_type_symbol\n _atom_site_label\n _atom_site_symmetry_multiplicity\n _atom_site_fract_x\n _atom_site_fract_y\n _atom_site_fract_z\n _atom_site_occupancy\n  S  S1  1  0.874869  0.886340  0.253531  1\n  S  S2  1  0.632808  0.125131  0.746469  1\n  S  S3  1  0.113660  0.621337  0.746469  1\n  S  S4  1  0.378663  0.367192  0.253531  1\n  Co  Co5  1  0.000000  0.000000  0.000000  1\n  Ga  Ga6  1  0.500000  0.500000  0.000000  1\n  Ga  Ga7  1  0.250000  0.750000  0.500000  1\n"
cif_sample_from_the_ps_sample_0_structure = CifBlock.from_string(ps_cif).data

## 20170911 battery properties calculation added by Jclee
IS_BATTERY = False
ps_dict_battery_working_ion = dict()
IF_for_working_ion = 0

for keys in ps_dict.keys():
    #if the key is an working ion
    if keys == 'Li' or keys == 'Na' or keys == 'K':
        IS_BATTERY = True
        ps_dict_battery_others = ps_dict.copy()
        ps_dict_battery_working_ion = {keys: ps_dict_battery_others.pop(keys)}
        IF_for_working_ion = 1
    elif keys == 'Mg':# or keys == 'Ca':
        IS_BATTERY = True
        ps_dict_battery_others = ps_dict.copy()
        ps_dict_battery_working_ion = {keys: ps_dict_battery_others.pop(keys)}
        IF_for_working_ion = 2

## check whether the poscar has working ions for battery properties calculation
if IS_BATTERY == True:
    dict_battery_others = dict()
    energy_battery_others = 0.0
    energy_battery_working_ions = 0.0
    howmany_energy_battery_working_ions = 0
    dict_battery_others = derv.get_simplified_energy_for_others(ps_dict_battery_others, atomtable)
    ps_dict_battery_others_reduced_formula, ps_dict_battery_others_factor = Composition(ps_dict_battery_others).get_reduced_formula_and_factor()
    #currently(20170914) can only support single type of working ion
    energy_battery_working_ions, howmany_energy_battery_working_ions = derv.get_min_energy_from_db(ps_dict_battery_working_ion, atomtable)
    mole_factor = (float)(howmany_energy_battery_working_ions/ps_dict_battery_others_factor)
    #print("energy_battery_working_ions = ", energy_battery_working_ions)
    #print("howmany_energy_battery_working_ions = ", howmany_energy_battery_working_ions)
    #print("mole_factor = ", mole_factor)

#initialize

cif_list = collections.OrderedDict()
matrix_2d = [] #Coulomb Matrix output for multi-dimensional representation
matrix_1d = []

derv_properties = collections.OrderedDict()
cif_properties = collections.OrderedDict()

##########################################
#ACTION
##########################################
## derived properties from derv function
derv_properties_others = derv.getProperties_from_dict(ps_dict, atomtable)
derv_volume = {"volume": derv.getUnitCellVolume(ps.lattice)}
derv_density = {"density": derv.getUnitCellDensity(derv_properties_others['sum_mass'], derv_volume['volume'])}
derv_nsites = {"nsites": len(ps.species) }
derv_nelements = {"nelements": ps.composition.to_data_dict["nelements"] }

derv_properties.update(derv_properties_others)
derv_properties.update(derv_density)
derv_properties.update(derv_volume)
derv_properties.update(derv_nelements)
derv_properties.update(derv_nsites)
## derived spacegroup information
spacegroup = SpacegroupAnalyzer(ps)
derv_spacegroup_number = {"spacegroup_number": spacegroup.get_space_group_number()}
derv_properties.update(derv_spacegroup_number)

## lattice information
structure_lattice_a = {"structure.lattice_a": ps.lattice.a}
structure_lattice_alpha = {"structure.lattice_alpha": ps.lattice.alpha}
structure_lattice_b = {"structure.lattice_b": ps.lattice.b}
structure_lattice_beta = {"structure.lattice_beta": ps.lattice.beta}
structure_lattice_c = {"structure.lattice_c": ps.lattice.c}
structure_lattice_gamma = {"structure.lattice_gamma": ps.lattice.gamma}
structure_lattice_matrix_0_0 = {"structure.lattice_matrix_0_0": ps.lattice.matrix[0][0]}
structure_lattice_matrix_0_1 = {"structure.lattice_matrix_0_1": ps.lattice.matrix[0][1]}    
structure_lattice_matrix_0_2 = {"structure.lattice_matrix_0_2": ps.lattice.matrix[0][2]}    
structure_lattice_matrix_1_0 = {"structure.lattice_matrix_1_0": ps.lattice.matrix[1][0]}    
structure_lattice_matrix_1_1 = {"structure.lattice_matrix_1_1": ps.lattice.matrix[1][1]}    
structure_lattice_matrix_1_2 = {"structure.lattice_matrix_1_2": ps.lattice.matrix[1][2]}    
structure_lattice_matrix_2_0 = {"structure.lattice_matrix_2_0": ps.lattice.matrix[2][0]}    
structure_lattice_matrix_2_1 = {"structure.lattice_matrix_2_1": ps.lattice.matrix[2][1]}    
structure_lattice_matrix_2_2 = {"structure.lattice_matrix_2_2": ps.lattice.matrix[2][2]}
structure_lattice_volume = {"structure.lattice_volume": ps.lattice.volume}    
derv_properties.update(structure_lattice_a)
derv_properties.update(structure_lattice_alpha)
derv_properties.update(structure_lattice_b)
derv_properties.update(structure_lattice_beta)
derv_properties.update(structure_lattice_c)
derv_properties.update(structure_lattice_gamma)
derv_properties.update(structure_lattice_matrix_0_0)
derv_properties.update(structure_lattice_matrix_0_1)
derv_properties.update(structure_lattice_matrix_0_2)
derv_properties.update(structure_lattice_matrix_1_0)
derv_properties.update(structure_lattice_matrix_1_1)
derv_properties.update(structure_lattice_matrix_1_2)
derv_properties.update(structure_lattice_matrix_2_0)
derv_properties.update(structure_lattice_matrix_2_1)
derv_properties.update(structure_lattice_matrix_2_2)
derv_properties.update(structure_lattice_volume)

## not yet updated for learning (2017-08-29)
derv_spacegroup_hall = {"spacegroup_hall": spacegroup.get_hall()}
derv_spacegroup_crystal_system = {"spacegroup_crystal_system": spacegroup.get_crystal_system()}
derv_spacegroup_groupsymbol = {"spacegroup_symbol": spacegroup.get_space_group_symbol()}
derv_spacegroup_point_group = {"spacegroup_point_group": spacegroup.get_point_group_symbol()}
derv_properties.update(derv_spacegroup_hall)
derv_properties.update(derv_spacegroup_crystal_system)
derv_properties.update(derv_spacegroup_groupsymbol)
derv_properties.update(derv_spacegroup_point_group)
#add electronegativity
derv_avg_electroneg = {"electronegativity": ps.composition.average_electroneg}
derv_properties.update(derv_avg_electroneg)
derv_sum_e = {'sum_electronegativity': ps.composition.average_electroneg}
derv_max_e ={'max_electronegativity': ps.composition.average_electroneg}
derv_min_e ={'min_electronegativity' : ps.composition.average_electroneg}
derv_maxdiff_e ={'maxdiff_electronegativity' : 0.0}
derv_avg_e ={ 'avg_electronegativity': ps.composition.average_electroneg}
derv_std_e ={'std_electronegativity': ps.composition.average_electroneg}
derv_properties.update(derv_sum_e)
derv_properties.update(derv_max_e)
derv_properties.update(derv_min_e)
derv_properties.update(derv_avg_e)
derv_properties.update(derv_std_e)

#add volume_per_covalent
if derv_properties['avg_covalent_radii'] != 0:
    derv_volume_per_covalent = {"volume_per_covalent": (float)(derv_properties['volume'])/(float)(derv_properties['avg_covalent_radii'])}
    derv_properties.update(derv_volume_per_covalent)

##########################################
## derived properties from cif function (CM)
cif_list, matrix_2d, matrix_1d = CM.getCoulombMatrix(cif_sample_from_the_ps_sample_0_structure, atomtable, max_atom_size_for_cm)

## 20170908 added by Jclee
#csr_cm = scipy.sparse.csr_matrix(np.array(matrix_2d, dtype=np.float32))
matrix_for_svd = scipy.sparse.csr_matrix(np.array(matrix_1d, dtype=np.float32))

## reshape matrix
## print("Reshape matrix: It may takes few minutes...")
#N = csr_cm.shape[0]
#M = csr_cm.shape[1]
#matrix_for_svd_from_2d = csr_cm.tolil().reshape((1,N*M))

## load pre-learned(fitted) svd pickle
clf = joblib.load(str(scriptRootPath) + '/models/svd500_mp69641.clf')
reduced_features = clf.transform(matrix_for_svd)[0]
for i in range(0,len(reduced_features)):
    cif_properties.update({i:(float)(reduced_features[i])})

derv_properties.update(cif_properties)

ps_frac={}
## 20170904 added by JClee ################
for el in ps_dict.keys():
    ps_frac[el] = ps.composition.get_atomic_fraction(el)

# 20180309 those models learned with #of atoms instead of fraction
#derv_properties.update(ps_frac)
derv_properties.update(ps_dict)


label_encoder = joblib.load(str(scriptRootPath) + '/models/spacegroupnum_encoder.model')
encoded_spacegroup_num = label_encoder.transform([spacegroup.get_space_group_number()])

encoded_spacegroup_num_dict = collections.OrderedDict()
for en_num in range(0,len(encoded_spacegroup_num[0])):
    #key = "spnum_"+str(en_num)
    #value = encoded_spacegroup_num[0][en_num]
    temp = {"spnum_"+str(en_num): encoded_spacegroup_num[0][en_num]}
    #if encoded_spacegroup_num[0][en_num] == 1:
    #    print(en_num)
    encoded_spacegroup_num_dict.update(temp)

derv_properties.update(encoded_spacegroup_num_dict)

res_cal = []
res_cal.append(derv_properties)

### 20180119 학습시 포함되지 않았던 항목 res_cal에서 제거
del res_cal[0]['nelements']
del res_cal[0]['spacegroup_number']
del res_cal[0]['spacegroup_hall']
del res_cal[0]['spacegroup_crystal_system']
del res_cal[0]['spacegroup_symbol']
del res_cal[0]['spacegroup_point_group']

##########################################
#PRINT RESULT (csv or dict to json)
##########################################
pre_derv_columns = ['density','volume', 'nsites']
#'nelements']

element_columns = [
'Ac','Ag','Al','Ar','As','Au',
'B','Ba','Be','Bi','Br',
'C','Ca','Cd','Ce','Cl','Co','Cr','Cs','Cu','Dy','Er','Eu',
'F','Fe','Ga','Gd','Ge',
'H','He','Hf','Hg','Ho',
'I','In','Ir',
'K','Kr','La','Li','Lu','Mg','Mn','Mo',
'N','Na','Nb','Nd','Ne','Ni','Np',
'O','Os',
'P','Pa','Pb','Pd','Pm','Pr','Pt','Pu','Rb','Re','Rh','Ru',
'S','Sb','Sc','Se','Si','Sm','Sn','Sr','Ta','Tb','Tc','Te','Th','Ti','Tl','Tm',
'U',
'V',
'W','Xe',
'Y','Yb','Zn','Zr'
]

derv_columns=[
'structure.lattice_a','structure.lattice_alpha','structure.lattice_b','structure.lattice_beta','structure.lattice_c','structure.lattice_gamma','structure.lattice_matrix_0_0','structure.lattice_matrix_0_1','structure.lattice_matrix_0_2','structure.lattice_matrix_1_0','structure.lattice_matrix_1_1','structure.lattice_matrix_1_2','structure.lattice_matrix_2_0','structure.lattice_matrix_2_1','structure.lattice_matrix_2_2', 'structure.lattice_volume',
#'spacegroup_crystal_system', 'spacegroup_hall', 'spacegroup_number', 'spacegroup_symbol','spacegroup_point_group', 
'electronegativity',
'sum_mass',
'sum_atomic_radii','max_atomic_radii','min_atomic_radii','maxdiff_atomic_radii','avg_atomic_radii', 'std_atomic_radii',
'sum_van_der_waals_radii','max_van_der_waals_radii','min_van_der_waals_radii','maxdiff_van_der_waals_radii','avg_van_der_waals_radii', 'std_van_der_waals_radii',
'sum_covalent_radii','max_covalent_radii','min_covalent_radii','maxdiff_covalent_radii','avg_covalent_radii','std_covalent_radii',
'sum_melt','max_melt','min_melt','maxdiff_melt','avg_melt','std_melt',
'sum_boil','max_boil','min_boil','maxdiff_boil','avg_boil','std_boil',
'sum_specific_heat','max_specific_heat','min_specific_heat','maxdiff_specific_heat','avg_specific_heat','std_specific_heat',
'sum_electronegativity','max_electronegativity','min_electronegativity','maxdiff_electronegativity','avg_electronegativity','std_electronegativity',
'sum_first_ionization_energy','max_first_ionization_energy','min_first_ionization_energy','maxdiff_first_ionization_energy','avg_first_ionization_energy','std_first_ionization_energy',
'sum_electron_affinity','max_electron_affinity','min_electron_affinity','maxdiff_electron_affinity','avg_electron_affinity','std_electron_affinity',
'sum_s_elec','max_s_elec','min_s_elec','maxdiff_s_elec','avg_s_elec', 'std_s_elec',
'sum_p_elec','max_p_elec','min_p_elec','maxdiff_p_elec','avg_p_elec','std_p_elec',
'sum_d_elec','max_d_elec','min_d_elec','maxdiff_d_elec','avg_d_elec','std_d_elec',
'sum_f_elec','max_f_elec','min_f_elec','maxdiff_f_elec','avg_f_elec','std_f_elec',
'sum_production','max_production','min_production','maxdiff_production','avg_production','std_production',
'sum_group','max_group','min_group','maxdiff_group','avg_group','std_group',
'sum_period','max_period','min_period','maxdiff_period','avg_period','std_period',
'sum_HHI_P','max_HHI_P','min_HHI_P','maxdiff_HHI_P','avg_HHI_P','std_HHI_P',
'sum_HHI_R','max_HHI_R','min_HHI_R','maxdiff_HHI_R','avg_HHI_R','std_HHI_R',
'sum_z','max_z','min_z','maxdiff_z','avg_z','std_z',

'sum_valenceoftheelements','max_valenceoftheelements','min_valenceoftheelements','maxdiff_valenceoftheelements','avg_valenceoftheelements','std_valenceoftheelements',
'sum_numofvalenceelectrons','max_numofvalenceelectrons','min_numofvalenceelectrons','maxdiff_numofvalenceelectrons','avg_numofvalenceelectrons','std_numofvalenceelectrons',
'sum_thermalconductivity','max_thermalconductivity','min_thermalconductivity','maxdiff_thermalconductivity','avg_thermalconductivity','std_thermalconductivity',
'sum_entalpyofatomization','max_entalpyofatomization','min_entalpyofatomization','maxdiff_entalpyofatomization','avg_entalpyofatomization','std_entalpyofatomization',
'sum_fusion','max_fusion','min_fusion','maxdiff_fusion','avg_fusion','std_fusion',
'sum_vaporization','max_vaporization','min_vaporization','maxdiff_vaporization','avg_vaporization','std_vaporization',

'frac_s_elec','frac_p_elec','frac_d_elec','frac_f_elec',
#20170831 added
'fusion_per_conduc','volume_per_covalent']

reduced_derv_columns = derv_columns.copy()
#reduced_derv_columns.remove('density')
#reduced_derv_columns.remove('volume')
#reduced_derv_columns.remove('structure.lattice_a')
#reduced_derv_columns.remove('structure.lattice_alpha')
#reduced_derv_columns.remove('structure.lattice_b')
#reduced_derv_columns.remove('structure.lattice_beta')
#reduced_derv_columns.remove('structure.lattice_c')
#reduced_derv_columns.remove('structure.lattice_gamma')
#reduced_derv_columns.remove('structure.lattice_matrix_0_0')
#reduced_derv_columns.remove('structure.lattice_matrix_0_1')
#reduced_derv_columns.remove('structure.lattice_matrix_0_2')
#reduced_derv_columns.remove('structure.lattice_matrix_1_0')
#reduced_derv_columns.remove('structure.lattice_matrix_1_1')
#reduced_derv_columns.remove('structure.lattice_matrix_1_2')
#reduced_derv_columns.remove('structure.lattice_matrix_2_0')
#reduced_derv_columns.remove('structure.lattice_matrix_2_1')
#reduced_derv_columns.remove('structure.lattice_matrix_2_2')
#reduced_derv_columns.remove('spacegroup_crystal_system')
#reduced_derv_columns.remove('spacegroup_hall')
#reduced_derv_columns.remove('spacegroup_number')
#reduced_derv_columns.remove('spacegroup_symbol')
#reduced_derv_columns.remove('spacegroup_point_group')
#reduced_derv_columns.remove('volume_per_covalent')
    
#cif_columns = cif_properties.keys() #maybe used in reduced CM, refined varification required 20170829
#cif_columns = ['0','1',...]

cif_columns = []
for cif_col in range(0,500):
  cif_columns.append(cif_col)

spacegroup_num_columns = []
for spacegroup_col in range(0, len(encoded_spacegroup_num_dict)):
    spacegroup_num_columns.append("spnum_"+str(spacegroup_col))


csv_columns = pre_derv_columns + element_columns + derv_columns + spacegroup_num_columns +cif_columns
#csv_columns_for_element_only = element_columns + reduced_derv_columns
csv_columns_for_element_only = csv_columns

def WriteDictToCSV(csv_file,csv_columns,dict_data):
    try:
        with open(csv_file, 'w') as csvfile:
            writer = csv.DictWriter(csvfile, fieldnames=csv_columns, delimiter=',', lineterminator='\n')
            writer.writeheader()
            for data in dict_data:
                writer.writerow(data)
    except IOError as e:
            print("I/O error({0}): {1}".format(e.errno, e.strerror))


#basic csv to predict properties
WriteDictToCSV(outputFilePath + "/output-with-cm.csv", csv_columns, res_cal)
if IS_BATTERY is False:
    WriteDictToCSV(outputFilePath + "/output-element-only.csv", csv_columns, res_cal)

#additional csv to predict sub elementa
if IS_BATTERY is True:
    sub_res_cal = []
    sub_res_cal.append(dict_battery_others)
    #201803 currently disabled
    #WriteDictToCSV(outputFilePath+'/output-element-only.csv', csv_columns_for_element_only, sub_res_cal)

###### Running R script
####s_path0 = scriptRootPath
####o_path0 = outputFilePath
####s_path1 = scriptRootPath.replace("\\","\\\\")
####o_path1 = outputFilePath.replace("\\","\\\\")
####s_path2 = scriptRootPath.replace(os.path.sep,'/')
####o_path2 = outputFilePath.relpace(os.path.sep,'/')
####subprocess_str = "Rscript --vanilla " + s_path2 + "/SimplePredictionScript-absolutepath.R" + " " + "\"" + s_path2 + "\"" + " " + "\"" + o_path2 + "\""
####p = subprocess.Popen(subprocess_str, stdout=subprocess.PIPE, stderr=subprocess.STDOUT, shell=True)
####(output, err) = p.communicate()
####p_status = p.wait()
#####subprocess.call(subprocess_str, shell=True)
####
#####----
####
#####WriteDictToCSV("d:/analysis/output-with-cm.csv", csv_columns, res_cal)
####
####
####
###### Loading the result ML_predicted.json
###### for getting / basic properties
###### 1 form_epa, 2 final_epa, sub_final_epa(garbage value), 3 eabovehull
###### 4 spacegroup symbol, 5 volume, 6 density
####
####with open(outputFilePath+'/preparing_output.json') as data_file:    
    ####data = json.load(data_file)
#with open(outputFilePath+'/output.json', 'w') as out_file:
#    json.dump(data, out_file)

##############################################################
##### formation energy prediction by using keras model

#clf = joblib.load(str(scriptRootPath) + '/svd500_mp69641.clf')

fileName = "/output-with-cm.csv"
df = pd.read_csv(outputFilePath+fileName)
df.fillna(0,inplace=True)


scaler_load = joblib.load(str(scriptRootPath) + '/models/scaler.model')
scaled_x = scaler_load.transform(df.values)



############################################################
# load json and create model (FORMATION ENERGY)
with open(str(scriptRootPath)+ "/models/forme_model.json","r") as json_file:
    loaded_model_json_from_file = json_file.read()

json_file.close()

loaded_form_model = model_from_json(loaded_model_json_from_file)
# load weights into new model
loaded_form_model.load_weights(str(scriptRootPath)+'/models/forme_model.h5')
print("Loaded model from disk")
 
#loaded model on test data
loaded_form_model.compile(loss='mean_squared_error',optimizer='adam', metrics=['mae'])
y_pred_form = loaded_form_model.predict(scaled_x)


############################################################
# load json and create model (FINAL ENERGY)
with open(str(scriptRootPath)+ "/models/finale_model.json","r") as json_file:
    loaded_model_json_from_file = json_file.read()

json_file.close()

loaded_final_model = model_from_json(loaded_model_json_from_file)
# load weights into new model
loaded_final_model.load_weights(str(scriptRootPath)+'/models/finale_model.h5')
print("Loaded model from disk")
 
# evaluate loaded model on test data
loaded_final_model.compile(loss='mean_squared_error',optimizer='adam', metrics=['mae'])
y_pred_final = loaded_final_model.predict(scaled_x)



output_info = []

##
#basic_info=collections.OrderedDict()
basic_info={}
#predicted_form_energy_pa = data[0]['formation_energy_per_atom']
#predicted_final_energy_pa = data[0]['final_energy_per_atom']
predicted_form_energy_pa = y_pred_form[0][0]

predicted_final_energy_pa = y_pred_final[0][0]
#predicted_final_energy_pa = derv.getCalculatedFinalEnergyPerAtom(ps_dict, atomtable, predicted_form_energy_pa)

#predicted_e_above_hull = data[0]['e_above_hull']
##
basic_info.update({"Formation_Energy_per_Atom_(eV)": (float)(predicted_form_energy_pa)}) #1 unit: (eV)
basic_info.update({"Final_Energy_per_Atom_(eV)": (float)(predicted_final_energy_pa)}) #2 unit: (ev)
#basic_info.update({"Energy_Above_Hull_(eV)": predicted_e_above_hull}) #
basic_info.update({"Volume_(Å³)": (float)(derv_volume['volume'])}) # 3 unit : (Å³)
basic_info.update({"Density_(g/cm³)": (float)(derv_density['density'])}) #4 unit: (g/cm³)
basic_info.update({"Space_Group_Symbol": (str)(derv_spacegroup_groupsymbol['spacegroup_symbol'])}) #5
#basic_info.update(derv_volume) #
#basic_info.update(derv_density) #
#basic_info.update(derv_spacegroup_groupsymbol) #


output_info.append(basic_info)


#formation_energy_per_atom = data[0]['formation_energy_per_atom']
#fepa = {"final_energy_per_atom": (float)(derv.getCalculatedFinalEnergyPerAtom(ps_dict, atomtable, formation_energy_per_atom))}
#data[0].update(fepa)
## 20170911 added for battery properties calculation by Jclee
## 20171110 console print added for test and verification by Jclee
##########################################
## basic information 
#data[0].update(derv_spacegroup_groupsymbol)
IS_BATTERY = False
if IS_BATTERY is True:
    battery_info=collections.OrderedDict()
    predicted_final_energy_pa_from_subelement = data[0]['sub_final_energy_per_atom']
    energy_battery_others = predicted_final_energy_pa_from_subelement * dict_battery_others['nsites']
    #print("predicted_final_energy_pa_from_subelement: ",predicted_final_energy_pa_from_subelement)
    #print("dict_battery_others['nsites']: ",dict_battery_others['nsites'])
    #print("energy_battery_others:", energy_battery_others)
    energy_differential = (float)(energy_battery_working_ions*howmany_energy_battery_working_ions+energy_battery_others-predicted_final_energy_pa*derv_nsites['nsites'])
    #print("energy_differential:", energy_differential)
    reduced_energy_differential = (float)(energy_differential/ps_reduced_factor) # Working ion can be minimized
    #print("ps_reduced_factor:", ps_reduced_factor)
    #print("reduced_energy_differential:", reduced_energy_differential)
    reduced_howmany_energy_battery_working_ions = howmany_energy_battery_working_ions / ps_reduced_factor
    #print("reduced_howmany_energy_battery_working_ions:", reduced_howmany_energy_battery_working_ions)
    #print("howmany_energy_battery_working_ions:", howmany_energy_battery_working_ions)  
    average_voltage = (float)(reduced_energy_differential/reduced_howmany_energy_battery_working_ions/IF_for_working_ion)
    #print("IF_for_working_ion:", IF_for_working_ion)
    total_gravmetric_capacity = (float)(96485000/3600/derv_properties['sum_mass']*IF_for_working_ion)*(ps_dict_battery_others_factor*mole_factor)
    total_volumetric_capacity = (float)(total_gravmetric_capacity*derv_properties['density'])
    avg_v = {"Average_Voltage_(v)": average_voltage} # 6 unit : (v)
    CapG = {"Gravimetric_Capacity_(mAh/g)": total_gravmetric_capacity} # 7 unit : (mAh g^{-1})
    CapV = {"Volumetric_Capacity_(Ah/l)": total_volumetric_capacity} # 8 unit : (Ah l^{-1})
    specific_energy = {"Specific_Energy_(Wh/kg)": (float)(average_voltage*total_gravmetric_capacity)} #9 unit : (Wh/kg)
    energy_density = {"Energy_Density_(Wh/l)": (float)(average_voltage*total_volumetric_capacity)} #10 unit : (Wh/l)
    for key in ps_dict_battery_working_ion.keys():
        tmp = key+"[0-"+str(mole_factor)+"]("+str(ps_dict_battery_others_reduced_formula)+")"+str(ps_dict_battery_others_factor)
    ## update later 20170914
    #battery_info.update({"Range":tmp})
    #print("$$$$$$$$$$$$$$$$$$TST$$$$$$$$$$$$")
    #print(tmp)
    battery_info.update(avg_v)
    battery_info.update(CapG)
    battery_info.update(CapV)
    battery_info.update(specific_energy)
    battery_info.update(energy_density)
    # 201803 not yet confirmed to present battery prediction information
    #output_info.append(battery_info)

with open(outputFilePath+'/output.json', 'w') as out_file:
    json.dump(output_info, out_file)

out_file.close()
#data_file.close()