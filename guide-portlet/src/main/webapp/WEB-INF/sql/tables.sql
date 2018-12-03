create table SDR_Guide (
	uuid_ VARCHAR(75) null,
	datasetId LONG not null primary key,
	title VARCHAR(75) null,
	dataType VARCHAR(75) null,
	contributors VARCHAR(75) null,
	collectionName VARCHAR(75) null,
	keyword VARCHAR(75) null,
	description VARCHAR(75) null,
	dataFileId LONG,
	dataFileName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deleteDate DATE null
);

create table test_Guide (
	uuid_ VARCHAR(75) null,
	datasetId LONG not null primary key,
	title VARCHAR(75) null,
	dataType VARCHAR(75) null,
	contributors VARCHAR(75) null,
	collectionName VARCHAR(75) null,
	keyword VARCHAR(75) null,
	description VARCHAR(75) null,
	dataFileId LONG,
	dataFileName VARCHAR(75) null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	deleteDate DATE null
);