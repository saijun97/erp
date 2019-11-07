alter table ERP_EMPLOYEE rename column country_id to country_id__u34568 ;
drop index IDX_ERP_EMPLOYEE_ON_COUNTRY ;
alter table ERP_EMPLOYEE rename column user_id to user_id__u42257 ;
alter table ERP_EMPLOYEE drop constraint FK_ERP_EMPLOYEE_ON_USER ;
drop index IDX_ERP_EMPLOYEE_ON_USER ;
alter table ERP_EMPLOYEE rename column dateofbirth to dateofbirth__u51866 ;
alter table ERP_EMPLOYEE alter column dateofbirth__u51866 drop not null ;
-- alter table ERP_EMPLOYEE add column DEPARTMENT_ID uuid ^
-- update ERP_EMPLOYEE set DEPARTMENT_ID = <default_value> ;
-- alter table ERP_EMPLOYEE alter column DEPARTMENT_ID set not null ;
alter table ERP_EMPLOYEE add column DEPARTMENT_ID uuid not null ;
alter table ERP_EMPLOYEE add column HOME_PHONE varchar(255) ;
alter table ERP_EMPLOYEE add column SUBUNIT_ID uuid ;
-- alter table ERP_EMPLOYEE add column EMP_ID varchar(255) ^
-- update ERP_EMPLOYEE set EMP_ID = <default_value> ;
-- alter table ERP_EMPLOYEE alter column EMP_ID set not null ;
alter table ERP_EMPLOYEE add column EMP_ID varchar(255) ;
alter table ERP_EMPLOYEE add column DOB date ^
update ERP_EMPLOYEE set DOB = current_date where DOB is null ;
alter table ERP_EMPLOYEE alter column DOB set not null ;
alter table ERP_EMPLOYEE add column MOBILE_PHONE varchar(255) ;
alter table ERP_EMPLOYEE alter column NIC drop not null ;
