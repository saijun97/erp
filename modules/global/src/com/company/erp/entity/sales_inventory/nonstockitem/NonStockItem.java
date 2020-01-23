package com.company.erp.entity.sales_inventory.nonstockitem;

import com.company.erp.entity.general.superclasses.Item;
import com.haulmont.chile.core.annotations.NamePattern;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@NamePattern("%s|item")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("NON-STOCK")
@Table(name = "ERP_NON_STOCK_ITEM")
@Entity(name = "erp_NonStockItem")
public class NonStockItem extends Item {
    private static final long serialVersionUID = -1532468470452086333L;
}