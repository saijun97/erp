alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_USER foreign key (USER_ID) references SEC_USER(ID);
create index IDX_ERP_EMPLOYEE_ON_USER on ERP_EMPLOYEE (USER_ID);
