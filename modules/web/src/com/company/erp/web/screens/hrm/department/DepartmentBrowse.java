package com.company.erp.web.screens.hrm.department;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.dept.Department;

@UiController("erp_Department.browse")
@UiDescriptor("department-browse.xml")
@LookupComponent("departmentsTable")
@LoadDataBeforeShow
public class DepartmentBrowse extends StandardLookup<Department> {
}