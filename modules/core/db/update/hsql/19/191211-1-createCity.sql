create table ERP_CITY (
    ID varchar(10) not null,
    UUID varchar(36),
    --
    CITY varchar(255) not null,
    COORDINATES varchar(255),
    COUNTRY_ID varchar(10) not null,
    --
    primary key (ID)
);