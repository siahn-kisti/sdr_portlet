create table sdr_ApiKey (
	userId bigint not null primary key,
	apiKey varchar(75)
);

create table sdr_AssetEntries_AssetTags (
	entryId bigint not null,
	tagId bigint not null,
	primary key (entryId, tagId)
);

create table sdr_Collection (
	collectionId bigint not null primary key,
	title varchar(200),
	userId bigint,
	createDate timestamp,
	description varchar(2000),
	usageRight varchar(75),
	doi varchar(100),
	accessPolicy integer,
	groupId bigint,
	companyId bigint
);

create table sdr_Collection_AllowedUser (
	collectionId bigint not null,
	userId bigint not null,
	primary key (collectionId, userId)
);

create table sdr_Collection_User (
	collectionId bigint not null,
	userId bigint not null,
	primary key (collectionId, userId)
);

create table sdr_Curate (
	curateId bigint not null primary key,
	title varchar(200),
	createDate timestamp,
	endDate timestamp,
	log_ clob,
	datasetId bigint,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75)
);

create table sdr_DataType (
	dataTypeId bigint not null primary key,
	title varchar(200),
	description varchar(2000),
	fileValidationRule varchar(75),
	groupId bigint,
	companyId bigint,
	curateRequired smallint,
	location varchar(75)
);

create table sdr_DataTypeSchema (
	dataTypeSchemaId bigint not null primary key,
	dataTypeId bigint,
	title varchar(200),
	reference varchar(75),
	variableType varchar(75),
	variableUnit varchar(75),
	essential smallint,
	minimum double,
	maximum double,
	enums varchar(75),
	pattern varchar(75),
	description varchar(2000),
	groupId bigint,
	companyId bigint
);

create table sdr_DataView (
	dataViewId bigint not null primary key,
	title varchar(200),
	dataTypeId bigint,
	html clob,
	description varchar(2000),
	groupId bigint,
	companyId bigint,
	userId bigint,
	status integer,
	orderNo integer
);

create table sdr_Dataset (
	datasetId bigint not null primary key,
	title varchar(200),
	userId bigint,
	userName varchar(75),
	createDate timestamp,
	publishDate timestamp,
	version integer,
	checksum varchar(200),
	doi varchar(100),
	descriptiveMetadata clob,
	provenanceMetadata clob,
	description varchar(2000),
	location varchar(200),
	metalocation varchar(200),
	groupId bigint,
	companyId bigint,
	remote smallint,
	fileFinalized smallint,
	fileNum integer,
	hashcode integer,
	status integer,
	statusByUserId bigint,
	statusByUserName varchar(75),
	statusDate timestamp,
	collectionId bigint,
	dataTypeId bigint,
	curateId bigint
);

create table sdr_IceBreakerVcToken (
	vcToken varchar(1000),
	vcTokenExpired timestamp,
	resultCode integer,
	tokenId bigint not null primary key,
	activate integer
);

create table sdr_ReqMakeSite (
	requestId bigint not null primary key,
	name varchar(75),
	description varchar(2000),
	siteType bigint,
	userId bigint,
	requestDate timestamp,
	confirmDate timestamp,
	message varchar(2000),
	status bigint,
	answer varchar(2000)
);

create table sdr_SdrOrganizations (
	organizationId bigint not null primary key,
	organizationName varchar(75),
	description varchar(75),
	url varchar(75),
	address varchar(75),
	zipcode varchar(75),
	city varchar(75),
	country varchar(75)
);

create table sdr_SdrUsers (
	userId bigint not null primary key,
	firstName varchar(75),
	lastName varchar(75),
	email varchar(75),
	organizationId bigint,
	createUser bigint
);

create table sdr_SimulationJob (
	simulationId bigint not null primary key,
	simulationUuid varchar(2000),
	jobUuid varchar(2000),
	inputId varchar(2000),
	title varchar(75),
	description varchar(2000),
	status varchar(75),
	simulationStartDt timestamp,
	simulationEndDt timestamp,
	userId bigint,
	groupId bigint,
	companyId bigint
);
