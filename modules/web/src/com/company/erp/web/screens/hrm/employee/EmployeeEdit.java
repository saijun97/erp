package com.company.erp.web.screens.hrm.employee;

import com.company.erp.entity.general.country.City;
import com.company.erp.entity.general.country.Country;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.Employee;

import javax.inject.Inject;

@UiController("erp_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {

    @Inject
    protected TextField<String> firstNameField;

    @Inject
    protected TextField<String> middleNameField;

    @Inject
    protected TextField<String> lastNameField;

    @Inject
    protected TextField<String> fullNameField;

    @Inject
    protected TextArea<String> addressField;

    @Inject
    protected TextArea<String> streetAddressApartmentField;

    @Inject
    protected LookupPickerField<City> cityField;

    @Inject
    protected LookupPickerField<Country> countryOfResidenceField;

    String fullNameValue;
    String addressValue;

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        //computing fullName value
        if (firstNameField.getValue() != null) {

            fullNameValue = firstNameField.getValue();
        }

        if (middleNameField.getValue() != null) {

            fullNameValue += " " + middleNameField.getValue();

        }

        if (lastNameField.getValue() != null) {

            fullNameValue += " " + lastNameField.getValue();

        }

        //setting value to fullNameField
        fullNameField.setValue(fullNameValue);


        //computing address value

            if (streetAddressApartmentField.getValue() != null){

                addressValue = streetAddressApartmentField.getValue() + "," + "\n";
            }

            if (cityField.getValue() != null) {

                addressValue += cityField.getValue().getCity() + "," + "\n" + countryOfResidenceField.getValue().getCountry();

            }

            //setting value to addressField
            addressField.setValue(addressValue);

    }

}