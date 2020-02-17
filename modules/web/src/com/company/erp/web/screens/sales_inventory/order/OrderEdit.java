package com.company.erp.web.screens.sales_inventory.order;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.enums.OrderStatusSelect;
import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.cuba.security.entity.EntityLogItem;
import com.haulmont.reports.gui.actions.EditorPrintFormAction;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.*;

@UiController("erp_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
public class OrderEdit extends StandardEditor<Order> {

    @Inject
    protected Table<OrderItem> itemTable;
    @Inject
    protected CurrencyField<BigDecimal> totalAmountField;
    @Inject
    protected TextField<String> orderNumField;
    @Inject
    protected UniqueNumbersService uniqueNumbersService;
    @Inject
    protected InstanceContainer<Order> orderDc;
    @Inject
    protected DateField<Date> orderDateField;
    @Inject
    protected LookupField<String> statusField;
    @Inject
    private InstanceLoader<Order> orderDl;
    @Inject
    private CollectionLoader<EntityLogItem> logDl;
    @Inject
    private Notifications notifications;
    @Inject
    private CollectionLoader<Client> clientsLc;
    @Inject
    private Button generateReportBtn;


    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        orderDl.load();
        clientsLc.load();

    }

    @Subscribe
    public void onInit(InitEvent event) {
        generateReportBtn.setAction(
                new EditorPrintFormAction(this, null)
        );
    }


    @Subscribe
    protected void onInitEntity(InitEntityEvent<Order> event) {

        event.getEntity().setOrderDate(new Date());
        event.getEntity().setStatus(OrderStatusSelect.QUOTE_REQUEST);

    }

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

        if (orderNumField.getValue() == null) {

            String orderNumValue = "ORD" + (uniqueNumbersService.getNextNumber("orderNum"));

            getEditedEntity().setOrderNum(orderNumValue);

        }

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