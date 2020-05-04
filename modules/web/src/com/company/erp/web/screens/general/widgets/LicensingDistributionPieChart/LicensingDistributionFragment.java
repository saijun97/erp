package com.company.erp.web.screens.general.widgets.LicensingDistributionPieChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_LicensingDistributionFragment")
@UiDescriptor("licensing-distribution-fragment.xml")
public class LicensingDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader LicensingDistributionPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        LicensingDistributionPieChartLoader.load();
    }

}