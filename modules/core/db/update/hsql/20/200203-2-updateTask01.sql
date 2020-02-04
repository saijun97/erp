alter table ERP_TASK add constraint FK_ERP_TASK_ON_COUNTRY foreign key (COUNTRY_ID) references ERP_COUNTRY(ID);
create index IDX_ERP_TASK_ON_COUNTRY on ERP_TASK (COUNTRY_ID);
