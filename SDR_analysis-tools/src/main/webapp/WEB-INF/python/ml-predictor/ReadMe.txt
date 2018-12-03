** web page input�������� ���� poscar string �� �̿��Ͽ�
machine learning-based prediction model �� input�� �����ϴ�
preprocessing code �Դϴ�.

* main.py -- density, volume, sum_mass, ..., ���� derived properties �� structure represent �� coulomb matrix values ���� �ϳ��� row�� ���(csv format)

* derivedProperties.py -- atomic value reference �� �����Ͽ� properties �� ���
* coulombMatrix.py -- coulombMatrix ���. random CM �� ���� ����Ǿ����� ����

---

scenario:
### python

### part 1. read a poscar string from the web
### part 2. get attributes (composition info. and lattice info.)
### part 3. calculates derived properties through the composition info.
### part 4. calculates coulomb matrix(CM) from the lattice info. *currently, the maximum size of a CM is 900 due to the scalability issue(30x30 atoms)
### make output csv

### R
### loading pre-processed output
### loading pre-learned machine learning model
### predict the value
### represent

---
roadmap

1 basic sequence, final energy prediction (done)
2 make web interface
3 crystal editor / add more property, formation energy prediction
4 valification
5 improve the performance of the prediction model