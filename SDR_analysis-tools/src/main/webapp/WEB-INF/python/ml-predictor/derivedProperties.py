#-*- encoding: utf-8 -*-
import pandas as pd
import numpy as np
import math
from sklearn.decomposition import TruncatedSVD
import scipy.sparse

#
# by Jeongcheol Lee @20170908
# ADDED save_sparse_csr_to_file, load_sparse_csr_from_file, convert_2d_sparse_csr_to_dict
# dict_to_csr, cm_data_to_multiple_csr_dict_for_jsonsave
# in order to use scipy.sparse.csc_matrix(coo)/csr_matrix, scipy.sparse.todense/save_npz
# 
def save_sparse_csr_to_file(filename,array):
    np.savez(filename,data = array.data ,indices=array.indices,
             indptr =array.indptr, shape=array.shape )

def load_sparse_csr_from_file(filename):
    loader = np.load(filename)
    return csr_matrix((  loader['data'], loader['indices'], loader['indptr']),
                         shape = loader['shape'])

def convert_2d_sparse_csr_to_dict(csr_array):
    for_return_dict = dict()
    for_return_dict.update({"data": csr_array.data.tolist()})
    for_return_dict.update({"indices": csr_array.indices.tolist()})
    for_return_dict.update({"indptr": csr_array.indptr.tolist()})
    for_return_dict.update({"shape": csr_array.shape})
    return for_return_dict

def dict_to_csr(dictname):
    loader = dictname
    return scipy.sparse.csr_matrix((  loader['data'], loader['indices'], loader['indptr']),
                         shape = loader['shape'])

# dict_to_csr -> returnvalue.todense(): convert sparse to dense form 
def cm_data_to_multiple_csr_dict_for_jsonsave(threedim_data):
    temp = dict()
    list_for_return = []
    for i in range(0,len(threedim_data)):
        temp = convert_2d_sparse_csr_to_dict(scipy.sparse.csr_matrix(np.array(cm_data[i], dtype=np.float32)))
        list_for_return.append(temp)
        print(i+1,"-th /",len(threedim_data),"array has been converted to a csr dict.")
    return list_for_return

# getting a tuple that is matched with input x(string atom_name)
# name of the database == el(OQMD)
def getValues(df, x):
  for number in range(0,len(df)):
    result= {}
    if x == df.loc[[number]].symbol.values:
      result= df.loc[[number]]
      return result

# df[[col]].loc[[rows]].columns.values (name)
# df[[col]].loc[[rows]].values (value)

def numofAtoms(componentid):
  sum=0
  for i in range(0,len(componentid)):
    sum = sum + componentid[i][1]
  return sum

def calculateValues(atomlist, datatype, metric):
  if metric=='max':
      return float(getMax(atomlist, datatype))
  if metric=='min':
      return float(getMin(atomlist,datatype))
  if metric=='avg':
      return float(getAvg(atomlist,datatype))
  if metric=='maxdiff':
      return abs(float(getMax(atomlist,datatype))-float(getMin(atomlist,datatype)))
  if metric=='sum':
      return float(getSum(atomlist,datatype))
  if metric=='std':
      return float(getStd(atomlist,datatype))

def getSum(atomlist, datatype):
  temp=0
  for i in range(0,len(atomlist)):
      temp += atomlist[i][datatype].values*atomlist[i]['howmany'].values
  return temp

def getMax(atomlist, datatype):
  tmp=0
  for i in range(0,len(atomlist)):
    if atomlist[i][datatype].values*atomlist[i]['howmany'].values > tmp :
      tmp = atomlist[i][datatype].values*atomlist[i]['howmany'].values
  return tmp

def getMin(atomlist, datatype):
  tmp=10000000000
  tmp_sav=tmp
  for i in range(0,len(atomlist)):
    if atomlist[i][datatype].values> 0 and atomlist[i][datatype].values*atomlist[i]['howmany'].values < tmp :
      tmp = atomlist[i][datatype].values*atomlist[i]['howmany'].values
  if tmp_sav == tmp:
    tmp=0.0
  return tmp

