package com.company.erp.web.screens.general.widgets.PendingServiceRequestsTable;

import com.company.erp.entity.crm.srf.ServiceRequest;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.navigation.UrlParamsChangedEvent;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_PendingServiceRequestsTableFragment")
@UiDescriptor("pending-service-requests-table-fragment.xml")
public class PendingServiceRequestsTableFragment extends ScreenFragment {

    @Inject
    protected CollectionLoader<ServiceRequest> pendingServiceRequestsLoader;
    @Inject
    protected CollectionContainer<ServiceRequest> pendingServiceRequestsDc;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        pendingServiceRequestsLoader.load();

    }

}