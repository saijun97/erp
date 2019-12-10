package com.company.erp.web.screens.hrm.qualifications.work_experience;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.work_exp.Work_Experience;

@UiController("erp_Work_Experience.browse")
@UiDescriptor("work_experience-browse.xml")
@LookupComponent("work_ExperiencesTable")
@LoadDataBeforeShow
public class Work_ExperienceBrowse extends StandardLookup<Work_Experience> {
}