from pymatgen.io.vasp import Poscar
from pymatgen.phasediagram.analyzer import PDAnalyzer
from pymatgen.phasediagram.maker import PhaseDiagram
from pymatgen.phasediagram.plotter import PDPlotter
from pymatgen.entries.computed_entries import ComputedEntry
from pymatgen.core.composition import Composition
from pymatgen.core.periodic_table import Element
import sys, json, numpy, warnings

# Required on Unix
import matplotlib
matplotlib.use('Agg')

# Devsky sorted by electronegativity
def SortByAtomicNumber(atom):
    for lable in phase.elements :
        if lable.name == atom:
            return lable.X

# Input : JSON file path
#
# Output 1 : Phase diagram pdf file
# Output 2 : Compounds list JSON file

file_path = str(sys.argv[1])
output_Path = str(sys.argv[2])
json_data = open(file_path).read()
data = json.loads(json_data)

Computed_entries = list()
for compound in data:
    try:
        unitCellFormula = compound["unitCellFormula"]
        energy = compound["finalEnergy"]
        extracted = dict()
        for cell_name in unitCellFormula.keys():
            cell_num = unitCellFormula[cell_name]
            extracted[Element(cell_name)] = cell_num
        comp = Composition(extracted)
        computed_entry = ComputedEntry(comp, energy, entry_id=compound["materialId"], parameters="param")
        Computed_entries.append(computed_entry)
    except KeyError:
        pass


result = dict()

try:
    # Create phase diagram!
    with warnings.catch_warnings():
        warnings.simplefilter("ignore")
        phase = PhaseDiagram(Computed_entries)
except Exception as e:    
    result["error"] = str(e)
    json_dir = output_Path + "/" + "output.json"
    with open(json_dir, "w") as outfile:
        json.dump(result, outfile)
    print(result)
    exit()

# Plot!
plotter = PDPlotter(phase, show_unstable=True)
#plotter.show()

lines, stable, unstable = plotter.pd_plot_data

### NEED_TO_CHANGE ###
plt = plotter.get_plot()
f = plt.gcf()
f.set_size_inches((15, 12))
fig_dir = output_Path + "/" + "phase.png"
plt.savefig(fig_dir, image_format="png")

# Analyze phase diagram!
pda = PDAnalyzer(phase)

# elements : enum Element to array
elements_array = []
for ele in phase.elements:
    elements_array.append(ele.value)
result["elements"] =  sorted(elements_array, key=SortByAtomicNumber)

# dimension
result["dimension"] = len(phase.elements)

# lines : numpy.ndarray to array
lines_array = []
for line in lines:
    if isinstance(line, numpy.ndarray):
        ll = line.tolist()
    else:
        ll = line
        
    lt = [[ll[0][0],ll[1][0]], [ll[0][1],ll[1][1]]]
               
    lines_array.append(lt)
result["lines"] = lines_array

# stable labels
labels_array = []
for a in phase.stable_entries:
    a_dict = dict()
    a_dict["materialid"] = a.entry_id
    a_dict["name"] = a.name
    a_dict["formation_energy_per_atom"] = phase.get_form_energy_per_atom(a)
    a_dict["is_element"] = True

    for coord, entry in stable.items():
        if a.name == entry.name:
            a_dict["x"] = coord[0]
            a_dict["y"] = coord[1]

    # decomp, e_above_hull 받기    
    decomp, e_above_hull = pda.get_decomp_and_e_above_hull(a)
    #pretty_decomp = [("{}:{}".format(k.composition.reduced_formula, k.entry_id), round(v, 2)) for k, v in decomp.items()]
    a_dict["reduced_formula"] = a.composition.reduced_formula
    a_dict["e_above_hull"] = e_above_hull
    #a_dict["pretty_decomp"] = pretty_decomp

    labels_array.append(a_dict)
result["stable_labels"] = labels_array

# unstable labels
labels_array = []
for a in phase.unstable_entries:
    a_dict = dict()
    a_dict["materialid"] = a.entry_id
    a_dict["name"] = a.name
    a_dict["formation_energy_per_atom"] = phase.get_form_energy_per_atom(a)
    a_dict["is_element"] = True

    for entry, coord in unstable.items():
        if a.name == entry.name:
            a_dict["x"] = coord[0]
            a_dict["y"] = coord[1]
    
    # decomp, e_above_hull 받기    
    decomp, e_above_hull = pda.get_decomp_and_e_above_hull(a)
    #pretty_decomp = [("{}:{}".format(k.composition.reduced_formula, k.entry_id), round(v, 2)) for k, v in decomp.items()]
    a_dict["reduced_formula"] = a.composition.reduced_formula
    a_dict["e_above_hull"] = e_above_hull
    #a_dict["pretty_decomp"] = pretty_decomp
    
    labels_array.append(a_dict)
result["unstable_labels"] = labels_array

print (result)

### NEED_TO_CHANGE ###
json_dir = output_Path + "/" + "output.json"
with open(json_dir, "w") as outfile:
    json.dump(result, outfile)