update ERP_PRODUCT set QTY_STORE1 = 0 where QTY_STORE1 is null ;
alter table ERP_PRODUCT alter column QTY_STORE1 set not null ;
update ERP_PRODUCT set QTY_STORE2 = 0 where QTY_STORE2 is null ;
alter table ERP_PRODUCT alter column QTY_STORE2 set not null ;
update ERP_PRODUCT set QTY_STORE3 = 0 where QTY_STORE3 is null ;
alter table ERP_PRODUCT alter column QTY_STORE3 set not null ;
