create table sdr_ApiKey (
	userId int64 not null primary key,
	apiKey varchar(75)
);

create table sdr_AssetEntries_AssetTags (
	entryId int64 not null,
	tagId int64 not null,
	primary key (entryId, tagId)
);

create table sdr_Collection (
	collectionId int64 not null primary key,
	title varchar(200),
	userId int64,
	createDate timestamp,
	description varchar(2000),
	usageRight varchar(75),
	doi varchar(100),
	accessPolicy integer,
	groupId int64,
	companyId int64
);

create table sdr_Collection_AllowedUser (
	collectionId int64 not null,
	userId int64 not null,
	primary key (collectionId, userId)
);

create table sdr_Collection_User (
	collectionId int64 not null,
	userId int64 not null,
	primary key (collectionId, userId)
);

create table sdr_Curate (
	curateId int64 not null primary key,
	title varchar(200),
	createDate timestamp,
	endDate timestamp,
	log_ blob,
	datasetId int64,
	groupId int64,
	companyId int64,
	userId int64,
	userName varchar(75)
);

create table sdr_DataType (
	dataTypeId int64 not null primary key,
	title varchar(200),
	description varchar(2000),
	fileValidationRule varchar(75),
	groupId int64,
	companyId int64,
	curateRequired smallint,
	location varchar(75)
);

create table sdr_DataTypeSchema (
	dataTypeSchemaId int64 not null primary key,
	dataTypeId int64,
	title varchar(200),
	reference varchar(75),
	variableType varchar(75),
	variableUnit varchar(75),
	essential smallint,
	minimum double precision,
	maximum double precision,
	enums varchar(75),
	pattern varchar(75),
	description varchar(2000),
	groupId int64,
	companyId int64
);

create table sdr_DataView (
	dataViewId int64 not null primary key,
	title varchar(200),
	dataTypeId int64,
	html blob,
	description varchar(2000),
	groupId int64,
	companyId int64,
	userId int64,
	status integer,
	orderNo integer
);

create table sdr_Dataset (
	datasetId int64 not null primary key,
	title varchar(200),
	userId int64,
	userName varchar(75),
	createDate timestamp,
	publishDate timestamp,
	version integer,
	checksum varchar(200),
	doi varchar(100),
	descriptiveMetadata blob,
	provenanceMetadata blob,
	description varchar(2000),
	location varchar(200),
	metalocation varchar(200),
	groupId int64,
	companyId int64,
	remote smallint,
	fileFinalized smallint,
	fileNum integer,
	hashcode integer,
	status integer,
	statusByUserId int64,
	statusByUserName varchar(75),
	statusDate timestamp,
	collectionId int64,
	dataTypeId int64,
	curateId int64
);

create table sdr_IceBreakerVcToken (
	vcToken varchar(1000),
	vcTokenExpired timestamp,
	resultCode integer,
	tokenId int64 not null primary key,
	activate integer
);

create table sdr_ReqMakeSite (
	requestId int64 not null primary key,
	name varchar(75),
	description varchar(2000),
	siteType int64,
	userId int64,
	requestDate timestamp,
	confirmDate timestamp,
	message varchar(2000),
	status int64,
	answer varchar(2000)
);

create table sdr_SdrOrganizations (
	organizationId int64 not null primary key,
	organizationName varchar(75),
	description varchar(75),
	url varchar(75),
	address varchar(75),
	zipcode varchar(75),
	city varchar(75),
	country varchar(75)
);

create table sdr_SdrUsers (
	userId int64 not null primary key,
	firstName varchar(75),
	lastName varchar(75),
	email varchar(75),
	organizationId int64,
	createUser int64
);

create table sdr_SimulationJob (
	simulationId int64 not null primary key,
	simulationUuid varchar(2000),
	jobUuid varchar(2000),
	inputId varchar(2000),
	title varchar(75),
	description varchar(2000),
	status varchar(75),
	simulationStartDt timestamp,
	simulationEndDt timestamp,
	userId int64,
	groupId int64,
	companyId int64
);
