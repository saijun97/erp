package com.company.erp.web.screens.hrm.department;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.dept.Department;

@UiController("erp_Department.edit")
@UiDescriptor("department-edit.xml")
@EditedEntityContainer("departmentDc")
@LoadDataBeforeShow
public class DepartmentEdit extends StandardEditor<Department> {
}