create table sdr_ApiKey (
	userId LONG not null primary key,
	apiKey VARCHAR(75) null
);

create table sdr_AssetEntries_AssetTags (
	entryId LONG not null,
	tagId LONG not null,
	primary key (entryId, tagId)
);

create table sdr_Collection (
	collectionId LONG not null primary key,
	title VARCHAR(200) null,
	userId LONG,
	createDate DATE null,
	description VARCHAR(2000) null,
	usageRight VARCHAR(75) null,
	doi VARCHAR(100) null,
	accessPolicy INTEGER,
	groupId LONG,
	companyId LONG,
	skipCurate BOOLEAN
);

create table sdr_Collection_AllowedUser (
	collectionId LONG not null,
	userId LONG not null,
	primary key (collectionId, userId)
);

create table sdr_Collection_User (
	collectionId LONG not null,
	userId LONG not null,
	primary key (collectionId, userId)
);

create table sdr_Curate (
	curateId LONG not null primary key,
	title VARCHAR(200) null,
	createDate DATE null,
	endDate DATE null,
	log_ TEXT null,
	datasetId LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null
);

create table sdr_CurationJob (
	simulationId LONG not null primary key,
	simulationUuid VARCHAR(75) null,
	jobUuid VARCHAR(75) null,
	description VARCHAR(75) null,
	status VARCHAR(75) null,
	simulationStartDt DATE null,
	simulationEndDt DATE null
);

create table sdr_DataType (
	dataTypeId LONG not null primary key,
	title VARCHAR(200) null,
	description VARCHAR(2000) null,
	fileValidationRule VARCHAR(75) null,
	userId LONG,
	allowedUserId LONG,
	groupId LONG,
	companyId LONG,
	curateRequired BOOLEAN,
	location VARCHAR(200) null,
	dockerImage VARCHAR(75) null,
	defaultPpLogicId LONG,
	status INTEGER
);

create table sdr_DataTypeSchema (
	dataTypeSchemaId LONG not null primary key,
	title VARCHAR(200) null,
	reference VARCHAR(75) null,
	variableType VARCHAR(75) null,
	variableUnit VARCHAR(75) null,
	essential BOOLEAN null,
	minimum DOUBLE null,
	maximum DOUBLE null,
	enums VARCHAR(75) null,
	pattern VARCHAR(75) null,
	description VARCHAR(2000) null,
	userId LONG,
	groupId LONG,
	companyId LONG,
	createUserId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER
);

create table sdr_DataType_dataTypeSchema (
	dataTypeId LONG not null,
	dataTypeSchemaId LONG not null,
	primary key (dataTypeId, dataTypeSchemaId)
);

create table sdr_DataType_dataTypeSchema_essential (
	dataTypeId LONG not null,
	dataTypeSchemaId LONG not null,
	essential BOOLEAN,
	primary key (dataTypeId, dataTypeSchemaId)
);

create table sdr_DataView (
	dataViewId LONG not null primary key,
	title VARCHAR(200) null,
	dataTypeId LONG,
	html TEXT null,
	description VARCHAR(2000) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	status INTEGER,
	orderNo INTEGER
);

create table sdr_DataViewComponents (
	dataViewComponentsId LONG not null primary key,
	compGroup VARCHAR(100) null,
	compName VARCHAR(100) null,
	image VARCHAR(200) null,
	html STRING null,
	script STRING null,
	properties STRING null,
	description STRING null,
	orderNo INTEGER,
	groupId LONG,
	companyId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER
);

create table sdr_Dataset (
	datasetId LONG not null primary key,
	title VARCHAR(200) null,
	descriptiveMetadata TEXT null,
	provenanceMetadata TEXT null,
	description STRING null,
	location VARCHAR(200) null,
	metalocation VARCHAR(200) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	publishDate DATE null,
	version LONG,
	checksum VARCHAR(200) null,
	doi VARCHAR(100) null,
	remote BOOLEAN,
	repository INTEGER,
	fileFinalized BOOLEAN,
	fileNum INTEGER,
	hashcode INTEGER,
	curateSignature INTEGER,
	retrieveSignature INTEGER,
	curateLogCode INTEGER,
	curateLogDate DATE null,
	curateErrorCode INTEGER,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	collectionId LONG,
	dataTypeId LONG,
	ppLogicId LONG,
	curateId LONG,
	parent LONG,
	grId LONG
);

create table sdr_DatatypeRule (
	drId LONG not null primary key,
	grId LONG,
	dataTypeId LONG
);

create table sdr_GroupRule (
	grId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(2000) null,
	rule VARCHAR(75) null,
	viewAttr VARCHAR(75) null,
	mergeAttr VARCHAR(75) null
);

create table sdr_IceBreakerVcToken (
	vcToken VARCHAR(1000) null,
	vcTokenExpired DATE null,
	resultCode INTEGER,
	tokenId LONG not null primary key,
	activate INTEGER
);

create table sdr_MlGuiParameter (
	mlGuiParameterId LONG not null primary key,
	parentId LONG,
	kind VARCHAR(75) null,
	displayName VARCHAR(75) null,
	valueType VARCHAR(75) null,
	value VARCHAR(75) null,
	image VARCHAR(75) null,
	option_ VARCHAR(2000) null,
	description VARCHAR(2000) null
);

create table sdr_PpLogic (
	ppId LONG not null primary key,
	userId LONG,
	title VARCHAR(75) null,
	description VARCHAR(2000) null,
	type_ INTEGER,
	command VARCHAR(2000) null,
	dataTypeId LONG
);

create table sdr_ReqMakeSite (
	requestId LONG not null primary key,
	name VARCHAR(75) null,
	description VARCHAR(2000) null,
	siteType LONG,
	userId LONG,
	requestDate DATE null,
	confirmDate DATE null,
	message VARCHAR(2000) null,
	status LONG,
	answer VARCHAR(2000) null
);

create table sdr_SdrOrganizations (
	organizationId LONG not null primary key,
	organizationName VARCHAR(75) null,
	description VARCHAR(75) null,
	url VARCHAR(75) null,
	address VARCHAR(75) null,
	zipcode VARCHAR(75) null,
	city VARCHAR(75) null,
	country VARCHAR(75) null
);

create table sdr_SdrUsers (
	userId LONG not null primary key,
	firstName VARCHAR(50) null,
	lastName VARCHAR(50) null,
	email VARCHAR(100) null,
	organizationId LONG,
	createUser LONG
);

create table sdr_SimulationJob (
	simulationId LONG not null primary key,
	simulationUuid VARCHAR(2000) null,
	jobUuid VARCHAR(2000) null,
	inputId VARCHAR(2000) null,
	title VARCHAR(75) null,
	description VARCHAR(2000) null,
	status VARCHAR(75) null,
	simulationStartDt DATE null,
	simulationEndDt DATE null,
	userId LONG,
	groupId LONG,
	companyId LONG
);

create table sdr_datatypeRuleRelation (
	gtrrId LONG not null primary key,
	grId LONG,
	dataTypeId LONG
);

create table sdr_groupRule (
	grId LONG not null primary key,
	title VARCHAR(75) null,
	description VARCHAR(75) null,
	rule VARCHAR(75) null,
	viewAttribute VARCHAR(75) null,
	notToMergeAttribute VARCHAR(75) null
);