package com.company.erp.web.screens.general.widgets.UnpaidAndPartiallyPaidOrdersTable;

import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_UnpaidAndPartiallyPaidOrdersFragment")
@UiDescriptor("unpaid-and-partially-paid-orders-fragment.xml")
public class UnpaidAndPartiallyPaidOrdersFragment extends ScreenFragment {
    @Inject
    protected CollectionLoader<Order> ordersDl;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        ordersDl.load();

    }


}