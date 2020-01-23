package com.company.erp.web.screens.sales_inventory.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.Order;

@UiController("erp_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
}