-- begin ERP_SUBUNIT
alter table ERP_SUBUNIT add constraint FK_ERP_SUBUNIT_ON_DEPARTMENT foreign key (DEPARTMENT_ID) references ERP_DEPARTMENT(ID)^
create index IDX_ERP_SUBUNIT_ON_DEPARTMENT on ERP_SUBUNIT (DEPARTMENT_ID)^
-- end ERP_SUBUNIT
-- begin ERP_WORK_EXPERIENCE
alter table ERP_WORK_EXPERIENCE add constraint FK_ERP_WORK_EXPERIENCE_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
create index IDX_ERP_WORK_EXPERIENCE_ON_EMPLOYEE on ERP_WORK_EXPERIENCE (EMPLOYEE_ID)^
-- end ERP_WORK_EXPERIENCE
-- begin ERP_EMPLOYEE_LANGUAGE
alter table ERP_EMPLOYEE_LANGUAGE add constraint FK_ERP_EMPLOYEE_LANGUAGE_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
alter table ERP_EMPLOYEE_LANGUAGE add constraint FK_ERP_EMPLOYEE_LANGUAGE_ON_LANGUAGE foreign key (LANGUAGE_ID) references ERP_LANGUAGE(ID)^
create index IDX_ERP_EMPLOYEE_LANGUAGE_ON_EMPLOYEE on ERP_EMPLOYEE_LANGUAGE (EMPLOYEE_ID)^
create index IDX_ERP_EMPLOYEE_LANGUAGE_ON_LANGUAGE on ERP_EMPLOYEE_LANGUAGE (LANGUAGE_ID)^
-- end ERP_EMPLOYEE_LANGUAGE
-- begin ERP_ORDER
alter table ERP_ORDER add constraint FK_ERP_ORDER_ON_CLIENT foreign key (CLIENT_ID) references ERP_CLIENT(ID)^
create index IDX_ERP_ORDER_ON_CLIENT on ERP_ORDER (CLIENT_ID)^
-- end ERP_ORDER
-- begin ERP_EMPLOYEE_EDUCATION
alter table ERP_EMPLOYEE_EDUCATION add constraint FK_ERP_EMPLOYEE_EDUCATION_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
alter table ERP_EMPLOYEE_EDUCATION add constraint FK_ERP_EMPLOYEE_EDUCATION_ON_EDUCATION foreign key (EDUCATION_ID) references ERP_EDUCATION(ID)^
create index IDX_ERP_EMPLOYEE_EDUCATION_ON_EMPLOYEE on ERP_EMPLOYEE_EDUCATION (EMPLOYEE_ID)^
create index IDX_ERP_EMPLOYEE_EDUCATION_ON_EDUCATION on ERP_EMPLOYEE_EDUCATION (EDUCATION_ID)^
-- end ERP_EMPLOYEE_EDUCATION
-- begin ERP_EMPLOYEE_SKILL
alter table ERP_EMPLOYEE_SKILL add constraint FK_ERP_EMPLOYEE_SKILL_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
alter table ERP_EMPLOYEE_SKILL add constraint FK_ERP_EMPLOYEE_SKILL_ON_SKILL foreign key (SKILL_ID) references ERP_SKILL(ID)^
create index IDX_ERP_EMPLOYEE_SKILL_ON_EMPLOYEE on ERP_EMPLOYEE_SKILL (EMPLOYEE_ID)^
create index IDX_ERP_EMPLOYEE_SKILL_ON_SKILL on ERP_EMPLOYEE_SKILL (SKILL_ID)^
-- end ERP_EMPLOYEE_SKILL
-- begin ERP_DEPARTMENT
create unique index IDX_ERP_DEPARTMENT_UNIQ_DEPARTMENT on ERP_DEPARTMENT (DEPARTMENT) ^
-- end ERP_DEPARTMENT
-- begin ERP_CITY
alter table ERP_CITY add constraint FK_ERP_CITY_ON_COUNTRY foreign key (COUNTRY_ID) references ERP_COUNTRY(ID)^
create index IDX_ERP_CITY_ON_COUNTRY on ERP_CITY (COUNTRY_ID)^
-- end ERP_CITY
-- begin ERP_COUNTRY
create unique index IDX_ERP_COUNTRY_UNIQ_COUNTRY on ERP_COUNTRY (COUNTRY) ^
create unique index IDX_ERP_COUNTRY_UNIQ_COUNTRY_CODE on ERP_COUNTRY (COUNTRY_CODE) ^
-- end ERP_COUNTRY
-- begin ERP_EMPLOYEE_LICENSE
alter table ERP_EMPLOYEE_LICENSE add constraint FK_ERP_EMPLOYEE_LICENSE_ON_LICENSE foreign key (LICENSE_ID) references ERP_LICENSE(ID)^
alter table ERP_EMPLOYEE_LICENSE add constraint FK_ERP_EMPLOYEE_LICENSE_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
create unique index IDX_ERP_EMPLOYEE_LICENSE_UNIQ_LICENSE_NUMBER on ERP_EMPLOYEE_LICENSE (LICENSE_NUMBER) ^
create index IDX_ERP_EMPLOYEE_LICENSE_ON_LICENSE on ERP_EMPLOYEE_LICENSE (LICENSE_ID)^
create index IDX_ERP_EMPLOYEE_LICENSE_ON_EMPLOYEE on ERP_EMPLOYEE_LICENSE (EMPLOYEE_ID)^
-- end ERP_EMPLOYEE_LICENSE
-- begin ERP_PERSON
create unique index IDX_ERP_PERSON_UNIQ_EMAIL on ERP_PERSON (EMAIL) ^
create unique index IDX_ERP_PERSON_UNIQ_MOBILE_PHONE on ERP_PERSON (MOBILE_PHONE) ^
-- end ERP_PERSON
-- begin ERP_LICENSE
create unique index IDX_ERP_LICENSE_UNIQ_NAME on ERP_LICENSE (NAME) ^
-- end ERP_LICENSE
-- begin ERP_LANGUAGE
create unique index IDX_ERP_LANGUAGE_UNIQ_NAME on ERP_LANGUAGE (NAME) ^
-- end ERP_LANGUAGE
-- begin ERP_EDUCATION
create unique index IDX_ERP_EDUCATION_UNIQ_NAME on ERP_EDUCATION (NAME) ^
-- end ERP_EDUCATION
-- begin ERP_SKILL
create unique index IDX_ERP_SKILL_UNIQ_NAME on ERP_SKILL (NAME) ^
-- end ERP_SKILL
-- begin ERP_JOB_POSITION
create unique index IDX_ERP_JOB_POSITION_UNIQ_NAME on ERP_JOB_POSITION (NAME) ^
-- end ERP_JOB_POSITION
-- begin ERP_EMPLOYEE
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_NATIONALITY foreign key (NATIONALITY_ID) references ERP_COUNTRY(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_CITY foreign key (CITY_ID) references ERP_CITY(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_DEPARTMENT foreign key (DEPARTMENT_ID) references ERP_DEPARTMENT(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_SUBUNIT foreign key (SUBUNIT_ID) references ERP_SUBUNIT(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_JOB_POSITION foreign key (JOB_POSITION_ID) references ERP_JOB_POSITION(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_ID foreign key (ID) references ERP_PERSON(ID) on delete CASCADE^
create unique index IDX_ERP_EMPLOYEE_UNIQ_NIC on ERP_EMPLOYEE (NIC) ^
create unique index IDX_ERP_EMPLOYEE_UNIQ_EMP_ID on ERP_EMPLOYEE (EMP_ID) ^
create index IDX_ERP_EMPLOYEE_ON_NATIONALITY on ERP_EMPLOYEE (NATIONALITY_ID)^
create index IDX_ERP_EMPLOYEE_ON_CITY on ERP_EMPLOYEE (CITY_ID)^
create index IDX_ERP_EMPLOYEE_ON_DEPARTMENT on ERP_EMPLOYEE (DEPARTMENT_ID)^
create index IDX_ERP_EMPLOYEE_ON_SUBUNIT on ERP_EMPLOYEE (SUBUNIT_ID)^
create index IDX_ERP_EMPLOYEE_ON_JOB_POSITION on ERP_EMPLOYEE (JOB_POSITION_ID)^
-- end ERP_EMPLOYEE
-- begin ERP_CLIENT_PERSON
alter table ERP_CLIENT_PERSON add constraint FK_ERP_CLIENT_PERSON_ON_ID foreign key (ID) references ERP_CLIENT(ID) on delete CASCADE^
-- end ERP_CLIENT_PERSON
-- begin ERP_CLIENT_COMPANY
alter table ERP_CLIENT_COMPANY add constraint FK_ERP_CLIENT_COMPANY_ON_ID foreign key (ID) references ERP_CLIENT(ID) on delete CASCADE^
-- end ERP_CLIENT_COMPANY
