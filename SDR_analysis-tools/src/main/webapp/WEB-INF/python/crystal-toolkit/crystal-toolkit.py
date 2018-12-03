from pymatgen import Lattice, Structure
from pymatgen.io.vasp import Poscar
from pymatgen.io.vasp.outputs import Vasprun
from pymatgen.io.vasp.inputs import Incar, Kpoints, Potcar
from pymatgen.core.structure import IStructure
from pymatgen.core.periodic_table import Element
from collections import OrderedDict

import sys, json, ast, datetime, warnings
import os.path

# jaesung added : warning handling for elements without electronegativity value (e.g., He)
warnings.simplefilter("ignore", UserWarning)

# Devsky sorted by electronegativity
def SortByAtomicNumber(atom):
	for lable in structure.composition.elements :
		if lable.name == atom:
			return lable.X

def createMetadata(str):

	result = OrderedDict()

	# Insert values
	result["material"] = str.formula

	str_elements = str.composition.elements
	array_elements_name = []
	for each_element in str_elements:
		array_elements_name.append(each_element.name)

	result["elements"] = sorted(array_elements_name, key=SortByAtomicNumber)

	str_species = str.species
	str_frac = str.frac_coords
	count = 0

	coordinate_array = []
	for each_species in str_species:
		inner = dict()
		inner["label"] = each_species.name
		inner["value"] = list(str_frac[count])
		count += 1
		coordinate_array.append(inner)
	result["coordinate"] = coordinate_array

	lattice_array = []
	str_lattice_abc = str.lattice.abc
	for each_abc in str_lattice_abc:
		lattice_array.append(each_abc)
	result["lattice"] = lattice_array
	result["latticealpha"] = str.lattice.alpha
	result["latticebeta"] = str.lattice.beta
	result["latticegamma"] = str.lattice.gamma
	result["volume"] = str.volume
	
	result["sites"] = str.num_sites
	result["reducedformula"] = str.composition.reduced_formula

	## devsky added unitcellformula ouput
	d = {}
	for lable in str.composition.elements :		
		d[lable.name] = str.composition.get(lable)
		temp = json.dumps(d)
	result["unitcellformula"] = json.JSONDecoder().decode(temp)

	return result

# Supercell, Substitution, Extract, Download
condition = str(sys.argv[1])

# POSCAR file path
file_path = str(sys.argv[2])

#poscar = Poscar.from_file(file_path)
#structure = poscar.structure
structure = Structure.from_file(file_path)

# POSCAR Output path
poscarOutputPath = sys.argv[3]

# Number of parameters (Whether it is Substitution or Remove)
num_parameter = len(sys.argv)

# devsky adds time to file name
now = datetime.datetime.now()
nowDatetime = now.strftime('%Y%m%d%H%M%S%f')

# jaesung adds error handling code
flag = True

if condition == "supercell":
	scale_array = ast.literal_eval(sys.argv[4])	
	scaled_structure = structure * scale_array	
	if scaled_structure.num_sites <= 200:
		poscar_structure = Poscar(scaled_structure)
	else:
		flag = False
		poscar_structure = Poscar(structure)
	
elif condition == "substitution":
	if num_parameter == 6: # Substitution
		FROM = Element( str(sys.argv[4]) )
		TO = Element( str(sys.argv[5]) )
		FROMTO = dict()
		FROMTO[FROM] = TO
		structure.replace_species(FROMTO)

	elif num_parameter == 5: # Remove or Add
		FROM = str(sys.argv[4])

		structure.remove_species( [FROM] )

	poscar_structure = Poscar(structure)

elif condition == "extract":
	poscar_structure = Poscar(structure)
	
elif condition == "download":
	chooseFileFormat = str(sys.argv[4])
	poscar_structure = Poscar(structure)
		
else:
	print ("No command with that parameter")
	
metadata = createMetadata(poscar_structure.structure)

# jaesung adds error handling code
if flag == False:
	metadata["errorMessage"] = "Maximum Number of sites exceeded!"

outputFileName = nowDatetime + "_" +condition

## devsky added file extension 
fname = os.path.split(file_path)[1]
if fname != "POSCAR" and fname != "CIF" and fname != "CONTCAR":
	fname = str(file_path).split('_')[-1:][0]

if condition == "download":	
	outputFileName = outputFileName + "_" + chooseFileFormat
	structure.to(chooseFileFormat, poscarOutputPath + "/" + outputFileName)
else:
	outputFileName = outputFileName + "_" + fname
	poscar_structure.write_file(poscarOutputPath + "/" + outputFileName)

jsonFileName = nowDatetime + "_" +condition+"_METADATA.json"

with open(poscarOutputPath + "/" + jsonFileName , 'w') as outfile:
	json.dump(metadata, outfile)

## devsky modified for JAVA output
metadata["outputDatetime"] = nowDatetime
metadata["outputFileName"] = outputFileName
metadata["jsonFileName"] = jsonFileName
outputMetadata = json.dumps(metadata)

print (outputMetadata)