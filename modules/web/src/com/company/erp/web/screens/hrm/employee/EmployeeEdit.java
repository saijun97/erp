package com.company.erp.web.screens.hrm.employee;

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

    String fullNameValue;

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        if (firstNameField.getValue() != null) {

            fullNameValue = firstNameField.getValue();
        }

        if (middleNameField.getValue() != null) {

            fullNameValue += " " + middleNameField.getValue();

        }

        if (lastNameField.getValue() != null) {

            fullNameValue += " " + lastNameField.getValue();

        }

        fullNameField.setValue(fullNameValue);

    }


}