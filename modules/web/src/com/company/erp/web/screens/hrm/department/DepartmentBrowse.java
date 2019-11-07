package com.company.erp.web.screens.hrm.department;

import com.company.erp.entity.hrm.dept.Department;
import com.haulmont.cuba.gui.screen.*;

@UiController("erp_Department.browse")
@UiDescriptor("department-browse.xml")
@LookupComponent("departmentsTable")
@LoadDataBeforeShow
public class DepartmentBrowse extends StandardLookup<Department> {
}