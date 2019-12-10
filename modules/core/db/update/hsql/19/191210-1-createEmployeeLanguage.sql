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
);