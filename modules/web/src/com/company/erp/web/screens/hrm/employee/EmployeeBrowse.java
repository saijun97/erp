package com.company.erp.web.screens.hrm.employee;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.Employee;

@UiController("erp_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> {
}