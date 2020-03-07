alter table ERP_PORTAL_MESSAGES add column RECEIVED_TS timestamp ^
update ERP_PORTAL_MESSAGES set RECEIVED_TS = current_timestamp where RECEIVED_TS is null ;
alter table ERP_PORTAL_MESSAGES alter column RECEIVED_TS set not null ;
