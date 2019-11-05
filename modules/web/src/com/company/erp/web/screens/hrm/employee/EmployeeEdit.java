package com.company.erp.web.screens.hrm.employee;

import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.Employee;

@UiController("erp_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {

}