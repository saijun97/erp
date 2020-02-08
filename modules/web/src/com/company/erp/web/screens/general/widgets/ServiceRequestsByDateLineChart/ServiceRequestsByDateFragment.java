package com.company.erp.web.screens.general.widgets.ServiceRequestsByDateLineChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_ServiceRequestsByDateFragment")
@UiDescriptor("service-requests-by-date-fragment.xml")
public class ServiceRequestsByDateFragment extends ScreenFragment {
    @Inject
    protected KeyValueCollectionLoader serviceRequestsByDateLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        serviceRequestsByDateLoader.load();

    }
}