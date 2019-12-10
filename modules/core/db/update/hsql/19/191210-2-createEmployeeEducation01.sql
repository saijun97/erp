alter table ERP_EMPLOYEE_EDUCATION add constraint FK_ERP_EMPLOYEE_EDUCATION_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID);
alter table ERP_EMPLOYEE_EDUCATION add constraint FK_ERP_EMPLOYEE_EDUCATION_ON_EDUCATION foreign key (EDUCATION_ID) references ERP_EDUCATION(ID);
create unique index IDX_ERP_EMPLOYEE_EDUCATION_UNIQ_EDUCATION_ID on ERP_EMPLOYEE_EDUCATION (EDUCATION_ID) ;
create index IDX_ERP_EMPLOYEE_EDUCATION_ON_EMPLOYEE on ERP_EMPLOYEE_EDUCATION (EMPLOYEE_ID);
create index IDX_ERP_EMPLOYEE_EDUCATION_ON_EDUCATION on ERP_EMPLOYEE_EDUCATION (EDUCATION_ID);
