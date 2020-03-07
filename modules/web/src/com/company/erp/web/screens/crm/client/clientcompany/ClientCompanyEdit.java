package com.company.erp.web.screens.crm.client.clientcompany;

import com.company.erp.entity.general.country.City;
import com.company.erp.entity.general.country.Country;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.*;
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
    @Inject
    private ResizableTextArea<String> shippingAddressField;
    @Inject
    protected Dialogs dialogs;

    String prevCompanyAddressFieldValue;
    City prevCityFieldValue;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {

        prevCityFieldValue = cityField.getValue();
        prevCompanyAddressFieldValue =companyAddressField.getValue();

    }

    @Subscribe("windowCommitBtn")
    public void onWindowCommitBtnClick(Button.ClickEvent event) {

        String displayNameValue;
        String currentCompanyAddressValue = getEditedEntity().getCompanyAddress();
        City currentCityValue = getEditedEntity().getCity();

        //setting value of displayName
        displayNameValue = companyNameField.getValue();

        displayNameField.setValue(displayNameValue);


        try {

            if (!currentCityValue.equals(prevCityFieldValue) | !currentCompanyAddressValue.equals(prevCompanyAddressFieldValue) | getEditedEntity().getBillingAddress() == null) {

                showConfirmationDialogForGeneratingBillingAndShippingAddress();
                prevCityFieldValue = currentCityValue;
                prevCompanyAddressFieldValue = currentCompanyAddressValue;

            }

        } catch (NullPointerException e) {

            System.out.println("Exception Handled");

        }



    }

    @Subscribe("countryField")
    public void onCountryFieldValueChange(HasValue.ValueChangeEvent<Country> event) {

        cityField.clear();

    }

    public void showConfirmationDialogForGeneratingBillingAndShippingAddress() {

        dialogs.createOptionDialog()
                .withCaption("Update Billing and Shipping Address Confirmation")
                .withMessage("Address fields of this client has changed." +
                        " Would you like to update Bill/Invoice To and Shipping" +
                        " address fields? Please note any custom text added to current" +
                        " value of those fields will be overwritten.")
                .withType(Dialogs.MessageType.CONFIRMATION)
                .withActions(
                        new DialogAction(DialogAction.Type.YES) {
                            @Override
                            public void actionPerform(Component component) {

                                billingAddressField.setValue(generateBillingAndShippingAddressValue());
                                shippingAddressField.setValue(generateBillingAndShippingAddressValue());
                            }
                        },
                        new DialogAction(DialogAction.Type.NO)
                )
                .show();

    }

     public String generateBillingAndShippingAddressValue() {

         String AddressValue;

         //computing value of billingAddress and shippingAddress
         AddressValue = companyNameField.getValue() + ","  + "\n";

         if (companyAddressField.getValue() != null) {

             AddressValue += companyAddressField.getValue() + "," + "\n";

             if (cityField.getValue() != null) {

                 AddressValue += cityField.getValue().getCity() + "," + "\n";
             }

             if(countryField.getValue() != null) {

                 AddressValue +=  countryField.getValue().getCountry() + "," + "\n";
             }

         }

         if (companyAddressField.getValue() == null) {

             if (cityField.getValue() != null) {

                 AddressValue += cityField.getValue().getCity() + "," + "\n";
             }

             if(countryField.getValue() != null) {

                 AddressValue +=  countryField.getValue().getCountry() + "," + "\n";
             }

         }

         return AddressValue;
     }

}
