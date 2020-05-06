alter table ERP_PAYMENT rename column execution_date_invisible to execution_date_invisible__u62586 ;
alter table ERP_PAYMENT alter column execution_date_invisible__u62586 drop not null ;
