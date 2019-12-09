package com.company.erp.web.screens.hrm.qualifications.skill;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.skill.Skill;

@UiController("erp_Skill.browse")
@UiDescriptor("skill-browse.xml")
@LookupComponent("skillsTable")
@LoadDataBeforeShow
public class SkillBrowse extends StandardLookup<Skill> {
}