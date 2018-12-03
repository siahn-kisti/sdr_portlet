drop database if exists lportal;
create database lportal character set utf8;
use lportal;

create table sdr_ApiKey (
	userId bigint not null primary key,
	apiKey varchar(75) null
) engine InnoDB;

create table sdr_AssetEntries_AssetTags (
	entryId bigint not null,
	tagId bigint not null,
	primary key (entryId, tagId)
) engine InnoDB;

create table sdr_Collection (
	collectionId bigint not null primary key,
	title varchar(200) null,
	userId bigint,
	createDate datetime null,
	description varchar(2000) null,
	usageRight varchar(75) null,
	doi varchar(100) null,
	accessPolicy integer,
	groupId bigint,
	companyId bigint
) engine InnoDB;

create table sdr_Collection_AllowedUser (
	collectionId bigint not null,
	userId bigint not null,
	primary key (collectionId, userId)
) engine InnoDB;

create table sdr_Collection_User (
	collectionId bigint not null,
	userId bigint not null,
	primary key (collectionId, userId)
) engine InnoDB;

create table sdr_Curate (
	curateId bigint not null primary key,
	title varchar(200) null,
	createDate datetime null,
	endDate datetime null,
	log_ longtext null,
	datasetId bigint,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName varchar(75) null
) engine InnoDB;

create table sdr_DataType (
	dataTypeId bigint not null primary key,
	title varchar(200) null,
	description varchar(2000) null,
	fileValidationRule varchar(75) null,
	groupId bigint,
	companyId bigint,
	curateRequired tinyint,
	location varchar(75) null
) engine InnoDB;

create table sdr_DataTypeSchema (
	dataTypeSchemaId bigint not null primary key,
	dataTypeId bigint,
	title varchar(200) null,
	reference varchar(75) null,
	variableType varchar(75) null,
	variableUnit varchar(75) null,
	essential tinyint,
	minimum double,
	maximum double,
	enums varchar(75) null,
	pattern varchar(75) null,
	description varchar(2000) null,
	groupId bigint,
	companyId bigint
) engine InnoDB;

create table sdr_DataView (
	dataViewId bigint not null primary key,
	title varchar(200) null,
	dataTypeId bigint,
	html longtext null,
	description varchar(2000) null,
	groupId bigint,
	companyId bigint,
	userId bigint,
	status integer,
	orderNo integer
) engine InnoDB;

create table sdr_Dataset (
	datasetId bigint not null primary key,
	title varchar(200) null,
	userId bigint,
	userName varchar(75) null,
	createDate datetime null,
	publishDate datetime null,
	version integer,
	checksum varchar(200) null,
	doi varchar(100) null,
	descriptiveMetadata longtext null,
	provenanceMetadata longtext null,
	description varchar(2000) null,
	location varchar(200) null,
	metalocation varchar(200) null,
	groupId bigint,
	companyId bigint,
	remote tinyint,
	fileFinalized tinyint,
	fileNum integer,
	hashcode integer,
	status integer,
	statusByUserId bigint,
	statusByUserName varchar(75) null,
	statusDate datetime null,
	collectionId bigint,
	dataTypeId bigint,
	curateId bigint
) engine InnoDB;

create table sdr_IceBreakerVcToken (
	vcToken varchar(1000) null,
	vcTokenExpired datetime null,
	resultCode integer,
	tokenId bigint not null primary key,
	activate integer
) engine InnoDB;

create table sdr_ReqMakeSite (
	requestId bigint not null primary key,
	name varchar(75) null,
	description varchar(2000) null,
	siteType bigint,
	userId bigint,
	requestDate datetime null,
	confirmDate datetime null,
	message varchar(2000) null,
	status bigint,
	answer varchar(2000) null
) engine InnoDB;

create table sdr_SdrOrganizations (
	organizationId bigint not null primary key,
	organizationName varchar(75) null,
	description varchar(75) null,
	url varchar(75) null,
	address varchar(75) null,
	zipcode varchar(75) null,
	city varchar(75) null,
	country varchar(75) null
) engine InnoDB;

create table sdr_SdrUsers (
	userId bigint not null primary key,
	firstName varchar(75) null,
	lastName varchar(75) null,
	email varchar(75) null,
	organizationId bigint,
	createUser bigint
) engine InnoDB;

create table sdr_SimulationJob (
	simulationId bigint not null primary key,
	simulationUuid varchar(2000) null,
	jobUuid varchar(2000) null,
	inputId varchar(2000) null,
	title varchar(75) null,
	description varchar(2000) null,
	status varchar(75) null,
	simulationStartDt datetime null,
	simulationEndDt datetime null,
	userId bigint,
	groupId bigint,
	companyId bigint
) engine InnoDB;


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


