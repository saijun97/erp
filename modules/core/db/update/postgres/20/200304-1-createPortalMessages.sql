create table ERP_PORTAL_MESSAGES (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PERSON_NAME varchar(255) not null,
    EMAIL varchar(255),
    PHONE_NUMBER varchar(255),
    MESSAGE text not null,
    --
    primary key (ID)
);