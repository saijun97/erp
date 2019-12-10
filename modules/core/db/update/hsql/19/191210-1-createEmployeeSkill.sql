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
);