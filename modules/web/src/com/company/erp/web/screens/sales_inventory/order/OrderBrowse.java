package com.company.erp.web.screens.sales_inventory.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.Order;

@UiController("erp_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}