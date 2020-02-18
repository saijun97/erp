create table ERP_PAYMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EXECUTION_DATE timestamp not null,
    PAYMENT_TYPE varchar(50) not null,
    AMOUNT decimal(19, 2) not null,
    CHEQUE_REFERENCE varchar(255),
    ORDER_ID varchar(36) not null,
    --
    primary key (ID)
);