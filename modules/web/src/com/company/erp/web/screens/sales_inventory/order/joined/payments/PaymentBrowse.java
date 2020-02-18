package com.company.erp.web.screens.sales_inventory.order.joined.payments;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.joined.payment.Payment;

@UiController("erp_Payment.browse")
@UiDescriptor("payment-browse.xml")
@LookupComponent("paymentsTable")
@LoadDataBeforeShow
public class PaymentBrowse extends StandardLookup<Payment> {
}