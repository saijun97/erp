alter table ERP_EMPLOYEE_SUBUNIT_LINK add constraint FK_EMPSUB_ON_SUBUNIT foreign key (SUBUNIT_ID) references ERP_SUBUNIT(ID);
alter table ERP_EMPLOYEE_SUBUNIT_LINK add constraint FK_EMPSUB_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID);