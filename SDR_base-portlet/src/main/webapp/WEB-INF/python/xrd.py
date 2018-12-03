import matplotlib
matplotlib.use('Agg')

from pymatgen import Lattice, Structure
from pymatgen.analysis.diffraction.xrd import XRDCalculator
from pymatgen.io.vasp import Poscar
from pymatgen.util.plotting import pretty_plot

import pickle
import sys
import os

poscar_dir = str(sys.argv[1])
dest_dir = str(sys.argv[2])
#wave = str(sys.argv[2])
# wave = One of [Cuka, AgKa, MoKa, FeKa]
p = Poscar.from_file(os.path.join(poscar_dir,"POSCAR"), check_for_POTCAR=False)

lattice = p.structure.lattice
species = p.structure.species
frac_coords = p.structure.frac_coords

structure = Structure(lattice, species, frac_coords)

plt = pretty_plot(16, 14)
ax = plt.gca()

c_cuka = XRDCalculator("CuKa")
d1 = c_cuka.get_xrd_plot(structure, two_theta_range=(0,100), annotate_peaks=False, ax=ax)
d1.savefig(os.path.join(dest_dir,"xrd_CuKa.png"))

c_agka = XRDCalculator("AgKa")
d2 = c_agka.get_xrd_plot(structure, two_theta_range=(0,100), annotate_peaks=False, ax=ax)
d2.savefig(os.path.join(dest_dir,"xrd_AgKa.png"))

c_moka = XRDCalculator("MoKa")
d3 = c_moka.get_xrd_plot(structure, two_theta_range=(0,100), annotate_peaks=False, ax=ax)
d3.savefig(os.path.join(dest_dir,"xrd_MoKa.png"))

c_feka = XRDCalculator("FeKa")
d4 = c_feka.get_xrd_plot(structure, two_theta_range=(0,100), annotate_peaks=False, ax=ax)
d4.savefig(os.path.join(dest_dir,"xrd_FeKa.png"))

print(dest_dir)
