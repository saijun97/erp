package com.company.erp.web.screens.sales_inventory.order.joined.orderitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;

@UiController("erp_OrderItem.edit")
@UiDescriptor("order-item-edit.xml")
@EditedEntityContainer("orderItemDc")
@LoadDataBeforeShow
public class OrderItemEdit extends StandardEditor<OrderItem> {
}