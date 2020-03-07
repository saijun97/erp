alter table ERP_PORTAL_MESSAGES add column SUBJECT text ^
update ERP_PORTAL_MESSAGES set SUBJECT = '' where SUBJECT is null ;
alter table ERP_PORTAL_MESSAGES alter column SUBJECT set not null ;
