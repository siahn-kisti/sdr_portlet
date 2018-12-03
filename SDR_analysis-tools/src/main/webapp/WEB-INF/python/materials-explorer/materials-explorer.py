from pymatgen import Lattice, Structure
from pymatgen.io.vasp import Poscar
import sys, os, json

poscar_path = str(sys.argv[1])
file_path = str(sys.argv[2])

poscar = Poscar.from_file(poscar_path)
poscar_candidate = Poscar.from_file(file_path)

metadata = {}

if poscar.structure.matches(poscar_candidate.structure):	
	metadata["compare"] = "true"	
else:
	metadata["compare"] = "false"	
outputMetadata = json.dumps(metadata)

print (outputMetadata)