package com.company.erp.web.screens.crm.client.joined.company_contactpersons;

import com.company.erp.entity.general.contact_person.ContactPerson;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.client.subclasses.company.joined.Company_ContactPersons;

import javax.inject.Inject;

@UiController("erp_Company_ContactPersons.edit")
@UiDescriptor("company_contact-persons-edit.xml")
@EditedEntityContainer("company_ContactPersonsDc")
@LoadDataBeforeShow
public class Company_ContactPersonsEdit extends StandardEditor<Company_ContactPersons> {

    @Inject
    protected TextField<String> preferredEmailField;
    @Inject
    protected LookupPickerField<ContactPerson> contactPersonField;
    @Inject
    private TextField<String> preferredCompanyPhoneField;

    @Subscribe("contactPersonField")
    public void onContactPersonFieldValueChange(HasValue.ValueChangeEvent<ContactPerson> event) {

        if (contactPersonField.getValue().getEmail() != null) {

            if (preferredEmailField.getValue() == null) {

                preferredEmailField.setValue(contactPersonField.getValue().getEmail());
            }

        }

        if (preferredCompanyPhoneField.getValue() == null) {

            if (contactPersonField.getValue().getPreferredPhone() != null) {

                preferredCompanyPhoneField.setValue(contactPersonField.getValue().getPreferredPhone());

            }

        }

    }

}