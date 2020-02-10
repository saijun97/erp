alter table ERP_PRODUCT add column QTY_TOTAL integer ^
update ERP_PRODUCT set QTY_TOTAL = 0 where QTY_TOTAL is null ;
alter table ERP_PRODUCT alter column QTY_TOTAL set not null ;
