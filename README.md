# READEME

## 프로젝트의 내용 및 범위

- 웹 기반 인공지능 활용 데이터 분석 인터페이스 개발 및 구축  
     ```
     ○ 인공지능 활용 데이터 분석 인터페이스 개발 
     ○ ipython 기반 지능형 데이터 분석 환경 연계 개발 및 구축 
     ○ 지능형 데이터 분석 모델 성능평가 차트 개발 및 구축
     ```
- 전년도 개발된 계산·실험·데이터 플랫폼 기능 개선 및 추가 개발
     ```
     ○ 변경된 데이터 모델을 반영한 인터페이스 개발
     ○ 표준 인터페이스 기반 대용량 데이터 제출 기능 개발
     ○ 데이터 타입, 데이터 워크플로우 등 관리 기능의 일반 사용자 활용을 위한 보완 개발
     ○ REST 인터페이스 및 용어집 보완 개발 
     ○ 기타 유지보수 및 버그 수정
     ```
- 전년도 개발된 데이터 뷰 디자이너 보완 개발 및 관련 컴포넌트 개발
    ``` 
     ○ 프리뷰와 에디터의 표현이 되도록 유사하게 보이도록 보완 개발
     ○ 표, 그림 등 요소 컴포넌트들이 HTML 관련 여러 설정을 수용할 수 있도록 개선 
     ○ 다양한 뷰 디자이너 요소 컴포넌트 개발 및 확보 (10종 이상)
    ```     
- 전년도 개발된 소재 커뮤니티 포탈 기능 개선 및 추가 개발
    ```
     ○ 나노전자소재 데이터 검증, 메타데이터 추출, 전용 뷰어 개발
     ○ 나노전자소재 데이터 뷰, 탐색기, 분석 도구 개발
    ```
     
     

## source checkout 후 변경 해야될 부분

- sdr-parent/pom.xml

```xml
<properties>
	<liferay.app.server.deploy.dir>
		/liferay/bundles/liferay-portal-6.2-ce-ga6/tomcat-7.0.62/webapps
	</liferay.app.server.deploy.dir>

	<liferay.app.server.lib.global.dir>
		/liferay/bundles/liferay-portal-6.2-ce-ga6/tomcat-7.0.62/lib/ext
	</liferay.app.server.lib.global.dir>

	<liferay.app.server.portal.dir>
		/liferay/bundles/liferay-portal-6.2-ce-ga6/tomcat-7.0.62/webapps/ROOT
	</liferay.app.server.portal.dir>

	<liferay.auto.deploy.dir>
		/liferay/bundles/liferay-portal-6.2-ce-ga6/deploy
	</liferay.auto.deploy.dir>
</properties>
```

- sdr-parent/SDR_base-portlet/src/main/resources-local/portlet.properties

```properties
dockerCommand=docker
pythonCommand=python3
dataset.temp=/science-data/sdr/tmp
dataset.meta=/science-data/sdr/meta
dataset.final=/science-data/sdr/final
uploadfile=/science-data/sdr/uploadfile
dataview.temp=/usr/liferay/liferay-portal-6.2-ce-ga6/tomcat-7.0.62/webapps/SDR_base-portlet
```

- sdr-parent/SDR_analysis-tools/src/main/resources-local/portlet.properties

```properties
pythonCommand=python
```


## local build

```shell
mvn clean install liferay:deploy
```


## 개발서버용 war 파일 생성

```shell
mvn clean package -Pdev
```
