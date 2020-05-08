package com.company.erp.web.screens.general.widgets.ServiceRequestsByStatusPieChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.amcharts.model.Color;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_ServiceRequestByStatusFragment")
@UiDescriptor("service-request-by-status-fragment.xml")
public class ServiceRequestByStatusFragment extends ScreenFragment {

    @Inject
    protected KeyValueCollectionLoader serviceRequestsByStatusPieChartLoader;

    @Inject
    protected UserSettingsTools userSettingsTools;
    @Inject
    private PieChart srfPieChart;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            srfPieChart.setTheme(ChartTheme.DARK);

        }
    }


    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        serviceRequestsByStatusPieChartLoader.load();

    }

}