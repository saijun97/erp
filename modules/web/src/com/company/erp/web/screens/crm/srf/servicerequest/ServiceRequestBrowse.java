package com.company.erp.web.screens.crm.srf.servicerequest;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.ServiceRequest;

@UiController("erp_ServiceRequest.browse")
@UiDescriptor("service-request-browse.xml")
@LookupComponent("serviceRequestsTable")
@LoadDataBeforeShow
public class ServiceRequestBrowse extends StandardLookup<ServiceRequest> {
}