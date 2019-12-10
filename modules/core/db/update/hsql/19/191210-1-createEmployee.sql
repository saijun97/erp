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
);