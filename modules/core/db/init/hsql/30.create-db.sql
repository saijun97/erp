INSERT INTO PUBLIC.ERP_DEPARTMENT (ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, DEPARTMENT) VALUES ('856c9f21-4001-cc44-7ede-0b3db1ca037c', 1, '2019-12-09 15:59:54.962000', 'admin', '2019-12-09 15:59:54.962000', null, null, null, 'Information Technology');
INSERT INTO PUBLIC.ERP_SUBUNIT (ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, SUBUNIT, DEPARTMENT_ID) VALUES ('2c7a0516-cdf9-c102-92a6-f214cf6f14b0', 1, '2019-12-09 15:59:54.962000', 'admin', '2019-12-09 15:59:54.962000', null, null, null, 'Frontend Developpers', '856c9f21-4001-cc44-7ede-0b3db1ca037c');
INSERT INTO PUBLIC.ERP_SUBUNIT (ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, SUBUNIT, DEPARTMENT_ID) VALUES ('5577d77d-c026-be5b-c7b8-a0b8e7c37bc3', 1, '2019-12-09 15:59:54.962000', 'admin', '2019-12-09 15:59:54.962000', null, null, null, 'Backend Developpers', '856c9f21-4001-cc44-7ede-0b3db1ca037c');
INSERT INTO PUBLIC.ERP_SKILL (ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, DESCRIPTION) VALUES ('01bb031d-2dc2-0e94-5871-fa496798520e', 1, '2019-12-09 15:58:52.782000', 'admin', '2019-12-09 15:58:52.782000', null, null, null, 'Comptia N+', 'Networking');
INSERT INTO PUBLIC.ERP_EMPLOYEE (ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMP_ID, NIC, GENDER, DOB, DEPARTMENT_ID, SUBUNIT_ID, MOBILE_PHONE, HOME_PHONE, EMAIL) VALUES ('70bb56b3-3c96-0adc-dcb7-ccdd4fffaefd', 1, '2019-12-09 16:00:48.146000', 'admin', '2019-12-09 16:00:48.146000', null, null, null, 'Saiyal', null, 'Juttun', '123', null, 10, '1996-12-18', '856c9f21-4001-cc44-7ede-0b3db1ca037c', '5577d77d-c026-be5b-c7b8-a0b8e7c37bc3', '456433455', null, null);
INSERT INTO PUBLIC.ERP_EMPLOYEE_SKILL (ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, EMPLOYEE_ID, SKILL_ID, YEARS_OF_EXPERIENCE, COMMENT) VALUES ('2a1517a4-f388-c582-1b80-2a31ab3b06d2', 1, '2019-12-09 16:00:48.145000', 'admin', '2019-12-09 16:00:48.145000', null, null, null, '70bb56b3-3c96-0adc-dcb7-ccdd4fffaefd', '01bb031d-2dc2-0e94-5871-fa496798520e', 2, 'test');
