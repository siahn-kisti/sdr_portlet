# READEME

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
