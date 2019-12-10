package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_education;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.joined.Employee_Education;

@UiController("erp_Employee_Education.edit")
@UiDescriptor("employee_education-edit.xml")
@EditedEntityContainer("employee_EducationDc")
@LoadDataBeforeShow
public class Employee_EducationEdit extends StandardEditor<Employee_Education> {
}