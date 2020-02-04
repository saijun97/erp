alter table ERP_ORDER add column STATUS varchar(255) ^
update ERP_ORDER set STATUS = '' where STATUS is null ;
alter table ERP_ORDER alter column STATUS set not null ;