def getAvg(atomlist, datatype):
  tmp=0
  num_Atoms=0
  for i in range(0,len(atomlist)):
      num_Atoms += atomlist[i].howmany.values
  for i in range(0,len(atomlist)):
    if num_Atoms*atomlist[i][datatype].values != 0:
      tmp = tmp+ (float)(atomlist[i]['howmany'].values)*(float)(atomlist[i][datatype].values)
  return (float)(tmp/num_Atoms)

def getStd(atomlist, datatype):
  tmp=0.0
  num_Atoms=0.0
  avg_value=0.0
  for i in range(0,len(atomlist)):
      num_Atoms += atomlist[i].howmany.values
  avg_value = float(getAvg(atomlist, datatype))
  for i in range(0,len(atomlist)):
          if num_Atoms*atomlist[i][datatype].values != 0:
            tmp = tmp+ ((float)(atomlist[i]['howmany'].values)*(float)(atomlist[i][datatype].values)-avg_value)**2
  return (float)(math.sqrt(tmp/num_Atoms))

def getProperties_from_dict(ps_dict, atomtable):
    #initialization
    temp={}
    r1=0
    r2=0
    r3=0
    r4=0
    r5=0
    r6=0
    r7=0
    r8=0
    r9=0
    r10=0
    r11=0
    r12=0
    r13=0
    r14=0
    r15=0
    r16=0
    r17=0
    r18=0
    r19=0
    r20=0
    r21=0
    sum_electrons=0
    sum_s_e=0
    sum_p_e=0
    sum_d_e=0
    sum_f_e=0
    max_mass=0
    i=0
    #
    #convert dict to dataframe and transpose
###############################################
####python 2.x code
#    df = pd.DataFrame(ps_dict, index=ps_dict.keys())
#    x = pd.DataFrame.transpose(df)
#    for i in range(0,len(x)):
#      temp[i] = getValues(atomtable, x[i][0]) # 원소 정보 값 얻어오기 (all properties)
#      temp[i]['howmany'] = x[i][1]            # 원소 수 값 추가
#      r1_t= temp[i].s_elec.values
#      r2_t= temp[i].p_elec.values
#      r3_t= temp[i].d_elec.values
#      r4_t= temp[i].f_elec.values
#      r5_t= temp[i].z.values
#      sum_s_e = sum_s_e + r1_t*x[i][1]       # 전자수 비율계산을 위한 세팅
#      sum_p_e = sum_p_e + r2_t*x[i][1]
#      sum_d_e = sum_d_e + r3_t*x[i][1]
#      sum_f_e = sum_f_e + r4_t*x[i][1]
#      sum_electrons= sum_electrons + r5_t*x[i][1]
################################################
    df = pd.DataFrame()
    for key in ps_dict.keys():
      df.loc[1,key] = ps_dict[key]
    for key in df.keys():
      temp[i] = getValues(atomtable, key)
      temp[i]['howmany'] = df[key][1]
      r1_t= temp[i].s_elec.values
      r2_t= temp[i].p_elec.values
      r3_t= temp[i].d_elec.values
      r4_t= temp[i].f_elec.values
      r5_t= temp[i].z.values
      sum_s_e = sum_s_e + r1_t*df[key][1]       # 전자수 비율계산을 위한 세팅
      sum_p_e = sum_p_e + r2_t*df[key][1]
      sum_d_e = sum_d_e + r3_t*df[key][1]
      sum_f_e = sum_f_e + r4_t*df[key][1]
      sum_electrons= sum_electrons + r5_t*df[key][1]
      i += 1
