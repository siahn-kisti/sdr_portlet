create table sdr_ApiKey (
	userId bigint not null primary key,
	apiKey varchar(75) null
);

create table sdr_AssetEntries_AssetTags (
	entryId bigint not null,
	tagId bigint not null,
	primary key (entryId, tagId)
);

create table sdr_Collection (
	collectionId bigint not null primary key,
	title varchar(200) null,
	userId bigint,
	createDate date null,
	description varchar(2000) null,
	usageRight varchar(75) null,
	doi varchar(100) null,
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
	title varchar(200) null,
	createDate date null,
	endDate date null,
	log_ long varchar null,
	datasetId bigint,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null
);

create table sdr_DataType (
	dataTypeId bigint not null primary key,
	title varchar(200) null,
	description varchar(2000) null,
	fileValidationRule varchar(75) null,
	groupId bigint,
	companyId bigint,
	curateRequired boolean,
	location varchar(75) null
);

create table sdr_DataTypeSchema (
	dataTypeSchemaId bigint not null primary key,
	dataTypeId bigint,
	title varchar(200) null,
	reference varchar(75) null,
	variableType varchar(75) null,
	variableUnit varchar(75) null,
	essential boolean,
	minimum double,
	maximum double,
	enums varchar(75) null,
	pattern varchar(75) null,
	description varchar(2000) null,
	groupId bigint,
	companyId bigint
);

create table sdr_DataView (
	dataViewId bigint not null primary key,
	title varchar(200) null,
	dataTypeId bigint,
	html long varchar null,
	description varchar(2000) null,
	groupId bigint,
	companyId bigint,
	userId bigint,
	status integer,
	orderNo integer
);

create table sdr_Dataset (
	datasetId bigint not null primary key,
	title varchar(200) null,
	userId bigint,
	userName varchar(75) null,
	createDate date null,
	publishDate date null,
	version integer,
	checksum varchar(200) null,
	doi varchar(100) null,
	descriptiveMetadata long varchar null,
	provenanceMetadata long varchar null,
	description varchar(2000) null,
	location varchar(200) null,
	metalocation varchar(200) null,
	groupId bigint,
	companyId bigint,
	remote boolean,
	fileFinalized boolean,
	fileNum integer,
	hashcode integer,
	status integer,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate date null,
	collectionId bigint,
	dataTypeId bigint,
	curateId bigint
);

create table sdr_IceBreakerVcToken (
	vcToken varchar(1000) null,
	vcTokenExpired date null,
	resultCode integer,
	tokenId bigint not null primary key,
	activate integer
);

create table sdr_ReqMakeSite (
	requestId bigint not null primary key,
	name varchar(75) null,
	description varchar(2000) null,
	siteType bigint,
	userId bigint,
	requestDate date null,
	confirmDate date null,
	message varchar(2000) null,
	status bigint,
	answer varchar(2000) null
);

create table sdr_SdrOrganizations (
	organizationId bigint not null primary key,
	organizationName varchar(75) null,
	description varchar(75) null,
	url varchar(75) null,
	address varchar(75) null,
	zipcode varchar(75) null,
	city varchar(75) null,
	country varchar(75) null
);

create table sdr_SdrUsers (
	userId bigint not null primary key,
	firstName varchar(75) null,
	lastName varchar(75) null,
	email varchar(75) null,
	organizationId bigint,
	createUser bigint
);

create table sdr_SimulationJob (
	simulationId bigint not null primary key,
	simulationUuid varchar(2000) null,
	jobUuid varchar(2000) null,
	inputId varchar(2000) null,
	title varchar(75) null,
	description varchar(2000) null,
	status varchar(75) null,
	simulationStartDt date null,
	simulationEndDt date null,
	userId bigint,
	groupId bigint,
	companyId bigint
);
