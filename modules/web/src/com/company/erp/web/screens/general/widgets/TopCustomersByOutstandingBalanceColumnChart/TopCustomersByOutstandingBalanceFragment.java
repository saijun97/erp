package com.company.erp.web.screens.general.widgets.TopCustomersByOutstandingBalanceColumnChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_TopCustomersByOutstandingBalanceFragment")
@UiDescriptor("top-customers-by-outstanding-balance-fragment.xml")
public class TopCustomersByOutstandingBalanceFragment extends ScreenFragment {
    @Inject
    protected KeyValueCollectionLoader topCustomersByOutstandingBalancesLoader;


    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        topCustomersByOutstandingBalancesLoader.load();

    }

}