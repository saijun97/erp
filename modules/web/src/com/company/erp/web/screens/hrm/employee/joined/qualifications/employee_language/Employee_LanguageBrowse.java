package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_language;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.joined.Employee_Language;

@UiController("erp_Employee_Language.browse")
@UiDescriptor("employee_language-browse.xml")
@LookupComponent("employee_LanguagesTable")
@LoadDataBeforeShow
public class Employee_LanguageBrowse extends StandardLookup<Employee_Language> {
}