package com.company.erp.web.screens.hrm.qualifications.license;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.license.License;

@UiController("erp_License.edit")
@UiDescriptor("license-edit.xml")
@EditedEntityContainer("licenseDc")
@LoadDataBeforeShow
public class LicenseEdit extends StandardEditor<License> {
}