package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_education;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.joined.Employee_Education;

@UiController("erp_Employee_Education.browse")
@UiDescriptor("employee_education-browse.xml")
@LookupComponent("employee_EducationsTable")
@LoadDataBeforeShow
public class Employee_EducationBrowse extends StandardLookup<Employee_Education> {
}