#################################################
    #
    tmp={}
    tmp["sum_mass"] = calculateValues(atomlist=temp, datatype='mass',metric='sum')
    tmp["sum_atomic_radii"] = calculateValues(atomlist=temp, datatype='atomic_radii',metric='sum')
    tmp["max_atomic_radii"] = calculateValues(atomlist=temp, datatype='atomic_radii', metric='max')
    tmp["min_atomic_radii"] = calculateValues(atomlist=temp, datatype='atomic_radii', metric='min')
    tmp["avg_atomic_radii"] = calculateValues(atomlist=temp, datatype='atomic_radii', metric='avg')
    tmp["maxdiff_atomic_radii"] = calculateValues(atomlist=temp, datatype='atomic_radii', metric='maxdiff')
    tmp["std_atomic_radii"] = calculateValues(atomlist=temp, datatype='atomic_radii', metric='std')
    #
    tmp["sum_van_der_waals_radii"] = calculateValues(atomlist=temp, datatype='van_der_waals_radii', metric='sum')
    tmp["max_van_der_waals_radii"] = calculateValues(atomlist=temp, datatype='van_der_waals_radii', metric='max')
    tmp["min_van_der_waals_radii"] = calculateValues(atomlist=temp, datatype='van_der_waals_radii', metric='min')
    tmp["avg_van_der_waals_radii"] = calculateValues(atomlist=temp, datatype='van_der_waals_radii', metric='avg')
    tmp["maxdiff_van_der_waals_radii"] = calculateValues(atomlist=temp, datatype='van_der_waals_radii', metric='maxdiff')
    tmp["std_van_der_waals_radii"] = calculateValues(atomlist=temp, datatype='van_der_waals_radii', metric='std')
    #
    tmp["sum_covalent_radii"] = calculateValues(atomlist=temp, datatype='covalent_radii', metric='sum')
    tmp["max_covalent_radii"] = calculateValues(atomlist=temp, datatype='covalent_radii', metric='max')
    tmp["min_covalent_radii"] = calculateValues(atomlist=temp, datatype='covalent_radii', metric='min')
    tmp["avg_covalent_radii"] = calculateValues(atomlist=temp, datatype='covalent_radii', metric='avg')
    tmp["maxdiff_covalent_radii"] = calculateValues(atomlist=temp, datatype='covalent_radii', metric='maxdiff')
    tmp["std_covalent_radii"] = calculateValues(atomlist=temp, datatype='covalent_radii', metric='std')
    #
    tmp["sum_melt"] = calculateValues(atomlist=temp, datatype='melt', metric='sum')
    tmp["max_melt"] = calculateValues(atomlist=temp, datatype='melt', metric='max')
    tmp["min_melt"] = calculateValues(atomlist=temp, datatype='melt', metric='min')
    tmp["avg_melt"] = calculateValues(atomlist=temp, datatype='melt', metric='avg')
    tmp["maxdiff_melt"] = calculateValues(atomlist=temp, datatype='melt', metric='maxdiff')
    tmp["std_melt"] = calculateValues(atomlist=temp, datatype='melt', metric='std')
    #
    tmp["sum_boil"] = calculateValues(atomlist=temp, datatype='boil', metric='sum')
    tmp["max_boil"] = calculateValues(atomlist=temp, datatype='boil', metric='max')
    tmp["min_boil"] = calculateValues(atomlist=temp, datatype='boil', metric='min')
    tmp["avg_boil"] = calculateValues(atomlist=temp, datatype='boil', metric='avg')
    tmp["maxdiff_boil"] = calculateValues(atomlist=temp, datatype='boil', metric='maxdiff')
    tmp["std_boil"] = calculateValues(atomlist=temp, datatype='boil', metric='std')
    #
    tmp["sum_specific_heat"] = calculateValues(atomlist=temp, datatype='specific_heat', metric='sum')
    tmp["max_specific_heat"] = calculateValues(atomlist=temp, datatype='specific_heat', metric='max')
    tmp["min_specific_heat"] = calculateValues(atomlist=temp, datatype='specific_heat', metric='min')
    tmp["avg_specific_heat"] = calculateValues(atomlist=temp, datatype='specific_heat', metric='avg')
    tmp["maxdiff_specific_heat"] = calculateValues(atomlist=temp, datatype='specific_heat', metric='maxdiff')
    tmp["std_specific_heat"] = calculateValues(atomlist=temp, datatype='specific_heat', metric='std')
    #
    #tmp["sum_electronegativity"] = calculateValues(atomlist=temp, datatype='electronegativity', metric='sum')
    #tmp["max_electronegativity"] = calculateValues(atomlist=temp, datatype='electronegativity', metric='max')
    #tmp["min_electronegativity"] = calculateValues(atomlist=temp, datatype='electronegativity', metric='min')
    #tmp["avg_electronegativity"] = calculateValues(atomlist=temp, datatype='electronegativity', metric='avg')
    #tmp["maxdiff_electronegativity"] = calculateValues(atomlist=temp, datatype='electronegativity', metric='maxdiff')
    #tmp["std_electronegativity"] = calculateValues(atomlist=temp, datatype='electronegativity', metric='std')
    #
    tmp["sum_first_ionization_energy"] = calculateValues(atomlist=temp, datatype='first_ionization_energy', metric='sum')
    tmp["max_first_ionization_energy"] = calculateValues(atomlist=temp, datatype='first_ionization_energy', metric='max')
    tmp["min_first_ionization_energy"] = calculateValues(atomlist=temp, datatype='first_ionization_energy', metric='min')
    tmp["avg_first_ionization_energy"] = calculateValues(atomlist=temp, datatype='first_ionization_energy', metric='avg')
    tmp["maxdiff_first_ionization_energy"] = calculateValues(atomlist=temp, datatype='first_ionization_energy', metric='maxdiff')
    tmp["std_first_ionization_energy"] = calculateValues(atomlist=temp, datatype='first_ionization_energy', metric='std')
    #
    tmp["sum_electron_affinity"] = calculateValues(atomlist=temp, datatype='electron_affinity', metric='sum')
    tmp["max_electron_affinity"] = calculateValues(atomlist=temp, datatype='electron_affinity', metric='max')
    tmp["min_electron_affinity"] = calculateValues(atomlist=temp, datatype='electron_affinity', metric='min')
    tmp["avg_electron_affinity"] = calculateValues(atomlist=temp, datatype='electron_affinity', metric='avg')
    tmp["maxdiff_electron_affinity"] = calculateValues(atomlist=temp, datatype='electron_affinity', metric='maxdiff')
    tmp["std_electron_affinity"] = calculateValues(atomlist=temp, datatype='electron_affinity', metric='std')
    #
    tmp["sum_s_elec"] = calculateValues(atomlist=temp, datatype='s_elec', metric='sum')
    tmp["max_s_elec"] = calculateValues(atomlist=temp, datatype='s_elec', metric='max')
    tmp["min_s_elec"] = calculateValues(atomlist=temp, datatype='s_elec', metric='min')
    tmp["avg_s_elec"] = calculateValues(atomlist=temp, datatype='s_elec', metric='avg')
    tmp["maxdiff_s_elec"] = calculateValues(atomlist=temp, datatype='s_elec', metric='maxdiff')
    tmp["std_s_elec"] = calculateValues(atomlist=temp, datatype='s_elec', metric='std')
    #
    tmp["sum_p_elec"] = calculateValues(atomlist=temp, datatype='p_elec', metric='sum')
    tmp["max_p_elec"] = calculateValues(atomlist=temp, datatype='p_elec', metric='max')
    tmp["min_p_elec"] = calculateValues(atomlist=temp, datatype='p_elec', metric='min')
    tmp["avg_p_elec"] = calculateValues(atomlist=temp, datatype='p_elec', metric='avg')
    tmp["maxdiff_p_elec"] = calculateValues(atomlist=temp, datatype='p_elec', metric='maxdiff')
    tmp["std_p_elec"] = calculateValues(atomlist=temp, datatype='p_elec', metric='std')
    #
    tmp["sum_d_elec"] = calculateValues(atomlist=temp, datatype='d_elec', metric='sum')
    tmp["max_d_elec"] = calculateValues(atomlist=temp, datatype='d_elec', metric='max')
    tmp["min_d_elec"] = calculateValues(atomlist=temp, datatype='d_elec', metric='min')
    tmp["avg_d_elec"] = calculateValues(atomlist=temp, datatype='d_elec', metric='avg')
    tmp["maxdiff_d_elec"] = calculateValues(atomlist=temp, datatype='d_elec', metric='maxdiff')
    tmp["std_d_elec"] = calculateValues(atomlist=temp, datatype='d_elec', metric='std')
    #
    tmp["sum_f_elec"] = calculateValues(atomlist=temp, datatype='f_elec', metric='sum')
    tmp["max_f_elec"] = calculateValues(atomlist=temp, datatype='f_elec', metric='max')
    tmp["min_f_elec"] = calculateValues(atomlist=temp, datatype='f_elec', metric='min')
    tmp["avg_f_elec"] = calculateValues(atomlist=temp, datatype='f_elec', metric='avg')
    tmp["maxdiff_f_elec"] = calculateValues(atomlist=temp, datatype='f_elec', metric='maxdiff')
    tmp["std_f_elec"] = calculateValues(atomlist=temp, datatype='f_elec', metric='std')
    #
    tmp["sum_production"] = calculateValues(atomlist=temp, datatype='production', metric='sum')
    tmp["max_production"] = calculateValues(atomlist=temp, datatype='production', metric='max')
    tmp["min_production"] = calculateValues(atomlist=temp, datatype='production', metric='min')
    tmp["avg_production"] = calculateValues(atomlist=temp, datatype='production', metric='avg')
    tmp["maxdiff_production"] = calculateValues(atomlist=temp, datatype='production', metric='maxdiff')
    tmp["std_production"] = calculateValues(atomlist=temp, datatype='production', metric='std')
    #
    tmp["sum_group"] = calculateValues(atomlist=temp, datatype='group', metric='sum')
    tmp["max_group"] = calculateValues(atomlist=temp, datatype='group', metric='max')
    tmp["min_group"] = calculateValues(atomlist=temp, datatype='group', metric='min')
    tmp["avg_group"] = calculateValues(atomlist=temp, datatype='group', metric='avg')
    tmp["maxdiff_group"] = calculateValues(atomlist=temp, datatype='group', metric='maxdiff')
    tmp["std_group"] = calculateValues(atomlist=temp, datatype='group', metric='std')
    #
    tmp["sum_period"] = calculateValues(atomlist=temp, datatype='period', metric='sum')
    tmp["max_period"] = calculateValues(atomlist=temp, datatype='period', metric='max')
    tmp["min_period"] = calculateValues(atomlist=temp, datatype='period', metric='min')
    tmp["avg_period"] = calculateValues(atomlist=temp, datatype='period', metric='avg')
    tmp["maxdiff_period"] = calculateValues(atomlist=temp, datatype='period', metric='maxdiff')
    tmp["std_period"] = calculateValues(atomlist=temp, datatype='period', metric='std')
    #
    tmp["sum_HHI_P"] = calculateValues(atomlist=temp, datatype='HHI_P', metric='sum')
    tmp["max_HHI_P"] = calculateValues(atomlist=temp, datatype='HHI_P', metric='max')
    tmp["min_HHI_P"] = calculateValues(atomlist=temp, datatype='HHI_P', metric='min')
    tmp["avg_HHI_P"] = calculateValues(atomlist=temp, datatype='HHI_P', metric='avg')
    tmp["maxdiff_HHI_P"] = calculateValues(atomlist=temp, datatype='HHI_P', metric='maxdiff')
    tmp["std_HHI_P"] = calculateValues(atomlist=temp, datatype='HHI_P', metric='std')
    #
    tmp["sum_HHI_R"] = calculateValues(atomlist=temp, datatype='HHI_R', metric='sum')
    tmp["max_HHI_R"] = calculateValues(atomlist=temp, datatype='HHI_R', metric='max')
    tmp["min_HHI_R"] = calculateValues(atomlist=temp, datatype='HHI_R', metric='min')
    tmp["avg_HHI_R"] = calculateValues(atomlist=temp, datatype='HHI_R', metric='avg')
    tmp["maxdiff_HHI_R"] = calculateValues(atomlist=temp, datatype='HHI_R', metric='maxdiff')
    tmp["std_HHI_R"] = calculateValues(atomlist=temp, datatype='HHI_R', metric='std')
    #
    tmp["sum_valenceoftheelements"] = calculateValues(atomlist=temp, datatype='valenceoftheelements', metric='sum')
    tmp["max_valenceoftheelements"] = calculateValues(atomlist=temp, datatype='valenceoftheelements', metric='max')
    tmp["min_valenceoftheelements"] = calculateValues(atomlist=temp, datatype='valenceoftheelements', metric='min')
    tmp["avg_valenceoftheelements"] = calculateValues(atomlist=temp, datatype='valenceoftheelements', metric='avg')
    tmp["maxdiff_valenceoftheelements"] = calculateValues(atomlist=temp, datatype='valenceoftheelements', metric='maxdiff')
    tmp["std_valenceoftheelements"] = calculateValues(atomlist=temp, datatype='valenceoftheelements', metric='std')
    #
    tmp["sum_numofvalenceelectrons"] = calculateValues(atomlist=temp, datatype='numofvalenceelectrons', metric='sum')
    tmp["max_numofvalenceelectrons"] = calculateValues(atomlist=temp, datatype='numofvalenceelectrons', metric='max')
    tmp["min_numofvalenceelectrons"] = calculateValues(atomlist=temp, datatype='numofvalenceelectrons', metric='min')
    tmp["avg_numofvalenceelectrons"] = calculateValues(atomlist=temp, datatype='numofvalenceelectrons', metric='avg')
    tmp["maxdiff_numofvalenceelectrons"] = calculateValues(atomlist=temp, datatype='numofvalenceelectrons', metric='maxdiff')
    tmp["std_numofvalenceelectrons"] = calculateValues(atomlist=temp, datatype='numofvalenceelectrons', metric='std')
    #
    tmp["sum_thermalconductivity"] = calculateValues(atomlist=temp, datatype='thermalconductivity', metric='sum')
    tmp["max_thermalconductivity"] = calculateValues(atomlist=temp, datatype='thermalconductivity', metric='max')
    tmp["min_thermalconductivity"] = calculateValues(atomlist=temp, datatype='thermalconductivity', metric='min')
    tmp["avg_thermalconductivity"] = calculateValues(atomlist=temp, datatype='thermalconductivity', metric='avg')
    tmp["maxdiff_thermalconductivity"] = calculateValues(atomlist=temp, datatype='thermalconductivity', metric='maxdiff')
    tmp["std_thermalconductivity"] = calculateValues(atomlist=temp, datatype='thermalconductivity', metric='std')
    #
    tmp["sum_entalpyofatomization"] = calculateValues(atomlist=temp, datatype='entalpyofatomization', metric='sum')
    tmp["max_entalpyofatomization"] = calculateValues(atomlist=temp, datatype='entalpyofatomization', metric='max')
    tmp["min_entalpyofatomization"] = calculateValues(atomlist=temp, datatype='entalpyofatomization', metric='min')
    tmp["avg_entalpyofatomization"] = calculateValues(atomlist=temp, datatype='entalpyofatomization', metric='avg')
    tmp["maxdiff_entalpyofatomization"] = calculateValues(atomlist=temp, datatype='entalpyofatomization', metric='maxdiff')
    tmp["std_entalpyofatomization"] = calculateValues(atomlist=temp, datatype='entalpyofatomization', metric='std')
    #
    tmp["sum_fusion"] = calculateValues(atomlist=temp, datatype='fusion', metric='sum')
    tmp["max_fusion"] = calculateValues(atomlist=temp, datatype='fusion', metric='max')
    tmp["min_fusion"] = calculateValues(atomlist=temp, datatype='fusion', metric='min')
    tmp["avg_fusion"] = calculateValues(atomlist=temp, datatype='fusion', metric='avg')
    tmp["maxdiff_fusion"] = calculateValues(atomlist=temp, datatype='fusion', metric='maxdiff')
    tmp["std_fusion"] = calculateValues(atomlist=temp, datatype='fusion', metric='std')
    #
    tmp["sum_vaporization"] = calculateValues(atomlist=temp, datatype='vaporization', metric='sum')
    tmp["max_vaporization"] = calculateValues(atomlist=temp, datatype='vaporization', metric='max')
    tmp["min_vaporization"] = calculateValues(atomlist=temp, datatype='vaporization', metric='min')
    tmp["avg_vaporization"] = calculateValues(atomlist=temp, datatype='vaporization', metric='avg')
    tmp["maxdiff_vaporization"] = calculateValues(atomlist=temp, datatype='vaporization', metric='maxdiff')
    tmp["std_vaporization"] = calculateValues(atomlist=temp, datatype='vaporization', metric='std')
    #
    tmp["sum_z"] = calculateValues(atomlist=temp, datatype='z', metric='sum')
    tmp["max_z"] = calculateValues(atomlist=temp, datatype='z', metric='max')
    tmp["min_z"] = calculateValues(atomlist=temp, datatype='z', metric='min')
    tmp["avg_z"] = calculateValues(atomlist=temp, datatype='z', metric='avg')
    tmp["maxdiff_z"] = calculateValues(atomlist=temp, datatype='z', metric='maxdiff')
    tmp["std_z"] = calculateValues(atomlist=temp, datatype='z', metric='std')
    if (float)(sum_electrons) != 0:
      tmp["frac_s_elec"]= (float)(sum_s_e)/(float)(sum_electrons)
      tmp["frac_p_elec"]= (float)(sum_p_e)/(float)(sum_electrons)
      tmp["frac_d_elec"]= (float)(sum_d_e)/(float)(sum_electrons)
      tmp["frac_f_elec"]= (float)(sum_f_e)/(float)(sum_electrons)
    # 20170831 added
    if (float)(tmp["avg_thermalconductivity"]) != 0:
      tmp["fusion_per_conduc"] = (float)(tmp["avg_fusion"])/(float)(tmp["avg_thermalconductivity"])
    return tmp

