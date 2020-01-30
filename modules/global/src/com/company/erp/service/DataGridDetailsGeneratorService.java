package com.company.erp.service;

import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;

import java.util.List;
import java.util.UUID;

public interface DataGridDetailsGeneratorService {
    String NAME = "erp_DataGridDetailsGeneratorService";

    List<OrderItem> loadOrderItemsById(UUID orderId);

}