package com.company.erp.web.screens.crm.srf.servicerequest;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.ServiceRequest;

import javax.inject.Inject;

@UiController("erp_ServiceRequest.edit")
@UiDescriptor("service-request-edit.xml")
@EditedEntityContainer("serviceRequestDc")
@LoadDataBeforeShow
public class ServiceRequestEdit extends StandardEditor<ServiceRequest> {

    @Inject
    private TextArea<String> addressField;

    @Inject
    private LookupPickerField<Client> existingClientField;

    @Inject
    private TextField<String> mobilePhoneField;

    @Inject
    private TextField<String> homePhoneField;

    @Inject
    private TextField<String> customerNameField;

    @Subscribe("existingClientField")
    public void onExistingClientFieldValueChange(HasValue.ValueChangeEvent<Client> event) {

        customerNameField.setValue(existingClientField.getValue().getDisplayName());

        addressField.setValue(existingClientField.getValue().getBillingAddress());

        if (existingClientField.getValue().getPreferredContactPhone().startsWith("5")) {

            mobilePhoneField.setValue(existingClientField.getValue().getPreferredContactPhone());

        }

        else {

            homePhoneField.setValue(existingClientField.getValue().getPreferredContactPhone());

        }

    }


}