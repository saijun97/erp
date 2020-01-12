package com.company.erp.web.screens.crm.srf.servicerequest;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.ServiceRequest;

@UiController("erp_ServiceRequest.edit")
@UiDescriptor("service-request-edit.xml")
@EditedEntityContainer("serviceRequestDc")
@LoadDataBeforeShow
public class ServiceRequestEdit extends StandardEditor<ServiceRequest> {
}