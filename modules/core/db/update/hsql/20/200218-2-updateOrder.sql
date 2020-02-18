alter table ERP_ORDER add column AMOUNT_DUE decimal(19, 2) ^
update ERP_ORDER set AMOUNT_DUE = 0 where AMOUNT_DUE is null ;
alter table ERP_ORDER alter column AMOUNT_DUE set not null ;
