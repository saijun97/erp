package com.company.erp.web.screens.crm.client.contactperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.contact_person.ContactPerson;

@UiController("erp_ContactPerson.edit")
@UiDescriptor("contact-person-edit.xml")
@EditedEntityContainer("contactPersonDc")
@LoadDataBeforeShow
public class ContactPersonEdit extends StandardEditor<ContactPerson> {
}