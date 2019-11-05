create table ERP_EMPLOYEE_SUBUNIT_LINK (
    SUBUNIT_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    primary key (SUBUNIT_ID, EMPLOYEE_ID)
);
