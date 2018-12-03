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
