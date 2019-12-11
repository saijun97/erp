alter table ERP_CITY add constraint FK_ERP_CITY_ON_COUNTRY foreign key (COUNTRY_ID) references ERP_COUNTRY(ID);
create index IDX_ERP_CITY_ON_COUNTRY on ERP_CITY (COUNTRY_ID);
