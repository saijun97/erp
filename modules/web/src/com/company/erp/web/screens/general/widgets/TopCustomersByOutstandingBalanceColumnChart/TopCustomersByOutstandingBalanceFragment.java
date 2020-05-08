package com.company.erp.web.screens.general.widgets.TopCustomersByOutstandingBalanceColumnChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_TopCustomersByOutstandingBalanceFragment")
@UiDescriptor("top-customers-by-outstanding-balance-fragment.xml")
public class TopCustomersByOutstandingBalanceFragment extends ScreenFragment {
    @Inject
    protected KeyValueCollectionLoader topCustomersByOutstandingBalancesLoader;
    @Inject
    private SerialChart stackedAreaOutstandingBalances;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            stackedAreaOutstandingBalances.setTheme(ChartTheme.DARK);

        }
    }


    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        topCustomersByOutstandingBalancesLoader.load();

    }

}