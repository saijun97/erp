package com.company.erp.web.screens.hrm.qualifications.skill;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.skill.Skill;

@UiController("erp_Skill.edit")
@UiDescriptor("skill-edit.xml")
@EditedEntityContainer("skillDc")
@LoadDataBeforeShow
public class SkillEdit extends StandardEditor<Skill> {
}