package com.company.erp.web.screens.sales_inventory.order;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.CurrencyField;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.cuba.security.entity.EntityLogItem;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@UiController("erp_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    protected Table<OrderItem> itemTable;
    @Inject
    protected CurrencyField<BigDecimal> totalAmountField;
    @Inject
    private InstanceLoader<Order> orderDl;
    @Inject
    private CollectionLoader<EntityLogItem> logDl;
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionLoader<Client> clientsLc;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        if ((getEditedEntity().getOrderDate() != null) & (getEditedEntity().getDeliveryDate() != null)){

            if (getEditedEntity().getOrderDate().after(getEditedEntity().getDeliveryDate())) {

                notifications.create()
                        .withCaption("Delivery date cannot be before order date.")
                        .withType(Notifications.NotificationType.ERROR)
                        .show();
                event.preventCommit();
            }

        }

    }

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        orderDl.load();
        clientsLc.load();

    }

    @Subscribe(id = "orderDc", target = Target.DATA_CONTAINER)
    public void onOrderDcItemChange(InstanceContainer.ItemChangeEvent<Order> event) {

        logDl.setParameter("order", Objects.requireNonNull(event.getItem()).getId());
        logDl.load();

    }

    @Subscribe(id = "itemDc", target = Target.DATA_CONTAINER)
    protected void onItemDcCollectionChange(CollectionContainer.CollectionChangeEvent<OrderItem> event) {

        BigDecimal amountValue = BigDecimal.ZERO;

        for (int i=0; i<itemTable.getAggregationResults().size(); i++){
            Map<Object, Object> hash = itemTable.getAggregationResults();
            Set<Object> set = hash.keySet();
            Iterator itr = set.iterator();
            Object string = itr.next();
            amountValue = (BigDecimal) hash.get(string);
        }

        totalAmountField.setValue(amountValue);

    }

}