alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_CITY foreign key (CITY_ID) references ERP_CITY(ID);
create index IDX_ERP_EMPLOYEE_ON_CITY on ERP_EMPLOYEE (CITY_ID);
