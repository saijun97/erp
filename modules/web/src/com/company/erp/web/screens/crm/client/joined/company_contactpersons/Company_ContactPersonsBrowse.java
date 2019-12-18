package com.company.erp.web.screens.crm.client.joined.company_contactpersons;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.client.subclasses.company.joined.Company_ContactPersons;

@UiController("erp_Company_ContactPersons.browse")
@UiDescriptor("company_contact-persons-browse.xml")
@LookupComponent("company_ContactPersonsesTable")
@LoadDataBeforeShow
public class Company_ContactPersonsBrowse extends StandardLookup<Company_ContactPersons> {
}