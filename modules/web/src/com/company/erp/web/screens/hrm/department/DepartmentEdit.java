package com.company.erp.web.screens.hrm.department;

import com.company.erp.entity.hrm.dept.Department;
import com.haulmont.cuba.gui.screen.*;

@UiController("erp_Department.edit")
@UiDescriptor("department-edit.xml")
@EditedEntityContainer("departmentDc")
@LoadDataBeforeShow
public class DepartmentEdit extends StandardEditor<Department> {
}