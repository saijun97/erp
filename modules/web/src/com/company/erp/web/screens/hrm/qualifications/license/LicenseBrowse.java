package com.company.erp.web.screens.hrm.qualifications.license;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.license.License;

@UiController("erp_License.browse")
@UiDescriptor("license-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class LicenseBrowse extends MasterDetailScreen<License> {
}