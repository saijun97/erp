alter table ERP_TASK add constraint FK_ERP_TASK_ON_CITY foreign key (CITY_ID) references ERP_CITY(ID);
create index IDX_ERP_TASK_ON_CITY on ERP_TASK (CITY_ID);
