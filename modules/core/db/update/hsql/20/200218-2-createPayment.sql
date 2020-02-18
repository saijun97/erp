alter table ERP_PAYMENT add constraint FK_ERP_PAYMENT_ON_ORDER foreign key (ORDER_ID) references ERP_ORDER(ID);
create index IDX_ERP_PAYMENT_ON_ORDER on ERP_PAYMENT (ORDER_ID);
