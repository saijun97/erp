alter table ERP_PRODUCT add constraint FK_ERP_PRODUCT_ON_ID foreign key (ID) references ERP_ITEM(ID) on delete CASCADE;
