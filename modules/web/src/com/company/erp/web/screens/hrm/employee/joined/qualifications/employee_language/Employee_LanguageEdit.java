package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_language;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.joined.Employee_Language;

@UiController("erp_Employee_Language.edit")
@UiDescriptor("employee_language-edit.xml")
@EditedEntityContainer("employee_LanguageDc")
@LoadDataBeforeShow
public class Employee_LanguageEdit extends StandardEditor<Employee_Language> {
}