create table ERP_PORTAL_MESSAGES (
    ID varchar(10),
    --
    PERSON_NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    PHONE_NUMBER varchar(255),
    MESSAGE text not null,
    STATUS varchar(50) not null,
    --
    primary key (ID)
);