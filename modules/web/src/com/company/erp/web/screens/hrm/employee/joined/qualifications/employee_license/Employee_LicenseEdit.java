package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_license;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.joined.Employee_License;

@UiController("erp_Employee_License.edit")
@UiDescriptor("employee_license-edit.xml")
@EditedEntityContainer("employee_LicenseDc")
@LoadDataBeforeShow
public class Employee_LicenseEdit extends StandardEditor<Employee_License> {
}