create table sdr_bbs_Bbs (
	uuid_ VARCHAR(75) null,
	bbsId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	title VARCHAR(75) null,
	displayType INTEGER
);

create table sdr_bbs_BbsComment (
	uuid_ VARCHAR(75) null,
	commentId LONG not null primary key,
	postId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	writer VARCHAR(75) null,
	email VARCHAR(75) null,
	password_ VARCHAR(75) null,
	content VARCHAR(75) null,
	secret BOOLEAN
);

create table sdr_bbs_BbsPost (
	uuid_ VARCHAR(75) null,
	postId LONG not null primary key,
	bbsId LONG,
	userId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	writer VARCHAR(75) null,
	email VARCHAR(75) null,
	password_ VARCHAR(75) null,
	title VARCHAR(75) null,
	content VARCHAR(2000) null,
	secret BOOLEAN,
	commentEmailed BOOLEAN,
	viewCount INTEGER
);