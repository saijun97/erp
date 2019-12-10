alter table ERP_EMPLOYEE_LANGUAGE add constraint FK_ERP_EMPLOYEE_LANGUAGE_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID);
alter table ERP_EMPLOYEE_LANGUAGE add constraint FK_ERP_EMPLOYEE_LANGUAGE_ON_LANGUAGE foreign key (LANGUAGE_ID) references ERP_LANGUAGE(ID);
create unique index IDX_ERP_EMPLOYEE_LANGUAGE_UNIQ_LANGUAGE_ID on ERP_EMPLOYEE_LANGUAGE (LANGUAGE_ID) ;
create index IDX_ERP_EMPLOYEE_LANGUAGE_ON_EMPLOYEE on ERP_EMPLOYEE_LANGUAGE (EMPLOYEE_ID);
create index IDX_ERP_EMPLOYEE_LANGUAGE_ON_LANGUAGE on ERP_EMPLOYEE_LANGUAGE (LANGUAGE_ID);
