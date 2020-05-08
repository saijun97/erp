package com.company.erp.web.screens.general.widgets.JobsDistributionPieChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_JobsDistributionFragment")
@UiDescriptor("jobs-distribution-fragment.xml")
public class JobsDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader JobsDistributionPieChartLoader;
    @Inject
    private PieChart jobsDistributionPieChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            jobsDistributionPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        JobsDistributionPieChartLoader.load();

    }


}