create index IX_D6C3FD0F on Person (groupId);
create index IX_6F1243AE on Person (nationalCode[$COLUMN_LENGTH:75$]);
create index IX_170E9B2F on Person (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_2C922171 on Person (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4E5B8A61 on mgk_Person (groupId);
create index IX_4518399C on mgk_Person (nationalCode[$COLUMN_LENGTH:75$]);
create index IX_EC2BEA1D on mgk_Person (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_98F253DF on mgk_Person (uuid_[$COLUMN_LENGTH:75$], groupId);