def getUnitCellVolume(lattice):
    #implement more when cif input only
    return (float)(lattice.volume)
def getUnitCellDensity(sum_of_atomic_mass, volume):
    return (float)(sum_of_atomic_mass*1.660538921/volume)
def getCalculatedFinalEnergyPerAtom(ps_dict, atomtable,formation_energy_per_atom):
    df = pd.DataFrame()
    i=0
    temp={}
    nsites = 0
    for key in ps_dict.keys():
      df.loc[1,key] = ps_dict[key]
      nsites = nsites + df.loc[1,key]
    #>>> df
    #    Cr   Si
    #1  3.0  6.0
    tmp = 0.0
    for key in df.keys():
      #temp[key] = getValues(atomtable, key)['min_energy_mp'].values
      #>>> temp
      #{'Cr': array([-9.63855526]), 'Si': array([-5.42536649])}
      tmp = tmp + (df.loc[1,key]*getValues(atomtable,key)['min_energy_mp'].values)
    formation_energy = 0.0
    formation_energy = formation_energy_per_atom * nsites

    return (tmp + formation_energy)/nsites

def get_min_energy_from_db(ps_dict, atomtable):
    df = pd.DataFrame()
    i=0
    temp={}
    nsites = 0
    for key in ps_dict.keys():
      df.loc[1,key] = ps_dict[key]
      nsites = nsites + df.loc[1,key]
    #>>> df
    #    Cr   Si
    #1  3.0  6.0
    tmp = 0.0
    for key in df.keys():
      #temp[key] = getValues(atomtable, key)['min_energy_mp'].values
      #>>> temp
      #{'Cr': array([-9.63855526]), 'Si': array([-5.42536649])}
      tmp = (float)(getValues(atomtable,key)['min_energy_mp'].values)
    return tmp, nsites

