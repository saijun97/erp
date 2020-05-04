package com.company.erp.web.screens.general.widgets.EmployeesDepartmentDistributionPieChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_EmployeesDepartmentDistributionFragment")
@UiDescriptor("employees-department-distribution-fragment.xml")
public class EmployeesDepartmentDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader employeesDepartmentDistributionPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        employeesDepartmentDistributionPieChartLoader.load();
    }


}