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
);