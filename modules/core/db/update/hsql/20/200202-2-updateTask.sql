alter table ERP_TASK alter column LOCATION rename to LOCATION__U65672 ^
-- alter table ERP_TASK add column COUNTRY_ID varchar(36) ^
-- update ERP_TASK set COUNTRY_ID = <default_value> ;
-- alter table ERP_TASK alter column COUNTRY_ID set not null ;
alter table ERP_TASK add column COUNTRY_ID varchar(36) not null ;
alter table ERP_TASK add column CITY_ID varchar(36) ;
