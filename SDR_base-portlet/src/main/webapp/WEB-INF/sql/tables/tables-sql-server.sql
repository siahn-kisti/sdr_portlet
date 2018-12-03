create table sdr_ApiKey (
	userId bigint not null primary key,
	apiKey nvarchar(75) null
);

create table sdr_AssetEntries_AssetTags (
	entryId bigint not null,
	tagId bigint not null,
	primary key (entryId, tagId)
);

create table sdr_Collection (
	collectionId bigint not null primary key,
	title nvarchar(200) null,
	userId bigint,
	createDate datetime null,
	description nvarchar(2000) null,
	usageRight nvarchar(75) null,
	doi nvarchar(100) null,
	accessPolicy int,
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
	title nvarchar(200) null,
	createDate datetime null,
	endDate datetime null,
	log_ nvarchar(max) null,
	datasetId bigint,
	groupId bigint,
	companyId bigint,
	userId bigint,
	userName nvarchar(75) null
);

create table sdr_DataType (
	dataTypeId bigint not null primary key,
	title nvarchar(200) null,
	description nvarchar(2000) null,
	fileValidationRule nvarchar(75) null,
	groupId bigint,
	companyId bigint,
	curateRequired bit,
	location nvarchar(75) null
);

create table sdr_DataTypeSchema (
	dataTypeSchemaId bigint not null primary key,
	dataTypeId bigint,
	title nvarchar(200) null,
	reference nvarchar(75) null,
	variableType nvarchar(75) null,
	variableUnit nvarchar(75) null,
	essential bit,
	minimum float,
	maximum float,
	enums nvarchar(75) null,
	pattern nvarchar(75) null,
	description nvarchar(2000) null,
	groupId bigint,
	companyId bigint
);

create table sdr_DataView (
	dataViewId bigint not null primary key,
	title nvarchar(200) null,
	dataTypeId bigint,
	html nvarchar(max) null,
	description nvarchar(2000) null,
	groupId bigint,
	companyId bigint,
	userId bigint,
	status int,
	orderNo int
);

create table sdr_Dataset (
	datasetId bigint not null primary key,
	title nvarchar(200) null,
	userId bigint,
	userName nvarchar(75) null,
	createDate datetime null,
	publishDate datetime null,
	version int,
	checksum nvarchar(200) null,
	doi nvarchar(100) null,
	descriptiveMetadata nvarchar(max) null,
	provenanceMetadata nvarchar(max) null,
	description nvarchar(2000) null,
	location nvarchar(200) null,
	metalocation nvarchar(200) null,
	groupId bigint,
	companyId bigint,
	remote bit,
	fileFinalized bit,
	fileNum int,
	hashcode int,
	status int,
	statusByUserId bigint,
	statusByUserName nvarchar(75) null,
	statusDate datetime null,
	collectionId bigint,
	dataTypeId bigint,
	curateId bigint
);

create table sdr_IceBreakerVcToken (
	vcToken nvarchar(1000) null,
	vcTokenExpired datetime null,
	resultCode int,
	tokenId bigint not null primary key,
	activate int
);

create table sdr_ReqMakeSite (
	requestId bigint not null primary key,
	name nvarchar(75) null,
	description nvarchar(2000) null,
	siteType bigint,
	userId bigint,
	requestDate datetime null,
	confirmDate datetime null,
	message nvarchar(2000) null,
	status bigint,
	answer nvarchar(2000) null
);

create table sdr_SdrOrganizations (
	organizationId bigint not null primary key,
	organizationName nvarchar(75) null,
	description nvarchar(75) null,
	url nvarchar(75) null,
	address nvarchar(75) null,
	zipcode nvarchar(75) null,
	city nvarchar(75) null,
	country nvarchar(75) null
);

create table sdr_SdrUsers (
	userId bigint not null primary key,
	firstName nvarchar(75) null,
	lastName nvarchar(75) null,
	email nvarchar(75) null,
	organizationId bigint,
	createUser bigint
);

create table sdr_SimulationJob (
	simulationId bigint not null primary key,
	simulationUuid nvarchar(2000) null,
	jobUuid nvarchar(2000) null,
	inputId nvarchar(2000) null,
	title nvarchar(75) null,
	description nvarchar(2000) null,
	status nvarchar(75) null,
	simulationStartDt datetime null,
	simulationEndDt datetime null,
	userId bigint,
	groupId bigint,
	companyId bigint
);
