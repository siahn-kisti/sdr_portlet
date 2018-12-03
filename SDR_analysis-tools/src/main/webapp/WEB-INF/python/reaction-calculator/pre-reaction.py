from pymatgen import Element, Composition
from pymatgen.core.composition import CompositionError
import sys, json

formula = str(sys.argv[1])
result = str(sys.argv[2])
output_path = str(sys.argv[3])

reactants_comp = Composition()
products_comp = Composition()
error = dict()

try:
    result_comp = Composition(result)
    element_list = result_comp
    products_comp = result_comp
except CompositionError:
    error["error"] = "No structure with that formula"
    json_dir = output_path + "/" + "output.json"
    with open(json_dir, "w") as outfile:
        json.dump(error, outfile)
    print(error)
    exit()
 
for element in formula.split('+'):
    each_formula = element.strip()
    try:
        tmp_comp = Composition(each_formula)
        reactants_comp += tmp_comp
        element_list += tmp_comp
    except CompositionError:
        error["error"] = "No structure with that formula"
        json_dir = output_path + "/" + "output.json"
        with open(json_dir, "w") as outfile:
            json.dump(error, outfile)
        print(error)
        exit()

element_set = element_list.to_data_dict.get('elements')

for element_check in element_set:
    try:
        tmp = Element(element_check)
    except ValueError:
        error["error"] = "No elements with that name"
        json_dir = output_path + "/" + "output.json"
        with open(json_dir, "w") as outfile:
            json.dump(error, outfile)
        print(error)
        exit()

if reactants_comp != products_comp:
    error["error"] = "Reactants and Products are not matched"
    json_dir = output_path + "/" + "output.json"
    with open(json_dir, "w") as outfile:
        json.dump(error, outfile)
    print(error)
    exit()
else:
    commaseparated = ",".join(element_set)
    result = dict()
    result["elements"] = commaseparated
    print (result)

# f = open("elementList.txt", 'w')
# f.write(commaseparated)
# f.close()