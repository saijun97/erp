package com.company.erp.web.screens.general.widgets.JobsDistributionPieChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_JobsDistributionFragment")
@UiDescriptor("jobs-distribution-fragment.xml")
public class JobsDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader JobsDistributionPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        JobsDistributionPieChartLoader.load();

    }


}