package com.company.erp.web.screens.crm.contactperson;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.contact_person.ContactPerson;

import javax.inject.Inject;

@UiController("erp_ContactPerson.edit")
@UiDescriptor("contact-person-edit.xml")
@EditedEntityContainer("contactPersonDc")
@LoadDataBeforeShow
public class ContactPersonEdit extends StandardEditor<ContactPerson> {

    @Inject
    protected TextField<String> firstNameField;

    @Inject
    protected TextField<String> middleNameField;

    @Inject
    protected TextField<String> lastNameField;

    @Inject
    protected TextField<String> fullNameField;

    String fullNameValue;

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        if (firstNameField.getValue() != null) {

            fullNameValue = firstNameField.getValue();
        }

        if (middleNameField.getValue() != null) {

            fullNameValue += " " + middleNameField.getValue();

        }

        if (lastNameField.getValue() != null) {

            fullNameValue += " " + lastNameField.getValue();

        }

        fullNameField.setValue(fullNameValue);

    }
}