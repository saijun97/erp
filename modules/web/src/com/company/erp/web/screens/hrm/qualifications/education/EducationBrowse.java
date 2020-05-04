package com.company.erp.web.screens.hrm.qualifications.education;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.education.Education;

@UiController("erp_Education.browse")
@UiDescriptor("education-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class EducationBrowse extends MasterDetailScreen<Education> {
}