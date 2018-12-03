database sysmaster;
drop database lportal;
create database lportal WITH LOG;

create procedure 'lportal'.isnull(test_string varchar)
returning boolean;
IF test_string IS NULL THEN
	RETURN 't';
ELSE
	RETURN 'f';
END IF
end procedure;


create table sdr_ApiKey (
	userId int8 not null primary key,
	apiKey varchar(75)
)
extent size 16 next size 16
lock mode row;

create table sdr_AssetEntries_AssetTags (
	entryId int8 not null,
	tagId int8 not null,
	primary key (entryId, tagId)
)
extent size 16 next size 16
lock mode row;

create table sdr_Collection (
	collectionId int8 not null primary key,
	title varchar(200),
	userId int8,
	createDate datetime YEAR TO FRACTION,
	description varchar(2000),
	usageRight varchar(75),
	doi varchar(100),
	accessPolicy int,
	groupId int8,
	companyId int8
)
extent size 16 next size 16
lock mode row;

create table sdr_Collection_AllowedUser (
	collectionId int8 not null,
	userId int8 not null,
	primary key (collectionId, userId)
)
extent size 16 next size 16
lock mode row;

create table sdr_Collection_User (
	collectionId int8 not null,
	userId int8 not null,
	primary key (collectionId, userId)
)
extent size 16 next size 16
lock mode row;

create table sdr_Curate (
	curateId int8 not null primary key,
	title varchar(200),
	createDate datetime YEAR TO FRACTION,
	endDate datetime YEAR TO FRACTION,
	log_ text,
	datasetId int8,
	groupId int8,
	companyId int8,
	userId int8,
	userName varchar(75)
)
extent size 16 next size 16
lock mode row;

create table sdr_DataType (
	dataTypeId int8 not null primary key,
	title varchar(200),
	description varchar(2000),
	fileValidationRule varchar(75),
	groupId int8,
	companyId int8,
	curateRequired boolean,
	location varchar(75)
)
extent size 16 next size 16
lock mode row;

create table sdr_DataTypeSchema (
	dataTypeSchemaId int8 not null primary key,
	dataTypeId int8,
	title varchar(200),
	reference varchar(75),
	variableType varchar(75),
	variableUnit varchar(75),
	essential boolean,
	minimum float,
	maximum float,
	enums varchar(75),
	pattern varchar(75),
	description varchar(2000),
	groupId int8,
	companyId int8
)
extent size 16 next size 16
lock mode row;

create table sdr_DataView (
	dataViewId int8 not null primary key,
	title varchar(200),
	dataTypeId int8,
	html text,
	description varchar(2000),
	groupId int8,
	companyId int8,
	userId int8,
	status int,
	orderNo int
)
extent size 16 next size 16
lock mode row;

create table sdr_Dataset (
	datasetId int8 not null primary key,
	title varchar(200),
	userId int8,
	userName varchar(75),
	createDate datetime YEAR TO FRACTION,
	publishDate datetime YEAR TO FRACTION,
	version int,
	checksum varchar(200),
	doi varchar(100),
	descriptiveMetadata text,
	provenanceMetadata text,
	description varchar(2000),
	location varchar(200),
	metalocation varchar(200),
	groupId int8,
	companyId int8,
	remote boolean,
	fileFinalized boolean,
	fileNum int,
	hashcode int,
	status int,
	statusByUserId int8,
	statusByUserName varchar(75),
	statusDate datetime YEAR TO FRACTION,
	collectionId int8,
	dataTypeId int8,
	curateId int8
)
extent size 16 next size 16
lock mode row;

create table sdr_IceBreakerVcToken (
	vcToken lvarchar(1000),
	vcTokenExpired datetime YEAR TO FRACTION,
	resultCode int,
	tokenId int8 not null primary key,
	activate int
)
extent size 16 next size 16
lock mode row;

create table sdr_ReqMakeSite (
	requestId int8 not null primary key,
	name varchar(75),
	description varchar(2000),
	siteType int8,
	userId int8,
	requestDate datetime YEAR TO FRACTION,
	confirmDate datetime YEAR TO FRACTION,
	message varchar(2000),
	status int8,
	answer varchar(2000)
)
extent size 16 next size 16
lock mode row;

create table sdr_SdrOrganizations (
	organizationId int8 not null primary key,
	organizationName varchar(75),
	description varchar(75),
	url varchar(75),
	address varchar(75),
	zipcode varchar(75),
	city varchar(75),
	country varchar(75)
)
extent size 16 next size 16
lock mode row;

create table sdr_SdrUsers (
	userId int8 not null primary key,
	firstName varchar(75),
	lastName varchar(75),
	email varchar(75),
	organizationId int8,
	createUser int8
)
extent size 16 next size 16
lock mode row;

create table sdr_SimulationJob (
	simulationId int8 not null primary key,
	simulationUuid varchar(2000),
	jobUuid varchar(2000),
	inputId varchar(2000),
	title varchar(75),
	description varchar(2000),
	status varchar(75),
	simulationStartDt datetime YEAR TO FRACTION,
	simulationEndDt datetime YEAR TO FRACTION,
	userId int8,
	groupId int8,
	companyId int8
)
extent size 16 next size 16
lock mode row;


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


