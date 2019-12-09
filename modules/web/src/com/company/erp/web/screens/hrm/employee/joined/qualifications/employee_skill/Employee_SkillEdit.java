package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_skill;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.joined.Employee_Skill;

@UiController("erp_Employee_Skill.edit")
@UiDescriptor("employee_skill-edit.xml")
@EditedEntityContainer("employee_SkillDc")
@LoadDataBeforeShow
public class Employee_SkillEdit extends StandardEditor<Employee_Skill> {
}