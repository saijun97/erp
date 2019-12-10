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
);