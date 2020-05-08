-- begin ERP_PORTAL_MESSAGES
create table ERP_PORTAL_MESSAGES (
    ID varchar(10),
    --
    PERSON_NAME varchar(255) not null,
    EMAIL varchar(255) not null,
    PHONE_NUMBER varchar(255),
    SUBJECT text not null,
    MESSAGE text not null,
    STATUS varchar(50) not null,
    RECEIVED_TS timestamp not null,
    --
    primary key (ID)
)^
-- end ERP_PORTAL_MESSAGES
-- begin ERP_ITEM
create table ERP_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    ITEM varchar(255) not null,
    DESCRIPTION text,
    COST decimal(19, 2),
    PRICE decimal(19, 2),
    APPLY_VAT boolean,
    VAT_PRICE decimal(19, 2),
    --
    primary key (ID)
)^
-- end ERP_ITEM
-- begin ERP_SERVICE_REQUEST
create table ERP_SERVICE_REQUEST (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REFERENCE_NUMBER varchar(255) not null,
    EXISTING_CLIENT_ID uuid,
    CUSTOMER_NAME varchar(255) not null,
    MOBILE_PHONE varchar(255),
    HOME_PHONE varchar(255),
    WORK_PHONE varchar(255),
    EMAIL varchar(255),
    ADDRESS text,
    INVOICE_NUMBER varchar(255),
    TOTAL_PRICE decimal(19, 2),
    STATUS varchar(50) not null,
    DATE_RECEIVED date not null,
    --
    primary key (ID)
)^
-- end ERP_SERVICE_REQUEST
-- begin ERP_COMPANY_CONTACT_PERSONS
create table ERP_COMPANY_CONTACT_PERSONS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CLIENT_COMPANY_ID uuid not null,
    CONTACT_PERSON_ID uuid not null,
    PREFERRED_COMPANY_PHONE varchar(255),
    PREFERRED_EMAIL varchar(255),
    JOB_POSITION varchar(255),
    --
    primary key (ID)
)^
-- end ERP_COMPANY_CONTACT_PERSONS
-- begin ERP_ORDER_ITEM
create table ERP_ORDER_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ITEM_ID uuid not null,
    DESCRIPTION text,
    UNIT_VAT_PRICE decimal(19, 2) not null,
    QUANTITY integer not null,
    AMOUNT decimal(19, 2) not null,
    ORDER_ID uuid not null,
    --
    primary key (ID)
)^
-- end ERP_ORDER_ITEM
-- begin ERP_EMPLOYEE_SKILL
create table ERP_EMPLOYEE_SKILL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID uuid not null,
    SKILL_ID uuid not null,
    YEARS_OF_EXPERIENCE integer,
    COMMENT text,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_SKILL
-- begin ERP_EMPLOYEE_EDUCATION
create table ERP_EMPLOYEE_EDUCATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID uuid not null,
    EDUCATION_ID uuid not null,
    INSTITUTE varchar(255) not null,
    MAJOR_SPECIALIZATION varchar(255),
    YEAR_ date,
    GPA_SCORE decimal(19, 2),
    START_DATE date,
    END_DATE date,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_EDUCATION
-- begin ERP_DEPARTMENT
create table ERP_DEPARTMENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DEPARTMENT varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_DEPARTMENT
-- begin ERP_ORDER
create table ERP_ORDER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ORDER_NUM varchar(255),
    CLIENT_ID uuid not null,
    ORDER_DATE date not null,
    DELIVERY_DATE date,
    TOTAL_AMOUNT decimal(19, 2),
    AMOUNT_DUE decimal(19, 2) not null,
    STATUS varchar(50) not null,
    --
    primary key (ID)
)^
-- end ERP_ORDER
-- begin ERP_EMPLOYEE_LICENSE
create table ERP_EMPLOYEE_LICENSE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    LICENSE_ID uuid not null,
    EMPLOYEE_ID uuid not null,
    LICENSE_NUMBER varchar(255) not null,
    ISSUED_DATE date,
    EXPIRY_DATE date,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_LICENSE
