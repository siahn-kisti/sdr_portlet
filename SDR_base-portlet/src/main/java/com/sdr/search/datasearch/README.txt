#id# 값은 테스트 사용자 환경 정보에서 조회 하여 입력 후 적용한다.

1. Collection 더미 데이터
INSERT INTO sdr_Collection(collectionId, title, userId, createDate, description, usageRight, doi, accessPolicy, groupId, companyId)
 VALUES(1, 'test-col-1', 10158, now(), 'test collection 1', 'mit', null, null, #groupId#, #companyId#);

2. Dataset 더미 데이터
INSERT INTO sdr_Dataset (datasetId, title, userId, userName, createDate, description, groupId, companyId, fileNum, collectionId, dataTypeId)
 VALUES ( 1, test-dset-1, #userId#, #userName#, now(), 'test dataset 1', #groupId#, #companyId#, 100, 1, 1);
INSERT INTO sdr_Dataset (datasetId, title, userId, userName, createDate, description, groupId, companyId, fileNum, collectionId, dataTypeId)
 VALUES ( 2, test-dset-2, #userId#, #userName#, now(), 'test dataset 2', #groupId#, #companyId#, 200, 1, 2);
INSERT INTO sdr_Dataset (datasetId, title, userId, userName, createDate, description, groupId, companyId, fileNum, collectionId, dataTypeId)
 VALUES ( 3, test-dset-3, #userId#, #userName#, now(), 'test dataset 3', #groupId#, #companyId#, 300, 1, 3);

3. DataType 더미 데이터
INSERT INTO sdr_DataType(dataTypeId, title, description, groupId, companyId) VALUES(1, 'test-dt-1', 'test data type 1', #groupId#, #companyId#);
INSERT INTO sdr_DataType(dataTypeId, title, description, groupId, companyId) VALUES(2, 'test-dt-2', 'test data type 2', #groupId#, #companyId#);
INSERT INTO sdr_DataType(dataTypeId, title, description, groupId, companyId) VALUES(3, 'test-dt-3', 'test data type 3', #groupId#, #companyId#);
INSERT INTO sdr_DataType(dataTypeId, title, description, groupId, companyId) VALUES(999, 'temp DataType', 'temp dataType', #groupId#, #companyId#);

2. DataView 더미 데이터
Insert into sdr_DataView values (1, 'metadata', 999, '/WEB-INF/jsp/dataSearch/dataset/viewtemp/metadata.jsp', 'default metadata view', #groupId#, #companyId#);
Insert into sdr_DataView values (2, 'file', 999, '/WEB-INF/jsp/dataSearch/dataset/viewtemp/file.jsp', 'default file view', #groupId#, #companyId#);
Insert into sdr_DataView values (3, '1-1', 1, '/WEB-INF/jsp/dataSearch/dataset/viewtemp/3.jsp', 'datatype1 test view1', #groupId#, #companyId#);
Insert into sdr_DataView values (4, '1-2', 1 , '/WEB-INF/jsp/dataSearch/dataset/viewtemp/4.jsp', 'datatype1 test view2', #groupId#, #companyId#);
Insert into sdr_DataView values (5, '2', 2, '/WEB-INF/jsp/dataSearch/dataset/viewtemp/5.jsp', 'datatype2 test view', #groupId#, #companyId#);
Insert into sdr_DataView values (6, '3', 3, '/WEB-INF/jsp/dataSearch/dataset/viewtemp/6.jsp', 'datatype3 test view', #groupId#, #companyId#);

정상 입력 후 reIndex 후 페이지 출력 확인 