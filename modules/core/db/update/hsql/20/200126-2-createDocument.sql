alter table ERP_DOCUMENT add constraint FK_ERP_DOCUMENT_ON_FILE foreign key (FILE_ID) references SYS_FILE(ID);
alter table ERP_DOCUMENT add constraint FK_ERP_DOCUMENT_ON_ORDER foreign key (ORDER_ID) references ERP_ORDER(ID);
create index IDX_ERP_DOCUMENT_ON_FILE on ERP_DOCUMENT (FILE_ID);
create index IDX_ERP_DOCUMENT_ON_ORDER on ERP_DOCUMENT (ORDER_ID);
