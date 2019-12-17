package com.company.erp.web.screens.crm.client.clientcompany;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.client.subclasses.company.ClientCompany;

import javax.inject.Inject;

@UiController("erp_ClientCompany.edit")
@UiDescriptor("client-company-edit.xml")
@EditedEntityContainer("clientCompanyDc")
@LoadDataBeforeShow
public class ClientCompanyEdit extends StandardEditor<ClientCompany> {


    @Inject
    protected TextField<String> companyNameField;
    @Inject
    protected TextField<String> displayNameField;

    String displayNameValue;

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        displayNameValue = companyNameField.getValue();

        displayNameField.setValue(displayNameValue);

    }
}