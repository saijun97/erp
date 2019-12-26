-- begin ERP_ITEM
create table ERP_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    ITEM varchar(255) not null,
    DESCRIPTION longvarchar,
    COST decimal(19, 2),
    PRICE decimal(19, 2),
    --
    primary key (ID)
)^
-- end ERP_ITEM
-- begin ERP_SUBUNIT
create table ERP_SUBUNIT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SUBUNIT varchar(255) not null,
    DEPARTMENT_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end ERP_SUBUNIT
-- begin ERP_WORK_EXPERIENCE
create table ERP_WORK_EXPERIENCE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COMPANY varchar(255) not null,
    JOB_TITLE varchar(255) not null,
    START_DATE date,
    END_DATE date,
    COMMENT_ longvarchar,
    EMPLOYEE_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end ERP_WORK_EXPERIENCE
-- begin ERP_COMPANY_CONTACT_PERSONS
create table ERP_COMPANY_CONTACT_PERSONS (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLIENT_COMPANY_ID varchar(36) not null,
    CONTACT_PERSON_ID varchar(36) not null,
    WORK_PHONE varchar(255),
    PREFERRED_EMAIL varchar(255),
    JOB_POSITION varchar(255),
    --
    primary key (ID)
)^
-- end ERP_COMPANY_CONTACT_PERSONS
-- begin ERP_EMPLOYEE_LANGUAGE
create table ERP_EMPLOYEE_LANGUAGE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36) not null,
    LANGUAGE_ID varchar(36) not null,
    FLUENCY varchar(255) not null,
    COMPETENCY varchar(255) not null,
    COMMENTS longvarchar,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_LANGUAGE
-- begin ERP_ORDER
create table ERP_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLIENT_ID varchar(36) not null,
    ORDER_NUM varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_ORDER
-- begin ERP_EMPLOYEE_EDUCATION
create table ERP_EMPLOYEE_EDUCATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36) not null,
    EDUCATION_ID varchar(36) not null,
    INSTITUTE varchar(255) not null,
    MAJOR_SPECIALIZATION varchar(255),
    YEAR_ date,
    GPA_SCORE integer,
    START_DATE date,
    END_DATE date,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_EDUCATION
-- begin ERP_EMPLOYEE_SKILL
create table ERP_EMPLOYEE_SKILL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID varchar(36) not null,
    SKILL_ID varchar(36) not null,
    YEARS_OF_EXPERIENCE integer,
    COMMENT longvarchar,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_SKILL
-- begin ERP_DEPARTMENT
create table ERP_DEPARTMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DEPARTMENT varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_DEPARTMENT
-- begin ERP_CITY
create table ERP_CITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CITY varchar(255) not null,
    COORDINATES varchar(255),
    COUNTRY_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end ERP_CITY
-- begin ERP_COUNTRY
create table ERP_COUNTRY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COUNTRY_CODE varchar(5) not null,
    COUNTRY varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_COUNTRY
-- begin ERP_EMPLOYEE_LICENSE
create table ERP_EMPLOYEE_LICENSE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LICENSE_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    LICENSE_NUMBER varchar(255) not null,
    ISSUED_DATE date,
    EXPIRY_DATE date,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_LICENSE
-- begin ERP_PERSON
create table ERP_PERSON (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(100),
    --
    FIRST_NAME varchar(255) not null,
    MIDDLE_NAME varchar(255),
    LAST_NAME varchar(255) not null,
    FULL_NAME varchar(255) not null,
    MOBILE_PHONE varchar(255),
    HOME_PHONE varchar(255),
    EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end ERP_PERSON
-- begin ERP_CLIENT
create table ERP_CLIENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    DISPLAY_NAME varchar(255),
    EMAIL varchar(255),
    PREFERRED_CONTACT_PHONE varchar(255),
    COUNTRY_ID varchar(36),
    CITY_ID varchar(36),
    SHIPPING_ADDRESS longvarchar,
    BILLING_ADDRESS longvarchar,
    --
    primary key (ID)
)^
-- end ERP_CLIENT
-- begin ERP_PRODUCT
create table ERP_PRODUCT (
    ID varchar(36) not null,
    --
    QTY_STORE1 integer,
    QTY_STORE2 integer,
    QTY_STORE3 integer,
    --
    primary key (ID)
)^
-- end ERP_PRODUCT
-- begin ERP_LICENSE
create table ERP_LICENSE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_LICENSE
-- begin ERP_LANGUAGE
create table ERP_LANGUAGE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_LANGUAGE
-- begin ERP_EDUCATION
create table ERP_EDUCATION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_EDUCATION
-- begin ERP_SKILL
create table ERP_SKILL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    DESCRIPTION varchar(255),
    --
    primary key (ID)
)^
-- end ERP_SKILL
-- begin ERP_JOB_POSITION
create table ERP_JOB_POSITION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    RESPONSIBILITIES longvarchar,
    --
    primary key (ID)
)^
-- end ERP_JOB_POSITION
-- begin ERP_EMPLOYEE
create table ERP_EMPLOYEE (
    ID varchar(36) not null,
    --
    EMP_ID varchar(255) not null,
    NIC varchar(255),
    GENDER integer not null,
    DOB date not null,
    NATIONALITY_ID varchar(36),
    COUNTRY_OF_RESIDENCE_ID varchar(36),
    CITY_ID varchar(36),
    STREET_ADDRESS_APARTMENT longvarchar,
    ADDRESS longvarchar,
    DEPARTMENT_ID varchar(36) not null,
    SUBUNIT_ID varchar(36),
    JOB_POSITION_ID varchar(36),
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE
-- begin ERP_CONTACT_PERSON
create table ERP_CONTACT_PERSON (
    ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end ERP_CONTACT_PERSON
-- begin ERP_CLIENT_PERSON
create table ERP_CLIENT_PERSON (
    ID varchar(36) not null,
    --
    FIRST_NAME varchar(255) not null,
    MIDDLE_NAME varchar(255),
    LAST_NAME varchar(255) not null,
    MOBILE_PHONE varchar(255),
    HOME_PHONE varchar(255),
    WORK_PHONE varchar(255),
    --
    primary key (ID)
)^
-- end ERP_CLIENT_PERSON
-- begin ERP_CLIENT_COMPANY
create table ERP_CLIENT_COMPANY (
    ID varchar(36) not null,
    --
    COMPANY_NAME varchar(255) not null,
    COMPANY_ADDRESS varchar(255),
    BRN varchar(255),
    VAT_NUMBER varchar(255),
    --
    primary key (ID)
)^
-- end ERP_CLIENT_COMPANY
