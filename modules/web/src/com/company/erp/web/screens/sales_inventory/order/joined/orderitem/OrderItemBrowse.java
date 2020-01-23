package com.company.erp.web.screens.sales_inventory.order.joined.orderitem;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;

@UiController("erp_OrderItem.browse")
@UiDescriptor("order-item-browse.xml")
@LookupComponent("orderItemsTable")
@LoadDataBeforeShow
public class OrderItemBrowse extends StandardLookup<OrderItem> {
}