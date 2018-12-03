create table sdr_popup_Popup (
	popupId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	title VARCHAR(75) null,
	startDate DATE null,
	finishDate DATE null,
	width INTEGER,
	height INTEGER,
	enable BOOLEAN,
	imgPath LONG
);