package com.company.erp.web.screens.hrm.qualifications.work_experience;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.work_exp.Work_Experience;

@UiController("erp_Work_Experience.edit")
@UiDescriptor("work_experience-edit.xml")
@EditedEntityContainer("work_ExperienceDc")
@LoadDataBeforeShow
public class Work_ExperienceEdit extends StandardEditor<Work_Experience> {
}