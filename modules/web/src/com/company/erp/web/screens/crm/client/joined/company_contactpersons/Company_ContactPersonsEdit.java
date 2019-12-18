package com.company.erp.web.screens.crm.client.joined.company_contactpersons;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.client.subclasses.company.joined.Company_ContactPersons;

@UiController("erp_Company_ContactPersons.edit")
@UiDescriptor("company_contact-persons-edit.xml")
@EditedEntityContainer("company_ContactPersonsDc")
@LoadDataBeforeShow
public class Company_ContactPersonsEdit extends StandardEditor<Company_ContactPersons> {
}