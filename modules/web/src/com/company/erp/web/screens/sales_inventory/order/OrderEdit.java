package com.company.erp.web.screens.sales_inventory.order;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.enums.OrderStatusSelect;
import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;
import com.company.erp.entity.sales_inventory.order.joined.payment.Payment;
import com.haulmont.cuba.core.app.UniqueNumbersService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.actions.list.CreateAction;
import com.haulmont.cuba.gui.actions.list.RemoveAction;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.cuba.security.entity.EntityLogItem;
import com.haulmont.reports.gui.actions.EditorPrintFormAction;

import javax.inject.Inject;
import javax.inject.Named;
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
    protected LookupField<OrderStatusSelect> statusField;
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
    @Inject
    private Table<Payment> paymentsTable;
    @Inject
    private CurrencyField<BigDecimal> amountDueField;
    @Named("paymentsTable.create")
    private CreateAction<Payment> paymentsTableCreate;
    @Named("itemTable.create")
    private CreateAction<OrderItem> itemTableCreate;
    @Named("itemTable.remove")
    private RemoveAction<OrderItem> itemTableRemove;
    @Named("paymentsTable.remove")
    private RemoveAction<Payment> paymentsTableRemove;


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
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        if (dateValidation()) {
            event.preventCommit();
        }

        if (paymentStatusValidation()) {
            event.preventCommit();
        }

        if (partialPaymentStatusValidation()) {
            event.preventCommit();
        }

        generateUniqueOrderNumber();

    }

    @Subscribe(id = "orderDc", target = Target.DATA_CONTAINER)
    public void onOrderDcItemChange(InstanceContainer.ItemChangeEvent<Order> event) {

        logDl.setParameter("order", Objects.requireNonNull(event.getItem()).getId());
        logDl.load();

    }

    @Subscribe(id = "itemDc", target = Target.DATA_CONTAINER)
    protected void onItemDcCollectionChange(CollectionContainer.CollectionChangeEvent<OrderItem> event) {

        BigDecimal amountValue = getAggregationResultFromTable(itemTable.getAggregationResults());
        totalAmountField.setValue(amountValue);

    }

    @Subscribe(id = "paymentsDc", target = Target.DATA_CONTAINER)
    public void onPaymentsDcCollectionChange(CollectionContainer.CollectionChangeEvent<Payment> event) {

        BigDecimal amountDueValue = getAggregationResultFromTable(paymentsTable.getAggregationResults());
        amountDueField.setValue(getEditedEntity().getTotalAmount().subtract(amountDueValue));
        autoSettingPaymentStatus();

    }

    @Subscribe("deliveryDateField")
    public void onDeliveryDateFieldValueChange(HasValue.ValueChangeEvent<Date> event) {

        autoSettingPaymentStatus();

    }



    @Subscribe("statusField")
    public void onStatusFieldValueChange(HasValue.ValueChangeEvent<OrderStatusSelect> event) {

        preventRecordsAdditionForPaidOrders();

    }

    private void generateUniqueOrderNumber () {

        if (orderNumField.getValue() == null) {

            String orderNumValue = "ORD" + (uniqueNumbersService.getNextNumber("orderNum"));
            getEditedEntity().setOrderNum(orderNumValue);

        }
    }

    private boolean dateValidation () {

        if ((getEditedEntity().getOrderDate() != null) & (getEditedEntity().getDeliveryDate() != null)){

            if (getEditedEntity().getOrderDate().after(getEditedEntity().getDeliveryDate())) {

                notifications.create()
                        .withCaption("Delivery date cannot be before order date.")
                        .withType(Notifications.NotificationType.ERROR)
                        .show();
                return true;
            }
        }
        return false;
    }

    private boolean paymentStatusValidation () {

        if ((getEditedEntity().getStatus() == OrderStatusSelect.PAID) & (getEditedEntity().getAmountDue().compareTo(BigDecimal.ZERO) > 0)) {

            notifications.create()
                    .withCaption("Status cannot be set to PAID if " +
                            "amount due is more than Rs 0.\n" +
                            "Please create appropriate payment record " +
                            "to set amount due to Rs0. ")
                    .withType(Notifications.NotificationType.ERROR)
                    .show();
            return true;
        }
        return false;
    }

    private boolean partialPaymentStatusValidation () {

        if ((getEditedEntity().getStatus() == OrderStatusSelect.PARTIALLY_PAID) & (getEditedEntity().getTotalAmount().equals(getEditedEntity().getAmountDue()))) {

            notifications.create()
                    .withCaption("Status cannot be set to PARTIALLY PAID if " +
                            "amount due is not less than total amount owed.\n" +
                            "Please create appropriate payment record " +
                            "to set amount due to below Total Amount. ")
                    .withType(Notifications.NotificationType.ERROR)
                    .show();
            return true;
        }
        return false;
    }

    private BigDecimal getAggregationResultFromTable(Map<Object, Object> aggregationResults) {
        BigDecimal amountValue = BigDecimal.ZERO;

        for (int i = 0; i< aggregationResults.size(); i++){
            Set<Object> set = aggregationResults.keySet();
            Iterator itr = set.iterator();
            Object string = itr.next();
            amountValue = (BigDecimal) aggregationResults.get(string);

        }
        return amountValue;
    }

    private void autoSettingPaymentStatus() {

        if (getEditedEntity().getAmountDue().compareTo(getEditedEntity().getTotalAmount()) < 0) {

            getEditedEntity().setStatus(OrderStatusSelect.PARTIALLY_PAID);
        }

        try {

            if ((getEditedEntity().getAmountDue().compareTo(BigDecimal.ZERO) <= 0) && !(getEditedEntity().getItem().isEmpty())) {

                getEditedEntity().setStatus(OrderStatusSelect.PAID);
            }

        } catch (NullPointerException e) {

            System.out.println("Exception Handled");
        }

        if ((getEditedEntity().getDeliveryDate() != null) && (getEditedEntity().getStatus().equals(OrderStatusSelect.QUOTE_REQUEST))) {

            getEditedEntity().setStatus(OrderStatusSelect.UNPAID);
        }
    }

    private void preventRecordsAdditionForPaidOrders(){

        if (getEditedEntity().getStatus().equals(OrderStatusSelect.PAID)) {

                paymentsTableCreate.setEnabled(false);
                paymentsTableRemove.setEnabled(false);
                itemTableCreate.setEnabled(false);
                itemTableCreate.setEnabled(false);

        }
    }

}