-- begin ERP_TASK
create table ERP_TASK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TASK_NUM varchar(255),
    CATEGORY varchar(50) not null,
    ORDER_NUM_ID uuid,
    PO_INVOICE_NUM varchar(255),
    CLIENT_ID uuid not null,
    COUNTRY_ID uuid,
    CITY_ID uuid,
    CONTACT text,
    REQUEST text,
    REMARK text,
    ITEM_REQUIRED text,
    EMPLOYEE_ID uuid not null,
    STATUS varchar(50) not null,
    START_DATE date not null,
    COMPLETION_DATE date,
    --
    primary key (ID)
)^
-- end ERP_TASK
-- begin ERP_SUBUNIT
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
)^
-- end ERP_SUBUNIT
-- begin ERP_WORK_EXPERIENCE
create table ERP_WORK_EXPERIENCE (
    ID uuid,
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
    COMMENT_ text,
    EMPLOYEE_ID uuid not null,
    --
    primary key (ID)
)^
-- end ERP_WORK_EXPERIENCE
-- begin ERP_EMPLOYEE_LANGUAGE
create table ERP_EMPLOYEE_LANGUAGE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EMPLOYEE_ID uuid not null,
    LANGUAGE_ID uuid not null,
    FLUENCY varchar(255) not null,
    COMPETENCY varchar(255) not null,
    COMMENTS text,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE_LANGUAGE
-- begin ERP_PAYMENT
create table ERP_PAYMENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    EXECUTION_DATE timestamp not null,
    EXECUTION_DATE_INVISIBLE date not null,
    PAYMENT_TYPE varchar(50) not null,
    AMOUNT decimal(19, 2) not null,
    CHEQUE_REFERENCE varchar(255),
    ORDER_ID uuid not null,
    --
    primary key (ID)
)^
-- end ERP_PAYMENT
-- begin ERP_CITY
create table ERP_CITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CITY varchar(255) not null,
    COORDINATES varchar(255),
    COUNTRY_ID uuid not null,
    --
    primary key (ID)
)^
-- end ERP_CITY
-- begin ERP_COUNTRY
create table ERP_COUNTRY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COUNTRY_CODE varchar(5) not null,
    COUNTRY varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_COUNTRY
