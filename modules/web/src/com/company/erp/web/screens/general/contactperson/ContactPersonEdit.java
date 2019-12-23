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
}