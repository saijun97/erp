package com.company.erp.web.screens.general.widgets.ServiceRequestsByDateLineChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_ServiceRequestsByDateFragment")
@UiDescriptor("service-requests-by-date-fragment.xml")
public class ServiceRequestsByDateFragment extends ScreenFragment {
    @Inject
    protected KeyValueCollectionLoader serviceRequestsByDateLoader;
    @Inject
    private SerialChart lineChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            lineChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        serviceRequestsByDateLoader.load();

    }
}