def get_simplified_energy_for_others(ps_dict, atomtable):
    #initialize
    _ = [] #Coulomb Matrix output for multi-dimensional representation
    matrix_1d = []
    
    import collections
    derv_properties = collections.OrderedDict()
    cif_properties = collections.OrderedDict()
    
    ##########################################
    #ACTION
    ##########################################
    ## derived properties from derv function
    derv_properties_others = getProperties_from_dict(ps_dict, atomtable)
    #derv_volume = {"volume": derv.getUnitCellVolume(ps.lattice)}
    #derv_density = {"density": derv.getUnitCellDensity(derv_properties_others['sum_mass'], derv_volume['volume'])}
    from pymatgen import Composition
    comp = Composition(ps_dict)
    derv_nelements = {"nelements": comp.to_data_dict["nelements"] }
    derv_nsites = {"nsites": sum(ps_dict.values()) }
    derv_properties.update(derv_properties_others)
    #derv_properties.update(derv_volume)
    #derv_properties.update(derv_density)
    derv_properties.update(derv_nelements)
    derv_properties.update(derv_nsites)
    #add electronegativity
    derv_avg_electroneg = {"electronegativity": comp.average_electroneg}
    derv_properties.update(derv_avg_electroneg)
    ##########################################
    ## derived properties from cif function (CM)
    ps_frac={}
    ## 20170904 added by JClee ################
    for el in ps_dict.keys():
        ps_frac[el] = comp.get_atomic_fraction(el)
    
    derv_properties.update(ps_frac)
    
    return derv_properties