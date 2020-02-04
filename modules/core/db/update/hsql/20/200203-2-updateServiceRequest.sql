alter table ERP_SERVICE_REQUEST add column STATUS varchar(255) ^
update ERP_SERVICE_REQUEST set STATUS = '' where STATUS is null ;
alter table ERP_SERVICE_REQUEST alter column STATUS set not null ;
