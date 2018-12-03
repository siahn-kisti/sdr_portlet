from pymatgen import Composition
from pymatgen.analysis.reaction_calculator import ComputedReaction
from pymatgen.core.periodic_table import Element
from pymatgen.core.units import FloatWithUnit
from pymatgen.entries.computed_entries import ComputedEntry
from pymatgen.phasediagram.maker import PhaseDiagram
import sys, json

# Input 1 : Reactants
# ex) "Ca + C2"
# Input 2 : Products
# ex) "CaC2"
# Input 3 : JSON file path
#
# Output 1 : Reaction energy & formation energy JSON file
#

formula = str(sys.argv[1])
result = str(sys.argv[2])
file_path = str(sys.argv[3])
output_path = str(sys.argv[4])

formula_list = list()

for element in formula.split('+'):
    each_formula = element.strip()
    formula_list.append(each_formula)

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

def get_most_stable_entry(formula):
    relevant_entries = [entry for entry in Computed_entries if entry.composition.reduced_formula == Composition(formula).reduced_formula]
    relevant_entries = sorted(relevant_entries, key=lambda e: e.energy_per_atom)
    # print relevant_entries
    return relevant_entries[0]

phase = PhaseDiagram(Computed_entries)
form_energy = dict()
stable_formula = list()
error = dict()
for each_formula in formula_list:
    try:
        stable_ent = get_most_stable_entry(each_formula)
    except IndexError:
        error["error"] = "No structure with that formula"
        json_dir = output_path + "/" + "output.json"
        with open(json_dir, "w") as outfile:
            json.dump(error, outfile)
        print(error)
        exit()
    # print stable_ent.name, phase.get_form_energy(stable_ent)
    (each_comp, each_factor) = stable_ent.composition.get_reduced_composition_and_factor()
    form_energy[stable_ent.name] = phase.get_form_energy(stable_ent) / each_factor
    stable_formula.append(stable_ent)

try:
    stable_result = get_most_stable_entry(result)
except IndexError:
    error["error"] = "No structure with that formula"
    json_dir = output_path + "/" + "output.json"
    with open(json_dir, "w") as outfile:
        json.dump(error, outfile)
    print(error)
    exit()

# print stable_result.name, phase.get_form_energy(stable_result)
(compo, factor) = stable_result.composition.get_reduced_composition_and_factor()
form_energy[stable_result.name] = phase.get_form_energy(stable_result) / factor

reaction = ComputedReaction(stable_formula, [stable_result])
energy = FloatWithUnit(reaction.calculated_reaction_energy, "eV atom^-1")

json_result = dict()
json_result["reaction"] = str(reaction)

value1 = dict()
value1["value"] = energy.to("kJ mol^-1")
value1["unit"] = "kJ mol^-1"

value2 = dict()
value2["value"] = energy.to("eV atom^-1")
value2["unit"] = "eV"

json_result["value1"] = value1
json_result["value2"] = value2
json_result["formationenergy"] = form_energy

final_dir = output_path + "/" + "output.json"
print (final_dir)
with open(final_dir, 'w') as outfile:
    json.dump(json_result, outfile)
