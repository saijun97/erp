package com.company.erp.web.screens.general.widgets.EducationDistributionPieChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_EducationDistributionFragment")
@UiDescriptor("education-distribution-fragment.xml")
public class EducationDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader educationDistributionPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        educationDistributionPieChartLoader.load();

    }

}