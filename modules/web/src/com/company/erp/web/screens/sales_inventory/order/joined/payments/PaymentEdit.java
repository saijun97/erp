package com.company.erp.web.screens.sales_inventory.order.joined.payments;

import com.company.erp.entity.general.enums.PaymentTypeSelect;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.joined.payment.Payment;

import javax.inject.Inject;
import java.util.Date;

@UiController("erp_Payment.edit")
@UiDescriptor("payment-edit.xml")
@EditedEntityContainer("paymentDc")
@LoadDataBeforeShow
public class PaymentEdit extends StandardEditor<Payment> {
    @Inject
    private TextField<String> chequeReferenceField;

    @Subscribe("paymentTypeField")
    public void onPaymentTypeFieldValueChange(HasValue.ValueChangeEvent<PaymentTypeSelect> event) {

        if (getEditedEntity().getPaymentType() == PaymentTypeSelect.CHEQUE) {

            chequeReferenceField.setVisible(true);
        }

    }

}