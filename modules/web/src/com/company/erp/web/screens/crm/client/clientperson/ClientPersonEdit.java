package com.company.erp.web.screens.crm.client.clientperson;

import com.company.erp.entity.general.country.City;
import com.company.erp.entity.general.country.Country;
import com.company.erp.entity.general.enums.GenderSelect;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.ResizableTextArea;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.client.subclasses.person.ClientPerson;

import javax.inject.Inject;

@UiController("erp_ClientPerson.edit")
@UiDescriptor("client-person-edit.xml")
@EditedEntityContainer("clientPersonDc")
@LoadDataBeforeShow
public class ClientPersonEdit extends StandardEditor<ClientPerson> {

    String displayNameValue;
    
    @Inject
    protected TextField<String> firstNameField;
    @Inject
    protected TextField<String> middleNameField;
    @Inject
    protected TextField<String> lastNameField;
    @Inject
    protected TextField<String> displayNameField;
    @Inject
    private LookupField<City> cityField;
    @Inject
    private ResizableTextArea<String> billingAddressField;
    @Inject
    private ResizableTextArea<String> shippingAddressField;
    @Inject
    private LookupField<Country> countryField;
    @Inject
    private TextField<String> houseAddressField;

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        if (lastNameField.getValue() != null) {

            displayNameValue = lastNameField.getValue();
        }

        if (firstNameField.getValue() != null) {

            displayNameValue += " " + firstNameField.getValue();

        }

        if (middleNameField.getValue() != null) {

            displayNameValue += " " + middleNameField.getValue();

        }

        displayNameField.setValue(displayNameValue);

        shippingAddressField.setValue(generateBillingAndShippingAddressValue());
        billingAddressField.setValue(generateBillingAndShippingAddressValue());

    }

    @Subscribe("countryField")
    public void onCountryFieldValueChange(HasValue.ValueChangeEvent<Country> event) {

        cityField.clear();

    }

    public String generateBillingAndShippingAddressValue() {

        String AddressValue;

        //computing value of billingAddress and shippingAddress
        AddressValue = generatePersonName();

        if (houseAddressField.getValue() != null) {

            AddressValue += houseAddressField.getValue() + "," + "\n";

            if (cityField.getValue() != null) {

                AddressValue += cityField.getValue().getCity() + "," + "\n";
            }

            if(countryField.getValue() != null) {

                AddressValue +=  countryField.getValue().getCountry() + "," + "\n";
            }

        }

        if (houseAddressField.getValue() == null) {

            if (cityField.getValue() != null) {

                AddressValue += cityField.getValue().getCity() + "," + "\n";
            }

            if(countryField.getValue() != null) {

                AddressValue +=  countryField.getValue().getCountry() + "," + "\n";
            }

        }

        return AddressValue;

    }

    public String generatePersonName () {

        String personNameValue = null;

        if (getEditedEntity().getGender() == GenderSelect.MALE) {

            personNameValue = "Mr. " + displayNameField.getValue() + "\n";

        }

        else if (getEditedEntity().getGender() == GenderSelect.FEMALE) {

            personNameValue = "Mrs/Miss. " + displayNameField.getValue() + "\n";

        }

        return personNameValue;

    }


}