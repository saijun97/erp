-- begin ERP_SERVICE_REQUEST
alter table ERP_SERVICE_REQUEST add constraint FK_ERP_SERVICE_REQUEST_ON_EXISTING_CLIENT foreign key (EXISTING_CLIENT_ID) references ERP_CLIENT(ID)^
create unique index IDX_ERP_SERVICE_REQUEST_UNIQ_REFERENCE_NUMBER on ERP_SERVICE_REQUEST (REFERENCE_NUMBER) ^
create index IDX_ERP_SERVICE_REQUEST_ON_EXISTING_CLIENT on ERP_SERVICE_REQUEST (EXISTING_CLIENT_ID)^
-- end ERP_SERVICE_REQUEST
-- begin ERP_COMPANY_CONTACT_PERSONS
alter table ERP_COMPANY_CONTACT_PERSONS add constraint FK_ERP_COMPANY_CONTACT_PERSONS_ON_CLIENT_COMPANY foreign key (CLIENT_COMPANY_ID) references ERP_CLIENT_COMPANY(ID)^
alter table ERP_COMPANY_CONTACT_PERSONS add constraint FK_ERP_COMPANY_CONTACT_PERSONS_ON_CONTACT_PERSON foreign key (CONTACT_PERSON_ID) references ERP_CONTACT_PERSON(ID)^
create index IDX_ERP_COMPANY_CONTACT_PERSONS_ON_CLIENT_COMPANY on ERP_COMPANY_CONTACT_PERSONS (CLIENT_COMPANY_ID)^
create index IDX_ERP_COMPANY_CONTACT_PERSONS_ON_CONTACT_PERSON on ERP_COMPANY_CONTACT_PERSONS (CONTACT_PERSON_ID)^
-- end ERP_COMPANY_CONTACT_PERSONS
-- begin ERP_EMPLOYEE_SKILL
alter table ERP_EMPLOYEE_SKILL add constraint FK_ERP_EMPLOYEE_SKILL_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
alter table ERP_EMPLOYEE_SKILL add constraint FK_ERP_EMPLOYEE_SKILL_ON_SKILL foreign key (SKILL_ID) references ERP_SKILL(ID)^
create index IDX_ERP_EMPLOYEE_SKILL_ON_EMPLOYEE on ERP_EMPLOYEE_SKILL (EMPLOYEE_ID)^
create index IDX_ERP_EMPLOYEE_SKILL_ON_SKILL on ERP_EMPLOYEE_SKILL (SKILL_ID)^
-- end ERP_EMPLOYEE_SKILL
-- begin ERP_EMPLOYEE_EDUCATION
alter table ERP_EMPLOYEE_EDUCATION add constraint FK_ERP_EMPLOYEE_EDUCATION_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
alter table ERP_EMPLOYEE_EDUCATION add constraint FK_ERP_EMPLOYEE_EDUCATION_ON_EDUCATION foreign key (EDUCATION_ID) references ERP_EDUCATION(ID)^
create index IDX_ERP_EMPLOYEE_EDUCATION_ON_EMPLOYEE on ERP_EMPLOYEE_EDUCATION (EMPLOYEE_ID)^
create index IDX_ERP_EMPLOYEE_EDUCATION_ON_EDUCATION on ERP_EMPLOYEE_EDUCATION (EDUCATION_ID)^
-- end ERP_EMPLOYEE_EDUCATION
-- begin ERP_ORDER_ITEM
alter table ERP_ORDER_ITEM add constraint FK_ERP_ORDER_ITEM_ON_ITEM foreign key (ITEM_ID) references ERP_ITEM(ID)^
alter table ERP_ORDER_ITEM add constraint FK_ERP_ORDER_ITEM_ON_ORDER foreign key (ORDER_ID) references ERP_ORDER(ID)^
create index IDX_ERP_ORDER_ITEM_ON_ITEM on ERP_ORDER_ITEM (ITEM_ID)^
create index IDX_ERP_ORDER_ITEM_ON_ORDER on ERP_ORDER_ITEM (ORDER_ID)^
-- end ERP_ORDER_ITEM
-- begin ERP_DEPARTMENT
create unique index IDX_ERP_DEPARTMENT_UNIQ_DEPARTMENT on ERP_DEPARTMENT (DEPARTMENT) ^
-- end ERP_DEPARTMENT
-- begin ERP_ORDER
alter table ERP_ORDER add constraint FK_ERP_ORDER_ON_CLIENT foreign key (CLIENT_ID) references ERP_CLIENT(ID)^
create unique index IDX_ERP_ORDER_UNIQ_ORDER_NUM on ERP_ORDER (ORDER_NUM) ^
create index IDX_ERP_ORDER_ON_CLIENT on ERP_ORDER (CLIENT_ID)^
-- end ERP_ORDER
-- begin ERP_EMPLOYEE_LICENSE
alter table ERP_EMPLOYEE_LICENSE add constraint FK_ERP_EMPLOYEE_LICENSE_ON_LICENSE foreign key (LICENSE_ID) references ERP_LICENSE(ID)^
alter table ERP_EMPLOYEE_LICENSE add constraint FK_ERP_EMPLOYEE_LICENSE_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
create unique index IDX_ERP_EMPLOYEE_LICENSE_UNIQ_LICENSE_NUMBER on ERP_EMPLOYEE_LICENSE (LICENSE_NUMBER) ^
create index IDX_ERP_EMPLOYEE_LICENSE_ON_LICENSE on ERP_EMPLOYEE_LICENSE (LICENSE_ID)^
create index IDX_ERP_EMPLOYEE_LICENSE_ON_EMPLOYEE on ERP_EMPLOYEE_LICENSE (EMPLOYEE_ID)^
-- end ERP_EMPLOYEE_LICENSE
-- begin ERP_TASK
alter table ERP_TASK add constraint FK_ERP_TASK_ON_ORDER_NUM foreign key (ORDER_NUM_ID) references ERP_ORDER(ID)^
alter table ERP_TASK add constraint FK_ERP_TASK_ON_CLIENT foreign key (CLIENT_ID) references ERP_CLIENT(ID)^
alter table ERP_TASK add constraint FK_ERP_TASK_ON_COUNTRY foreign key (COUNTRY_ID) references ERP_COUNTRY(ID)^
alter table ERP_TASK add constraint FK_ERP_TASK_ON_CITY foreign key (CITY_ID) references ERP_CITY(ID)^
alter table ERP_TASK add constraint FK_ERP_TASK_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references ERP_EMPLOYEE(ID)^
create unique index IDX_ERP_TASK_UNIQ_TASK_NUM on ERP_TASK (TASK_NUM) ^
create index IDX_ERP_TASK_ON_ORDER_NUM on ERP_TASK (ORDER_NUM_ID)^
create index IDX_ERP_TASK_ON_CLIENT on ERP_TASK (CLIENT_ID)^
create index IDX_ERP_TASK_ON_COUNTRY on ERP_TASK (COUNTRY_ID)^
create index IDX_ERP_TASK_ON_CITY on ERP_TASK (CITY_ID)^
create index IDX_ERP_TASK_ON_EMPLOYEE on ERP_TASK (EMPLOYEE_ID)^
-- end ERP_TASK
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
-- begin ERP_PAYMENT
alter table ERP_PAYMENT add constraint FK_ERP_PAYMENT_ON_ORDER foreign key (ORDER_ID) references ERP_ORDER(ID)^
create index IDX_ERP_PAYMENT_ON_ORDER on ERP_PAYMENT (ORDER_ID)^
-- end ERP_PAYMENT
-- begin ERP_CITY
alter table ERP_CITY add constraint FK_ERP_CITY_ON_COUNTRY foreign key (COUNTRY_ID) references ERP_COUNTRY(ID)^
create index IDX_ERP_CITY_ON_COUNTRY on ERP_CITY (COUNTRY_ID)^
-- end ERP_CITY
-- begin ERP_COUNTRY
create unique index IDX_ERP_COUNTRY_UNIQ_COUNTRY on ERP_COUNTRY (COUNTRY) ^
create unique index IDX_ERP_COUNTRY_UNIQ_COUNTRY_CODE on ERP_COUNTRY (COUNTRY_CODE) ^
-- end ERP_COUNTRY
-- begin ERP_CLIENT
alter table ERP_CLIENT add constraint FK_ERP_CLIENT_ON_COUNTRY foreign key (COUNTRY_ID) references ERP_COUNTRY(ID)^
alter table ERP_CLIENT add constraint FK_ERP_CLIENT_ON_CITY foreign key (CITY_ID) references ERP_CITY(ID)^
create index IDX_ERP_CLIENT_ON_COUNTRY on ERP_CLIENT (COUNTRY_ID)^
create index IDX_ERP_CLIENT_ON_CITY on ERP_CLIENT (CITY_ID)^
-- end ERP_CLIENT
-- begin ERP_EQUIPMENT
alter table ERP_EQUIPMENT add constraint FK_ERP_EQUIPMENT_ON_PRODUCT_CATEGORY foreign key (PRODUCT_CATEGORY_ID) references ERP_PRODUCT_CATEGORY(ID)^
alter table ERP_EQUIPMENT add constraint FK_ERP_EQUIPMENT_ON_SERVICE_REQUEST foreign key (SERVICE_REQUEST_ID) references ERP_SERVICE_REQUEST(ID)^
create index IDX_ERP_EQUIPMENT_ON_PRODUCT_CATEGORY on ERP_EQUIPMENT (PRODUCT_CATEGORY_ID)^
create index IDX_ERP_EQUIPMENT_ON_SERVICE_REQUEST on ERP_EQUIPMENT (SERVICE_REQUEST_ID)^
-- end ERP_EQUIPMENT
-- begin ERP_NON_STOCK_ITEM
alter table ERP_NON_STOCK_ITEM add constraint FK_ERP_NON_STOCK_ITEM_ON_ID foreign key (ID) references ERP_ITEM(ID) on delete CASCADE^
-- end ERP_NON_STOCK_ITEM
-- begin ERP_SERVICE
alter table ERP_SERVICE add constraint FK_ERP_SERVICE_ON_ID foreign key (ID) references ERP_ITEM(ID) on delete CASCADE^
-- end ERP_SERVICE
-- begin ERP_PRODUCT
alter table ERP_PRODUCT add constraint FK_ERP_PRODUCT_ON_PRODUCT_CATEGORY foreign key (PRODUCT_CATEGORY_ID) references ERP_PRODUCT_CATEGORY(ID)^
alter table ERP_PRODUCT add constraint FK_ERP_PRODUCT_ON_MAKE_MANUFACTURER foreign key (MAKE_MANUFACTURER_ID) references ERP_MAKE_MANUFACTURER(ID)^
alter table ERP_PRODUCT add constraint FK_ERP_PRODUCT_ON_ID foreign key (ID) references ERP_ITEM(ID) on delete CASCADE^
create index IDX_ERP_PRODUCT_ON_PRODUCT_CATEGORY on ERP_PRODUCT (PRODUCT_CATEGORY_ID)^
create index IDX_ERP_PRODUCT_ON_MAKE_MANUFACTURER on ERP_PRODUCT (MAKE_MANUFACTURER_ID)^
-- end ERP_PRODUCT
-- begin ERP_MAKE_MANUFACTURER
create unique index IDX_ERP_MAKE_MANUFACTURER_UNIQ_NAME on ERP_MAKE_MANUFACTURER (NAME) ^
-- end ERP_MAKE_MANUFACTURER
-- begin ERP_LICENSE
create unique index IDX_ERP_LICENSE_UNIQ_NAME on ERP_LICENSE (NAME) ^
-- end ERP_LICENSE
-- begin ERP_EDUCATION
create unique index IDX_ERP_EDUCATION_UNIQ_NAME on ERP_EDUCATION (NAME) ^
-- end ERP_EDUCATION
-- begin ERP_LANGUAGE
create unique index IDX_ERP_LANGUAGE_UNIQ_NAME on ERP_LANGUAGE (NAME) ^
-- end ERP_LANGUAGE
-- begin ERP_PRODUCT_CATEGORY
create unique index IDX_ERP_PRODUCT_CATEGORY_UNIQ_NAME on ERP_PRODUCT_CATEGORY (NAME) ^
-- end ERP_PRODUCT_CATEGORY
-- begin ERP_SKILL
create unique index IDX_ERP_SKILL_UNIQ_NAME on ERP_SKILL (NAME) ^
-- end ERP_SKILL
-- begin ERP_JOB_POSITION
create unique index IDX_ERP_JOB_POSITION_UNIQ_NAME on ERP_JOB_POSITION (NAME) ^
-- end ERP_JOB_POSITION
-- begin ERP_CATALOG_PRODUCT
alter table ERP_CATALOG_PRODUCT add constraint FK_ERP_CATALOG_PRODUCT_ON_PRODUCT foreign key (PRODUCT_ID) references ERP_PRODUCT(ID)^
alter table ERP_CATALOG_PRODUCT add constraint FK_ERP_CATALOG_PRODUCT_ON_BRAND foreign key (BRAND_ID) references ERP_MAKE_MANUFACTURER(ID)^
alter table ERP_CATALOG_PRODUCT add constraint FK_ERP_CATALOG_PRODUCT_ON_CATEGORY foreign key (CATEGORY_ID) references ERP_PRODUCT_CATEGORY(ID)^
create unique index IDX_ERP_CATALOG_PRODUCT_UNIQ_NAME on ERP_CATALOG_PRODUCT (NAME) ^
create index IDX_ERP_CATALOG_PRODUCT_ON_PRODUCT on ERP_CATALOG_PRODUCT (PRODUCT_ID)^
create index IDX_ERP_CATALOG_PRODUCT_ON_BRAND on ERP_CATALOG_PRODUCT (BRAND_ID)^
create index IDX_ERP_CATALOG_PRODUCT_ON_CATEGORY on ERP_CATALOG_PRODUCT (CATEGORY_ID)^
-- end ERP_CATALOG_PRODUCT
-- begin ERP_EMPLOYEE
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_NATIONALITY foreign key (NATIONALITY_ID) references ERP_COUNTRY(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_COUNTRY_OF_RESIDENCE foreign key (COUNTRY_OF_RESIDENCE_ID) references ERP_COUNTRY(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_CITY foreign key (CITY_ID) references ERP_CITY(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_DEPARTMENT foreign key (DEPARTMENT_ID) references ERP_DEPARTMENT(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_SUBUNIT foreign key (SUBUNIT_ID) references ERP_SUBUNIT(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_JOB_POSITION foreign key (JOB_POSITION_ID) references ERP_JOB_POSITION(ID)^
alter table ERP_EMPLOYEE add constraint FK_ERP_EMPLOYEE_ON_ID foreign key (ID) references ERP_PERSON(ID) on delete CASCADE^
create index IDX_ERP_EMPLOYEE_ON_NATIONALITY on ERP_EMPLOYEE (NATIONALITY_ID)^
create index IDX_ERP_EMPLOYEE_ON_COUNTRY_OF_RESIDENCE on ERP_EMPLOYEE (COUNTRY_OF_RESIDENCE_ID)^
create index IDX_ERP_EMPLOYEE_ON_CITY on ERP_EMPLOYEE (CITY_ID)^
create index IDX_ERP_EMPLOYEE_ON_DEPARTMENT on ERP_EMPLOYEE (DEPARTMENT_ID)^
create index IDX_ERP_EMPLOYEE_ON_SUBUNIT on ERP_EMPLOYEE (SUBUNIT_ID)^
create index IDX_ERP_EMPLOYEE_ON_JOB_POSITION on ERP_EMPLOYEE (JOB_POSITION_ID)^
-- end ERP_EMPLOYEE
-- begin ERP_CONTACT_PERSON
alter table ERP_CONTACT_PERSON add constraint FK_ERP_CONTACT_PERSON_ON_ID foreign key (ID) references ERP_PERSON(ID) on delete CASCADE^
-- end ERP_CONTACT_PERSON
-- begin ERP_CLIENT_PERSON
alter table ERP_CLIENT_PERSON add constraint FK_ERP_CLIENT_PERSON_ON_ID foreign key (ID) references ERP_CLIENT(ID) on delete CASCADE^
-- end ERP_CLIENT_PERSON
-- begin ERP_CLIENT_COMPANY
alter table ERP_CLIENT_COMPANY add constraint FK_ERP_CLIENT_COMPANY_ON_ID foreign key (ID) references ERP_CLIENT(ID) on delete CASCADE^
-- end ERP_CLIENT_COMPANY
