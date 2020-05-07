package com.company.erp.web.screens.sales_inventory.order.joined.payments;

import com.company.erp.entity.general.enums.OrderStatusSelect;
import com.company.erp.entity.general.enums.PaymentTypeSelect;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.joined.payment.Payment;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;

@UiController("erp_Payment.edit")
@UiDescriptor("payment-edit.xml")
@EditedEntityContainer("paymentDc")
@LoadDataBeforeShow
public class PaymentEdit extends StandardEditor<Payment> {
    @Inject
    private TextField<String> chequeReferenceField;

    @Subscribe
    public void onBeforeShow(BeforeShowEvent event) {

        if (getEditedEntity().getOrder().getAmountDue().equals(BigDecimal.ZERO)) {

            if (!(getEditedEntity().getOrder().getStatus().equals(OrderStatusSelect.PAID))) {

                getEditedEntity().setAmount(getEditedEntity().getOrder().getTotalAmount());

            }

            else {

                getEditedEntity().setAmount(getEditedEntity().getOrder().getAmountDue());
            }

        }

        else {

            getEditedEntity().setAmount(getEditedEntity().getOrder().getAmountDue());

        }

    }

    @Subscribe("paymentTypeField")
    public void onPaymentTypeFieldValueChange(HasValue.ValueChangeEvent<PaymentTypeSelect> event) {

        if (getEditedEntity().getPaymentType() == PaymentTypeSelect.CHEQUE) {

            chequeReferenceField.setVisible(true);
        }

    }

}