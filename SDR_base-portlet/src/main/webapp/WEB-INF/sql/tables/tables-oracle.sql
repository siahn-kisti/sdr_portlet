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
