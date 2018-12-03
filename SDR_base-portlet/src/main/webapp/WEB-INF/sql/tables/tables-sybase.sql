create table sdr_ApiKey (
	userId decimal(20,0) not null primary key,
	apiKey varchar(75) null
)
go

create table sdr_AssetEntries_AssetTags (
	entryId decimal(20,0) not null,
	tagId decimal(20,0) not null,
	primary key (entryId, tagId)
)
go

create table sdr_Collection (
	collectionId decimal(20,0) not null primary key,
	title varchar(200) null,
	userId decimal(20,0),
	createDate datetime null,
	description varchar(2000) null,
	usageRight varchar(75) null,
	doi varchar(100) null,
	accessPolicy int,
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table sdr_Collection_AllowedUser (
	collectionId decimal(20,0) not null,
	userId decimal(20,0) not null,
	primary key (collectionId, userId)
)
go

create table sdr_Collection_User (
	collectionId decimal(20,0) not null,
	userId decimal(20,0) not null,
	primary key (collectionId, userId)
)
go

create table sdr_Curate (
	curateId decimal(20,0) not null primary key,
	title varchar(200) null,
	createDate datetime null,
	endDate datetime null,
	log_ text null,
	datasetId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	userName varchar(75) null
)
go

create table sdr_DataType (
	dataTypeId decimal(20,0) not null primary key,
	title varchar(200) null,
	description varchar(2000) null,
	fileValidationRule varchar(75) null,
	groupId decimal(20,0),
	companyId decimal(20,0),
	curateRequired int,
	location varchar(75) null
)
go

create table sdr_DataTypeSchema (
	dataTypeSchemaId decimal(20,0) not null primary key,
	dataTypeId decimal(20,0),
	title varchar(200) null,
	reference varchar(75) null,
	variableType varchar(75) null,
	variableUnit varchar(75) null,
	essential int,
	minimum float,
	maximum float,
	enums varchar(75) null,
	pattern varchar(75) null,
	description varchar(2000) null,
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go

create table sdr_DataView (
	dataViewId decimal(20,0) not null primary key,
	title varchar(200) null,
	dataTypeId decimal(20,0),
	html text null,
	description varchar(2000) null,
	groupId decimal(20,0),
	companyId decimal(20,0),
	userId decimal(20,0),
	status int,
	orderNo int
)
go

create table sdr_Dataset (
	datasetId decimal(20,0) not null primary key,
	title varchar(200) null,
	userId decimal(20,0),
	userName varchar(75) null,
	createDate datetime null,
	publishDate datetime null,
	version int,
	checksum varchar(200) null,
	doi varchar(100) null,
	descriptiveMetadata text null,
	provenanceMetadata text null,
	description varchar(2000) null,
	location varchar(200) null,
	metalocation varchar(200) null,
	groupId decimal(20,0),
	companyId decimal(20,0),
	remote int,
	fileFinalized int,
	fileNum int,
	hashcode int,
	status int,
	statusByUserId decimal(20,0),
	statusByUserName varchar(75) null,
	statusDate datetime null,
	collectionId decimal(20,0),
	dataTypeId decimal(20,0),
	curateId decimal(20,0)
)
go

create table sdr_IceBreakerVcToken (
	vcToken varchar(1000) null,
	vcTokenExpired datetime null,
	resultCode int,
	tokenId decimal(20,0) not null primary key,
	activate int
)
go

create table sdr_ReqMakeSite (
	requestId decimal(20,0) not null primary key,
	name varchar(75) null,
	description varchar(2000) null,
	siteType decimal(20,0),
	userId decimal(20,0),
	requestDate datetime null,
	confirmDate datetime null,
	message varchar(2000) null,
	status decimal(20,0),
	answer varchar(2000) null
)
go

create table sdr_SdrOrganizations (
	organizationId decimal(20,0) not null primary key,
	organizationName varchar(75) null,
	description varchar(75) null,
	url varchar(75) null,
	address varchar(75) null,
	zipcode varchar(75) null,
	city varchar(75) null,
	country varchar(75) null
)
go

create table sdr_SdrUsers (
	userId decimal(20,0) not null primary key,
	firstName varchar(75) null,
	lastName varchar(75) null,
	email varchar(75) null,
	organizationId decimal(20,0),
	createUser decimal(20,0)
)
go

create table sdr_SimulationJob (
	simulationId decimal(20,0) not null primary key,
	simulationUuid varchar(2000) null,
	jobUuid varchar(2000) null,
	inputId varchar(2000) null,
	title varchar(75) null,
	description varchar(2000) null,
	status varchar(75) null,
	simulationStartDt datetime null,
	simulationEndDt datetime null,
	userId decimal(20,0),
	groupId decimal(20,0),
	companyId decimal(20,0)
)
go
