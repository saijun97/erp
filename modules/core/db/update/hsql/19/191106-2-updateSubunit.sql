alter table ERP_SUBUNIT alter column EMPLOYEE_ID rename to EMPLOYEE_ID__U03057 ^
alter table ERP_SUBUNIT alter column EMPLOYEE_ID__U03057 set null ;
alter table ERP_SUBUNIT drop constraint FK_ERP_SUBUNIT_ON_EMPLOYEE ;
drop index IDX_ERP_SUBUNIT_ON_EMPLOYEE ;
