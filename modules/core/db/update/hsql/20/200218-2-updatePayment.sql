alter table ERP_PAYMENT add column EXECUTION_DATE_INVISIBLE date ^
update ERP_PAYMENT set EXECUTION_DATE_INVISIBLE = current_date where EXECUTION_DATE_INVISIBLE is null ;
alter table ERP_PAYMENT alter column EXECUTION_DATE_INVISIBLE set not null ;
