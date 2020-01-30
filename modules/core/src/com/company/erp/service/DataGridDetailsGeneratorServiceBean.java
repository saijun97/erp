package com.company.erp.service;

import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

@Service(DataGridDetailsGeneratorService.NAME)
public class DataGridDetailsGeneratorServiceBean implements DataGridDetailsGeneratorService {

    @Inject
    private DataManager dataManager;

    @Override
    public List<OrderItem> loadOrderItemsById(UUID orderId) {
        LoadContext<OrderItem> lc = LoadContext.create(OrderItem.class);
        LoadContext.Query query =
                LoadContext.createQuery("select e from erp_OrderItem e where e.order.id = :orderId")
                        .setParameter("orderId", orderId);
        lc.setView("orderItem-view-details");
        lc.setQuery(query);
        return dataManager.loadList(lc);
    }

}