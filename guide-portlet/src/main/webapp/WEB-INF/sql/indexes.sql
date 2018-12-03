create index IX_D8B56FB0 on SDR_Guide (uuid_);
create index IX_427AE678 on SDR_Guide (uuid_, companyId);
create unique index IX_8FFAAAFA on SDR_Guide (uuid_, groupId);

create index IX_A0BADB1F on test_Guide (uuid_);
create index IX_4B7B4FA9 on test_Guide (uuid_, companyId);
create unique index IX_9BB5AC6B on test_Guide (uuid_, groupId);