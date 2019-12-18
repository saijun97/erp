package com.company.erp.web.screens.crm.contactperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.contact_person.ContactPerson;

@UiController("erp_ContactPerson.browse")
@UiDescriptor("contact-person-browse.xml")
@LookupComponent("contactPersonsTable")
@LoadDataBeforeShow
public class ContactPersonBrowse extends StandardLookup<ContactPerson> {
}