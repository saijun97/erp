package com.company.erp.web.screens.general.contactperson;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.contact_person.ContactPerson;

@UiController("erp_ContactPerson.browse")
@UiDescriptor("contact-person-browse.xml")
@LookupComponent("contactPersonsTable")
@LoadDataBeforeShow
public class ContactPersonBrowse extends StandardLookup<ContactPerson> {
}