Python 설치 (windows)
---

###### Miniconda3 설치

- conda.io 사이트에서 miniconda3을 다운받아 설치합니다.
- miniconda3 에 python 실행기가 포함되어 있습니다.
- 설치 시에 환경변수 등록 체크를 합니다.
- 윈도우용 pymatgen 라이브러리를 사용하기 위해서는 Python 3.X 이상 버전이 필요합니다.

###### pymatgen 설치

- Materials Virtual Lab에서 관리하는 Anaconda 클라우드의 matsci 채널을 통해  pymatgen을 설치합니다.

```
# conda install --channel matsci pymatgen
```

- 추가 의존 라이브러리 설치

```
# conda install pandas
# conda install scikit-learn
```


R 설치
---

 - https://www.r-project.org/
 - 개발 버전 : 3.14.0.2

H2O 설치
---

- R 설치 후 Rgui.exe 실행기를 실행하여 아래 URL의 `INSTALL IN R` TAB의 스크립트를 복사/붙여넣기 하여 설치합니다.
- https://h2o-release.s3.amazonaws.com/h2o/rel-weierstrass/2/index.html

```
# The following two commands remove any previously installed H2O packages for R.
if ("package:h2o" %in% search()) { detach("package:h2o", unload=TRUE) }
if ("h2o" %in% rownames(installed.packages())) { remove.packages("h2o") }

# Next, we download packages that H2O depends on.
pkgs <- c("statmod","RCurl","jsonlite")
for (pkg in pkgs) {
if (! (pkg %in% rownames(installed.packages()))) { install.packages(pkg) }
}

# Now we download, install and initialize the H2O package for R.
install.packages("h2o", type="source", repos="https://h2o-release.s3.amazonaws.com/h2o/rel-weierstrass/2/R")

# Finally, let's load H2O and start up an H2O cluster
library(h2o)
h2o.init()
```

- 추가 의존 라이브러리 설치

```
install.packages("df2json")
```