package com.company.erp.web.screens.general.contactperson;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.contact_person.ContactPerson;

import javax.inject.Inject;

@UiController("erp_ContactPerson.edit")
@UiDescriptor("contact-person-edit.xml")
@EditedEntityContainer("contactPersonDc")
@LoadDataBeforeShow
public class ContactPersonEdit extends StandardEditor<ContactPerson> {
    @Inject
    private TextField<String> firstNameField;
    @Inject
    private TextField<String> middleNameField;
    @Inject
    private TextField<String> lastNameField;
    @Inject
    private TextField<String> fullNameField;

    String fullNameValue;

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        //computing fullName value
        if (lastNameField.getValue() != null) {

            fullNameValue = lastNameField.getValue();
        }

        if (firstNameField.getValue() != null) {

            fullNameValue += " " + firstNameField.getValue();

        }

        if (middleNameField.getValue() != null) {

            fullNameValue += " " + middleNameField.getValue();

        }

        //setting value to fullNameField
        fullNameField.setValue(fullNameValue);

    }

}