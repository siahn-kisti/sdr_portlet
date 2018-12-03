
### Data Submission - Dummy data 

```sql

	select * from sdr_Dataset; // 더미 데이터의 userId,groupId,companyId 등의 부분은 각자 맞춰줘야함 
	/*
	INSERT INTO lportal6.sdr_Dataset(...)
	VALUES(...);
	 
```

### Get Data - Rest API
- Get 방식의 Rest API
	- 주소 형식 : localhost:8080/SDR_rest/rest/datasetid/{datasetid}/filepath/{filepath}
	- 동작 형태 : datasetid를 이용하여 Base location을 받아오고, location+filepath를 통해 해당 파일 위치 찾아서 반환
	 
- URL rewrite
	- .../tomcat_{version}/webapps/ROOT/WEB-INF/urlrewrite.xml 수정
	- <rule enabled="true">
		<from>^/api/filews/datasetid/([0-9]+)/filepath/([a-zA-Z0-9\.\/]+)$</from>
		<to type="redirect">%{context-path}/SDR_rest-portlet/rest/datasetid/$1/filepath/$2</to>
	  </rule> 추가
	- 새로운 주소 형식 : localhost:8080/api/filews/datasetid/{datasetid}/filepath/{filepath}
