alter table ERP_TASK add constraint FK_ERP_TASK_ON_ORDER_NUM foreign key (ORDER_NUM_ID) references ERP_ORDER(ID);
alter table ERP_TASK add constraint FK_ERP_TASK_ON_CLIENT foreign key (CLIENT_ID) references ERP_CLIENT(ID);
alter table ERP_TASK add constraint FK_ERP_TASK_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID);
create unique index IDX_ERP_TASK_UNIQ_TASK_NUM on ERP_TASK (TASK_NUM) ;
create index IDX_ERP_TASK_ON_ORDER_NUM on ERP_TASK (ORDER_NUM_ID);
create index IDX_ERP_TASK_ON_CLIENT on ERP_TASK (CLIENT_ID);
create index IDX_ERP_TASK_ON_EMPLOYEE on ERP_TASK (EMPLOYEE_ID);
