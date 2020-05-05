package com.company.erp.web.screens.general.widgets.ServiceRequestsByStatusPieChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_ServiceRequestByStatusFragment")
@UiDescriptor("service-request-by-status-fragment.xml")
public class ServiceRequestByStatusFragment extends ScreenFragment {

    @Inject
    protected KeyValueCollectionLoader serviceRequestsByStatusPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        serviceRequestsByStatusPieChartLoader.load();

    }

}