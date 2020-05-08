package com.company.erp.web.screens.general.widgets.EmployeesDepartmentDistributionPieChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_EmployeesDepartmentDistributionFragment")
@UiDescriptor("employees-department-distribution-fragment.xml")
public class EmployeesDepartmentDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader employeesDepartmentDistributionPieChartLoader;
    @Inject
    private PieChart employeesDistributionPieChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            employeesDistributionPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        employeesDepartmentDistributionPieChartLoader.load();
    }


}