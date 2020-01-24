package com.company.erp.web.screens.sales_inventory.order;

import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.cuba.security.entity.EntityLogItem;

import javax.inject.Inject;
import java.util.Objects;

@UiController("erp_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    private InstanceLoader<Order> orderDl;
    @Inject
    private CollectionLoader<EntityLogItem> logDl;
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionPropertyContainer<OrderItem> itemDc;

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

    }

    @Subscribe(id = "orderDc", target = Target.DATA_CONTAINER)
    public void onOrderDcItemChange(InstanceContainer.ItemChangeEvent<Order> event) {

        logDl.setParameter("order", Objects.requireNonNull(event.getItem()).getId());
        logDl.load();

    }

}