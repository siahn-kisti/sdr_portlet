** web page input에서부터 얻은 poscar string 을 이용하여
machine learning-based prediction model 의 input을 생성하는
preprocessing code 입니다.

* main.py -- density, volume, sum_mass, ..., 등의 derived properties 와 structure represent 인 coulomb matrix values 등을 하나의 row로 출력(csv format)

* derivedProperties.py -- atomic value reference 를 참조하여 properties 를 계산
* coulombMatrix.py -- coulombMatrix 계산. random CM 은 아직 적용되어있지 않음

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