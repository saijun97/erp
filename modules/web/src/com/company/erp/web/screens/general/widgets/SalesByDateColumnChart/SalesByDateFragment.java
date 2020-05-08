package com.company.erp.web.screens.general.widgets.SalesByDateColumnChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_SalesByDateFragment")
@UiDescriptor("sales-by-date-fragment.xml")
public class SalesByDateFragment extends ScreenFragment {

    @Inject
    protected KeyValueCollectionLoader salesByDateColumnChartLoader;
    @Inject
    private SerialChart salesByDateColumnChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            salesByDateColumnChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        salesByDateColumnChartLoader.load();

    }


}