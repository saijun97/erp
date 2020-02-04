package com.company.erp.web.screens.crm.srf.servicerequest;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.ServiceRequest;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@UiController("erp_ServiceRequest.edit")
@UiDescriptor("service-request-edit.xml")
@EditedEntityContainer("serviceRequestDc")
@LoadDataBeforeShow
public class ServiceRequestEdit extends StandardEditor<ServiceRequest> {

    @Inject
    protected LookupField<String> statusField;
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

    @Subscribe
    protected void onInit(InitEvent event) {

        List<String> list = new ArrayList<>();
        list.add("Not Started");
        list.add("Awaiting Client Approval");
        list.add("In Progress");
        list.add("Completed");
        statusField.setOptionsList(list);

    }

    @Subscribe
    protected void onInitEntity(InitEntityEvent<ServiceRequest> event) {

        event.getEntity().setStatus("Not Started");

    }

    @Subscribe("existingClientField")
    public void onExistingClientFieldValueChange(HasValue.ValueChangeEvent<Client> event) {

        if (existingClientField.getValue() == null) {

            customerNameField.clear();
            addressField.clear();
            homePhoneField.clear();
            mobilePhoneField.clear();

        }

        customerNameField.setValue(existingClientField.getValue().getDisplayName());

        addressField.setValue(existingClientField.getValue().getBillingAddress());

        try {

            if (existingClientField.getValue().getPreferredContactPhone().startsWith("5")) {

                mobilePhoneField.setValue(existingClientField.getValue().getPreferredContactPhone());

            } else {

                homePhoneField.setValue(existingClientField.getValue().getPreferredContactPhone());

            }

        } catch (NullPointerException e) {

            System.out.println("Exception Handled.");
        }

    }

}