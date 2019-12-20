package com.company.erp.web.screens.crm.client.clientcompany;

import com.company.erp.entity.general.country.City;
import com.company.erp.entity.general.country.Country;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.client.subclasses.company.ClientCompany;

import javax.inject.Inject;

@UiController("erp_ClientCompany.edit")
@UiDescriptor("client-company-edit.xml")
@EditedEntityContainer("clientCompanyDc")
@LoadDataBeforeShow
public class ClientCompanyEdit extends StandardEditor<ClientCompany> {

    @Inject
    protected TextField<String> companyNameField;
    @Inject
    protected TextField<String> displayNameField;
    @Inject
    protected LookupPickerField<Country> countryField;
    @Inject
    protected LookupPickerField<City> cityField;
    @Inject
    protected TextField<String> companyAddressField;
    @Inject
    protected TextArea<String> billingAddressField;

    String displayNameValue;
    String billingAddressValue;

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        //setting value of displayName
        displayNameValue = companyNameField.getValue();

        displayNameField.setValue(displayNameValue);


        //setting value of billingAddress
        if(billingAddressField.getValue() == null) {

            if (companyAddressField.getValue() != null) {

                billingAddressValue = companyNameField.getValue() + ","  + "\n";
            }

            if (cityField.getValue() != null) {

                billingAddressValue += cityField.getValue().getCity() + "," + "\n";
            }

            if(countryField.getValue() != null) {

                billingAddressValue +=  countryField.getValue().getCountry() + "," + "\n";
            }

            billingAddressField.setValue(billingAddressValue);
        }

    }

}
