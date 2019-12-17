package com.company.erp.web.screens.crm.client.clientperson;

import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.client.subclasses.person.ClientPerson;

import javax.inject.Inject;

@UiController("erp_ClientPerson.edit")
@UiDescriptor("client-person-edit.xml")
@EditedEntityContainer("clientPersonDc")
@LoadDataBeforeShow
public class ClientPersonEdit extends StandardEditor<ClientPerson> {


    @Inject
    protected TextField<String> firstNameField;

    @Inject
    protected TextField<String> middleNameField;

    @Inject
    protected TextField<String> lastNameField;

    @Inject
    protected TextField<String> displayNameField;

    String displayNameValue;

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        if (firstNameField.getValue() != null) {

            displayNameValue = firstNameField.getValue();
        }

        if (middleNameField.getValue() != null) {

            displayNameValue += " " + middleNameField.getValue();

        }

        if (lastNameField.getValue() != null) {

            displayNameValue += " " + lastNameField.getValue();

        }

        displayNameField.setValue(displayNameValue);

    }

}