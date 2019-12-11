package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_license;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.joined.Employee_License;

@UiController("erp_Employee_License.browse")
@UiDescriptor("employee_license-browse.xml")
@LookupComponent("employee_LicensesTable")
@LoadDataBeforeShow
public class Employee_LicenseBrowse extends StandardLookup<Employee_License> {
}