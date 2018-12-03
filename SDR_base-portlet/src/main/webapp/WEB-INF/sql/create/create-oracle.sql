drop user &1 cascade;
create user &1 identified by &2;
grant connect,resource to &1;
connect &1/&2;
set define off;

create table sdr_ApiKey (
	userId number(30,0) not null primary key,
	apiKey VARCHAR2(75 CHAR) null
);

create table sdr_AssetEntries_AssetTags (
	entryId number(30,0) not null,
	tagId number(30,0) not null,
	primary key (entryId, tagId)
);

create table sdr_Collection (
	collectionId number(30,0) not null primary key,
	title VARCHAR2(200 CHAR) null,
	userId number(30,0),
	createDate timestamp null,
	description VARCHAR2(2000 CHAR) null,
	usageRight VARCHAR2(75 CHAR) null,
	doi VARCHAR2(100 CHAR) null,
	accessPolicy number(30,0),
	groupId number(30,0),
	companyId number(30,0)
);

create table sdr_Collection_AllowedUser (
	collectionId number(30,0) not null,
	userId number(30,0) not null,
	primary key (collectionId, userId)
);

create table sdr_Collection_User (
	collectionId number(30,0) not null,
	userId number(30,0) not null,
	primary key (collectionId, userId)
);

create table sdr_Curate (
	curateId number(30,0) not null primary key,
	title VARCHAR2(200 CHAR) null,
	createDate timestamp null,
	endDate timestamp null,
	log_ clob null,
	datasetId number(30,0),
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null
);

create table sdr_DataType (
	dataTypeId number(30,0) not null primary key,
	title VARCHAR2(200 CHAR) null,
	description VARCHAR2(2000 CHAR) null,
	fileValidationRule VARCHAR2(75 CHAR) null,
	groupId number(30,0),
	companyId number(30,0),
	curateRequired number(1, 0),
	location VARCHAR2(75 CHAR) null
);

create table sdr_DataTypeSchema (
	dataTypeSchemaId number(30,0) not null primary key,
	dataTypeId number(30,0),
	title VARCHAR2(200 CHAR) null,
	reference VARCHAR2(75 CHAR) null,
	variableType VARCHAR2(75 CHAR) null,
	variableUnit VARCHAR2(75 CHAR) null,
	essential number(1, 0),
	minimum number(30,20),
	maximum number(30,20),
	enums VARCHAR2(75 CHAR) null,
	pattern VARCHAR2(75 CHAR) null,
	description VARCHAR2(2000 CHAR) null,
	groupId number(30,0),
	companyId number(30,0)
);

create table sdr_DataView (
	dataViewId number(30,0) not null primary key,
	title VARCHAR2(200 CHAR) null,
	dataTypeId number(30,0),
	html clob null,
	description VARCHAR2(2000 CHAR) null,
	groupId number(30,0),
	companyId number(30,0),
	userId number(30,0),
	status number(30,0),
	orderNo number(30,0)
);

create table sdr_Dataset (
	datasetId number(30,0) not null primary key,
	title VARCHAR2(200 CHAR) null,
	userId number(30,0),
	userName VARCHAR2(75 CHAR) null,
	createDate timestamp null,
	publishDate timestamp null,
	version number(30,0),
	checksum VARCHAR2(200 CHAR) null,
	doi VARCHAR2(100 CHAR) null,
	descriptiveMetadata clob null,
	provenanceMetadata clob null,
	description VARCHAR2(2000 CHAR) null,
	location VARCHAR2(200 CHAR) null,
	metalocation VARCHAR2(200 CHAR) null,
	groupId number(30,0),
	companyId number(30,0),
	remote number(1, 0),
	fileFinalized number(1, 0),
	fileNum number(30,0),
	hashcode number(30,0),
	status number(30,0),
	statusByUserId number(30,0),
	statusByUserName VARCHAR2(75 CHAR) null,
	statusDate timestamp null,
	collectionId number(30,0),
	dataTypeId number(30,0),
	curateId number(30,0)
);

create table sdr_IceBreakerVcToken (
	vcToken VARCHAR2(1000 CHAR) null,
	vcTokenExpired timestamp null,
	resultCode number(30,0),
	tokenId number(30,0) not null primary key,
	activate number(30,0)
);

create table sdr_ReqMakeSite (
	requestId number(30,0) not null primary key,
	name VARCHAR2(75 CHAR) null,
	description VARCHAR2(2000 CHAR) null,
	siteType number(30,0),
	userId number(30,0),
	requestDate timestamp null,
	confirmDate timestamp null,
	message VARCHAR2(2000 CHAR) null,
	status number(30,0),
	answer VARCHAR2(2000 CHAR) null
);

create table sdr_SdrOrganizations (
	organizationId number(30,0) not null primary key,
	organizationName VARCHAR2(75 CHAR) null,
	description VARCHAR2(75 CHAR) null,
	url VARCHAR2(75 CHAR) null,
	address VARCHAR2(75 CHAR) null,
	zipcode VARCHAR2(75 CHAR) null,
	city VARCHAR2(75 CHAR) null,
	country VARCHAR2(75 CHAR) null
);

