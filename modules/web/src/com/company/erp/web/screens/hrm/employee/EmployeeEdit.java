package com.company.erp.web.screens.hrm.employee;

import com.company.erp.entity.hrm.dept.Department;
import com.company.erp.entity.hrm.dept.Subunit;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.Employee;

import javax.inject.Inject;

@UiController("erp_Employee.edit")
@UiDescriptor("employee-edit.xml")
@EditedEntityContainer("employeeDc")
@LoadDataBeforeShow
public class EmployeeEdit extends StandardEditor<Employee> {

}