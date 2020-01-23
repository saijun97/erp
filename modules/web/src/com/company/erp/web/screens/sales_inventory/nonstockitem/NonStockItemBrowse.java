package com.company.erp.web.screens.sales_inventory.nonstockitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.nonstockitem.NonStockItem;

@UiController("erp_NonStockItem.browse")
@UiDescriptor("non-stock-item-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class NonStockItemBrowse extends MasterDetailScreen<NonStockItem> {
}