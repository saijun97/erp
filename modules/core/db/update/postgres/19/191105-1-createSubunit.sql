create table ERP_SUBUNIT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SUBUNIT varchar(255) not null,
    DEPARTMENT_ID uuid not null,
    --
    primary key (ID)
);