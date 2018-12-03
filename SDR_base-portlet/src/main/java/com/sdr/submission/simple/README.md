
### Data Submission - Dummy data 

```sql

	select * from User_ ;	// 더미 데이터의 userId 부분은 각자 맞춰줘야함 

	select * from sdr_DataType;
	/*
	INSERT INTO lportal6.sdr_DataType(dataTypeId, title, description, groupId, companyId)
	VALUES(1, 'test-dt-1', 'test data type 1', 10181, 10154);
	INSERT INTO lportal6.sdr_DataType(dataTypeId, title, description, groupId, companyId)
	VALUES(2, 'test-dt-2', 'test data type 2', 10181, 10154);
	INSERT INTO lportal6.sdr_DataType(dataTypeId, title, description, groupId, companyId)
	VALUES(3, 'test-dt-3', 'test data type 3', 10181, 10154);
	*/
	
	select * from sdr_Collection;
	/*
	INSERT INTO lportal6.sdr_Collection(collectionId, title, userId, createDate, description, usageRight, doi, accessPolicy, groupId, companyId)
	VALUES(1, 'test-col-1', 10158, now(), 'test collection 1', 'mit', null, null, 10181, 10154);
	INSERT INTO lportal6.sdr_Collection(collectionId, title, userId, createDate, description, usageRight, doi, accessPolicy, groupId, companyId)
	VALUES(2, 'test-col-2', 10158, now(), 'test collection 2', 'mit', null, null, 10181, 10154);
	INSERT INTO lportal6.sdr_Collection(collectionId, title, userId, createDate, description, usageRight, doi, accessPolicy, groupId, companyId)
	VALUES(3, 'test-col-3', 10158, now(), 'test collection 3', 'mit', null, null, 10181, 10154);
	*/
	
	select * from sdr_SdrOrganizations;
	/*
	INSERT INTO lportal6.sdr_SdrOrganizations(organizationId, organizationName, description, url, address, zipcode, city, country)
	VALUES(1, 'test-organization-1', 'test organization 1', 'www.kisti.re.kr', 'kisti...', '12345', 'daejeon', 'korea');
	*/
	
	select * from sdr_SdrUsers;
	/*
	INSERT INTO lportal6.sdr_SdrUsers(userId, firstName, lastName, email, organizationId)
	VALUES(1, '스트1', '테', 'test1@kisti.re.kr', 1);
	INSERT INTO lportal6.sdr_SdrUsers(userId, firstName, lastName, email, organizationId)
	VALUES(2, '스트2', '테', 'test2@kisti.re.kr', 2);
	INSERT INTO lportal6.sdr_SdrUsers(userId, firstName, lastName, email, organizationId)
	VALUES(3, '스트3', '테', 'test3@kisti.re.kr', 3);
	*/
	
	select * from sdr_Dataset;
	
```


### Data Submission - File Upload

- 파일업로드 임시 경로 및 용량 설정
	- 경로: Admin > Control Panel > Server Administration > File Uploads
	- 용량설정: Overall Maximum File Size
	- 임시경로설정: Temporary Storage Directory

- Dataset 파일업로드 경로 설정
	- 설정파일: resources/portlet.properties
	- 경로설정: dataset.temp=/data/dataset_temp
	- 실제fullpath: {dataset.temp}/{collectionName}/{userName}/{datasetId}/uploaded(or derived)






