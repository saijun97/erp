create table ERP_TASK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TASK_NUM integer,
    TASK_CATEGORY varchar(255) not null,
    ORDER_NUM_ID varchar(36),
    PO_INVOICE_NUM varchar(255),
    CLIENT_ID varchar(36) not null,
    LOCATION longvarchar,
    CONTACT longvarchar,
    REQUEST longvarchar,
    REMARK longvarchar,
    ITEM_REQUIRED longvarchar,
    EMPLOYEE_ID varchar(36) not null,
    STATUS varchar(255) not null,
    START_DATE date not null,
    COMPLETION_DATE date,
    --
    primary key (ID)
);