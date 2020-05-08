package com.company.erp.web.screens.general.widgets.EducationDistributionPieChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_EducationDistributionFragment")
@UiDescriptor("education-distribution-fragment.xml")
public class EducationDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader educationDistributionPieChartLoader;
    @Inject
    private PieChart educationDistributionPieChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            educationDistributionPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        educationDistributionPieChartLoader.load();

    }

}