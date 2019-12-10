package com.company.erp.web.screens.hrm.qualifications.education;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.education.Education;

@UiController("erp_Education.edit")
@UiDescriptor("education-edit.xml")
@EditedEntityContainer("educationDc")
@LoadDataBeforeShow
public class EducationEdit extends StandardEditor<Education> {
}