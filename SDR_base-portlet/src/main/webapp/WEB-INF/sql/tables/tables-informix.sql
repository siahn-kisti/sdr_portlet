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