create table sdr_SdrUsers (
	userId number(30,0) not null primary key,
	firstName VARCHAR2(75 CHAR) null,
	lastName VARCHAR2(75 CHAR) null,
	email VARCHAR2(75 CHAR) null,
	organizationId number(30,0),
	createUser number(30,0)
);

create table sdr_SimulationJob (
	simulationId number(30,0) not null primary key,
	simulationUuid VARCHAR2(2000 CHAR) null,
	jobUuid VARCHAR2(2000 CHAR) null,
	inputId VARCHAR2(2000 CHAR) null,
	title VARCHAR2(75 CHAR) null,
	description VARCHAR2(2000 CHAR) null,
	status VARCHAR2(75 CHAR) null,
	simulationStartDt timestamp null,
	simulationEndDt timestamp null,
	userId number(30,0),
	groupId number(30,0),
	companyId number(30,0)
);


create index IX_9705AECF on sdr_Collection (CollectionID);
create index IX_970626EF on sdr_Collection (CollectionId);
create index IX_D2BF5ACF on sdr_Collection (collectionId);
create index IX_C74228A8 on sdr_Collection (groupId);
create index IX_B5D81E86 on sdr_Collection (title);

create index IX_3CF4C083 on sdr_Collection_AllowedUser (CollectionID);
create index IX_3CF538A3 on sdr_Collection_AllowedUser (CollectionId);
create index IX_78AE6C83 on sdr_Collection_AllowedUser (collectionId);
create index IX_A8F69530 on sdr_Collection_AllowedUser (userId);

create index IX_867E2E21 on sdr_Collection_User (CollectionID);
create index IX_867EA641 on sdr_Collection_User (CollectionId);
create index IX_C237DA21 on sdr_Collection_User (collectionId);
create index IX_7B12114E on sdr_Collection_User (userId);
create index IX_E38FF0DB on sdr_Collection_User (userId, collectionId);

create index IX_12B736ED on sdr_Curate (datasetId);

create index IX_1144F89B on sdr_DataType (DataTypeID);
create index IX_114570BB on sdr_DataType (DataTypeId);
create index IX_77A1C9B on sdr_DataType (dataTypeId);
create index IX_BE990260 on sdr_DataType (title);

create index IX_439FC31C on sdr_DataTypeSchema (DataTypeID);
create index IX_43A03B3C on sdr_DataTypeSchema (DataTypeId);
create index IX_39D4E71C on sdr_DataTypeSchema (dataTypeId);
create index IX_71E4A66 on sdr_DataTypeSchema (dataTypeId, variableType);
create index IX_43CBC694 on sdr_DataTypeSchema (groupId, dataTypeId);
create index IX_FDF950A6 on sdr_DataTypeSchema (variableType, dataTypeId);

create index IX_2FF3CCC6 on sdr_DataView (DataTypeID);
create index IX_2FF444E6 on sdr_DataView (DataTypeId);
create index IX_2628F0C6 on sdr_DataView (dataTypeId);
create index IX_DB6509AC on sdr_DataView (dataTypeId, status);
create index IX_7314658D on sdr_DataView (userId);

create index IX_933E6FAD on sdr_Dataset (CollectionID);
create index IX_933EE7CD on sdr_Dataset (CollectionId);
create index IX_347EE493 on sdr_Dataset (DataTypeID);
create index IX_347F5CB3 on sdr_Dataset (DataTypeId);
create index IX_CEF81BAD on sdr_Dataset (collectionId);
create index IX_492A5D93 on sdr_Dataset (collectionId, status);
create index IX_2AB40893 on sdr_Dataset (dataTypeId);
create index IX_5B60479 on sdr_Dataset (dataTypeId, status);
create index IX_57EFD50A on sdr_Dataset (groupId);
create index IX_98BE7B97 on sdr_Dataset (groupId, collectionId);
create index IX_D8AF337D on sdr_Dataset (groupId, collectionId, status);
create index IX_3C3569F0 on sdr_Dataset (groupId, status);
create index IX_9D85EBCF on sdr_Dataset (hashcode);
create index IX_27556BDA on sdr_Dataset (userId);
create index IX_A5EBE667 on sdr_Dataset (userId, collectionId);
create index IX_366CCE4D on sdr_Dataset (userId, collectionId, status);

create index IX_461B767A on sdr_IceBreakerVcToken (activate);

create index IX_5530C1B5 on sdr_ReqMakeSite (userId);

create index IX_DCB7E065 on sdr_SdrUsers (userId);

create index IX_8BDF8DAA on sdr_SimulationJob (jobUuid);
create index IX_5A0B49B4 on sdr_SimulationJob (simulationUuid);
create index IX_8F3A7C98 on sdr_SimulationJob (userId);



quit