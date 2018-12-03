create index IX_C4365591 on sdr_bbs_Bbs (companyId, groupId);
create index IX_C428545 on sdr_bbs_Bbs (uuid_);
create index IX_51C3F1C3 on sdr_bbs_Bbs (uuid_, companyId);
create unique index IX_40140D05 on sdr_bbs_Bbs (uuid_, groupId);

create index IX_465B76EB on sdr_bbs_BbsComment (postId);
create index IX_C2B49D8 on sdr_bbs_BbsComment (uuid_);

create index IX_90EC2B2F on sdr_bbs_BbsPost (bbsId);
create index IX_CABB231A on sdr_bbs_BbsPost (bbsId, content);
create index IX_2C9734F9 on sdr_bbs_BbsPost (bbsId, title);
create index IX_67B78356 on sdr_bbs_BbsPost (bbsId, writer);
create index IX_9DEDED05 on sdr_bbs_BbsPost (uuid_);