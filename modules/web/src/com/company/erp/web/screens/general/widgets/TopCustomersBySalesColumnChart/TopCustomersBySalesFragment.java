package com.company.erp.web.screens.general.widgets.TopCustomersBySalesColumnChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_TopCustomersBySalesFragment")
@UiDescriptor("top-customers-by-sales-fragment.xml")
public class TopCustomersBySalesFragment extends ScreenFragment {

    @Inject
    protected KeyValueCollectionLoader topCustomersBySalesLoader;
    @Inject
    private SerialChart stackedArea;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            stackedArea.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        topCustomersBySalesLoader.load();

    }

}