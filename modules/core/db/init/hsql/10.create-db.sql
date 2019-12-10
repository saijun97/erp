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
    COMMENT varchar(255),
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
-- begin ERP_EMPLOYEE
create table ERP_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    FIRST_NAME varchar(255) not null,
    MIDDLE_NAME varchar(255),
    LAST_NAME varchar(255) not null,
    --
    EMP_ID varchar(255) not null,
    NIC varchar(255),
    GENDER integer not null,
    DOB date not null,
    DEPARTMENT_ID varchar(36) not null,
    SUBUNIT_ID varchar(36),
    MOBILE_PHONE varchar(255),
    HOME_PHONE varchar(255),
    EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE
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
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_EDUCATION
