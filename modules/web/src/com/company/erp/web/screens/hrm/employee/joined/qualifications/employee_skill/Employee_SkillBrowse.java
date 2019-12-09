package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_skill;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.joined.Employee_Skill;

@UiController("erp_Employee_Skill.browse")
@UiDescriptor("employee_skill-browse.xml")
@LookupComponent("employee_SkillsTable")
@LoadDataBeforeShow
public class Employee_SkillBrowse extends StandardLookup<Employee_Skill> {
}