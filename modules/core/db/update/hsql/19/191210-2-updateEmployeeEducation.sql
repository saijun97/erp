alter table ERP_EMPLOYEE_EDUCATION add column YEAR_ date ;
alter table ERP_EMPLOYEE_EDUCATION add column MAJOR_SPECIALIZATION varchar(255) ;
alter table ERP_EMPLOYEE_EDUCATION add column INSTITUTE varchar(255) ^
update ERP_EMPLOYEE_EDUCATION set INSTITUTE = '' where INSTITUTE is null ;
alter table ERP_EMPLOYEE_EDUCATION alter column INSTITUTE set not null ;
alter table ERP_EMPLOYEE_EDUCATION add column END_DATE date ;
alter table ERP_EMPLOYEE_EDUCATION add column START_DATE date ;
alter table ERP_EMPLOYEE_EDUCATION add column GPA_SCORE integer ;
