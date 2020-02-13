package com.company.erp.web.screens.crm.srf.servicerequest;

import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.ServiceRequest;
import de.diedavids.cuba.attachable.web.WithAttachmentsSupport;

import javax.inject.Inject;

@UiController("erp_ServiceRequest.browse")
@UiDescriptor("service-request-browse.xml")
@LookupComponent("serviceRequestsTable")
@LoadDataBeforeShow
public class ServiceRequestBrowse extends StandardLookup<ServiceRequest> implements WithAttachmentsSupport {

    @Inject
    private ButtonsPanel buttonsPanel;
    @Inject
    private GroupTable<ServiceRequest> serviceRequestsTable;

    @Override
    public ListComponent getListComponentForAttachments() {
        return serviceRequestsTable;
    }

    @Override
    public ButtonsPanel getButtonsPanelForAttachments() {
        return buttonsPanel;
    }

    @Override
    public WindowManager.OpenType attachmentListOpenType() {
        return WindowManager.OpenType.DIALOG;
    }

}