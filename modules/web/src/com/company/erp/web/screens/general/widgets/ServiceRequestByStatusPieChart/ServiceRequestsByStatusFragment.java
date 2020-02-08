package com.company.erp.web.screens.general.widgets.ServiceRequestByStatusPieChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("erp_ServiceRequestsByStatusFragment")
@UiDescriptor("service-requests-by-status-fragment.xml")
public class ServiceRequestsByStatusFragment extends ScreenFragment {

    @Inject
    protected KeyValueCollectionLoader salesPieChartLoader;

    @Subscribe
    protected void onAfterInit(AfterInitEvent event) {

        salesPieChartLoader.load();

    }


}