-- begin ERP_PERSON
create table ERP_PERSON (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(100),
    --
    NAME_FIRST_NAME varchar(255) not null,
    NAME_MIDDLE_NAME varchar(255),
    NAME_LAST_NAME varchar(255) not null,
    --
    FULL_NAME varchar(255) not null,
    GENDER integer not null,
    MOBILE_PHONE varchar(255),
    HOME_PHONE varchar(255),
    EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end ERP_PERSON
-- begin ERP_CLIENT
create table ERP_CLIENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    DTYPE varchar(31),
    --
    DISPLAY_NAME varchar(255),
    EMAIL varchar(255),
    PREFERRED_CONTACT_PHONE varchar(255),
    FAX_NUMBER varchar(255),
    COUNTRY_ID uuid not null,
    CITY_ID uuid not null,
    SHIPPING_ADDRESS text,
    BILLING_ADDRESS text,
    --
    primary key (ID)
)^
-- end ERP_CLIENT
-- begin ERP_EQUIPMENT
create table ERP_EQUIPMENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_CATEGORY_ID uuid,
    MAKE_MODEL varchar(255) not null,
    SERIAL_NUMBER varchar(255),
    VISIBLE_DEFECT text,
    PROBLEM_DESCRIPTION text,
    TECHNICIAN_REPORT text,
    STATUS varchar(50) not null,
    PRICE decimal(19, 2),
    SERVICE_REQUEST_ID uuid not null,
    --
    primary key (ID)
)^
-- end ERP_EQUIPMENT
-- begin ERP_NON_STOCK_ITEM
create table ERP_NON_STOCK_ITEM (
    ID uuid,
    --
    primary key (ID)
)^
-- end ERP_NON_STOCK_ITEM
-- begin ERP_SERVICE
create table ERP_SERVICE (
    ID uuid,
    --
    primary key (ID)
)^
-- end ERP_SERVICE
-- begin ERP_PRODUCT
create table ERP_PRODUCT (
    ID uuid,
    --
    PRODUCT_CATEGORY_ID uuid,
    MAKE_MANUFACTURER_ID uuid,
    QTY_STORE1 integer not null,
    QTY_STORE2 integer not null,
    QTY_STORE3 integer not null,
    QTY_TOTAL integer not null,
    MONITOR_STOCK boolean,
    --
    primary key (ID)
)^
-- end ERP_PRODUCT
-- begin ERP_MAKE_MANUFACTURER
create table ERP_MAKE_MANUFACTURER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_MAKE_MANUFACTURER
-- begin ERP_LICENSE
create table ERP_LICENSE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_LICENSE
-- begin ERP_EDUCATION
create table ERP_EDUCATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_EDUCATION
-- begin ERP_LANGUAGE
create table ERP_LANGUAGE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_LANGUAGE
-- begin ERP_PRODUCT_CATEGORY
create table ERP_PRODUCT_CATEGORY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end ERP_PRODUCT_CATEGORY
-- begin ERP_SKILL
create table ERP_SKILL (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    DESCRIPTION text,
    --
    primary key (ID)
)^
-- end ERP_SKILL
-- begin ERP_JOB_POSITION
create table ERP_JOB_POSITION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    RESPONSIBILITIES text,
    --
    primary key (ID)
)^
-- end ERP_JOB_POSITION
-- begin ERP_CATALOG_PRODUCT
create table ERP_CATALOG_PRODUCT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    NAME varchar(255) not null,
    --
    PRODUCT_ID uuid,
    PRICE decimal(19, 2) not null,
    DESCRIPTION text,
    BRAND_ID uuid,
    CATEGORY_ID uuid,
    STOCK_STATUS varchar(50),
    IMAGE varchar(255),
    PUBLIC_IMAGE text,
    --
    primary key (ID)
)^
-- end ERP_CATALOG_PRODUCT
-- begin ERP_EMPLOYEE
create table ERP_EMPLOYEE (
    ID uuid,
    --
    EMP_ID varchar(255) not null,
    NIC varchar(255),
    DOB date not null,
    NATIONALITY_ID uuid,
    COUNTRY_OF_RESIDENCE_ID uuid,
    CITY_ID uuid,
    STREET_ADDRESS_APARTMENT text,
    ADDRESS text,
    DEPARTMENT_ID uuid not null,
    SUBUNIT_ID uuid,
    JOB_POSITION_ID uuid,
    USER_ID uuid,
    --
    primary key (ID)
)^
-- end ERP_EMPLOYEE
-- begin ERP_CONTACT_PERSON
create table ERP_CONTACT_PERSON (
    ID uuid,
    --
    WORK_PHONE varchar(255),
    PREFERRED_PHONE varchar(255),
    --
    primary key (ID)
)^
-- end ERP_CONTACT_PERSON
-- begin ERP_CLIENT_PERSON
create table ERP_CLIENT_PERSON (
    ID uuid,
    --
    NAME_FIRST_NAME varchar(255) not null,
    NAME_MIDDLE_NAME varchar(255),
    NAME_LAST_NAME varchar(255) not null,
    --
    GENDER integer not null,
    WORK_PHONE varchar(255),
    MOBILE_PHONE varchar(255),
    HOME_PHONE varchar(255),
    HOUSE_ADDRESS varchar(255),
    --
    primary key (ID)
)^
-- end ERP_CLIENT_PERSON
-- begin ERP_CLIENT_COMPANY
create table ERP_CLIENT_COMPANY (
    ID uuid,
    --
    COMPANY_NAME varchar(255) not null,
    COMPANY_ADDRESS varchar(255) not null,
    BRN varchar(255),
    VAT_NUMBER varchar(255),
    SECONDARY_EMAIL varchar(255),
    ALTERNATE_PHONE varchar(255),
    --
    primary key (ID)
)^
-- end ERP_CLIENT_COMPANY
