#id# 값은 테스트 사용자 환경 정보에서 조회 하여 입력 후 적용한다.

1. DataTypeSchema 더미 데이터 입력
INSERT INTO sdr_datatypeschema (dataTypeSchemaId, dataTypeId, title, reference, variableType, variableUnit, essential, validationRule, description, groupId, companyId)
 VALUES ( 1, 1, 'density', null, 'number', 'g/cc', 1, null, null, 20181, 20154);

INSERT INTO sdr_datatypeschema (dataTypeSchemaId, dataTypeId, title, reference, variableType, variableUnit, essential, validationRule, description, groupId, companyId)
 VALUES ( 2, 1, 'volume', null, 'number', 'A^3', 1, null, null, 20181, 20154);
 
INSERT INTO sdr_datatypeschema (dataTypeSchemaId, dataTypeId, title, reference, variableType, variableUnit, essential, validationRule, description, groupId, companyId)
 VALUES ( 3, 1, 'bandgap', null, 'number', 'eV', 1, null, null, 20181, 20154);
 
INSERT INTO sdr_datatypeschema (dataTypeSchemaId, dataTypeId, title, reference, variableType, variableUnit, essential, validationRule, description, groupId, companyId)
 VALUES ( 4, 1, 'numofatoms', null, 'number', null, 1, null, null, 20181, 20154);
