package com.company.erp.web.screens.general.widgets.TopCustomersBySalesColumnChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_TopCustomersBySalesFragment")
@UiDescriptor("top-customers-by-sales-fragment.xml")
public class TopCustomersBySalesFragment extends ScreenFragment {

    @Inject
    protected KeyValueCollectionLoader topCustomersBySalesLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        topCustomersBySalesLoader.load();

    }

}