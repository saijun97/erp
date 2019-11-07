package com.company.erp.web.screens.hrm.department.subunit;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.dept.Subunit;

@UiController("erp_Subunit.browse")
@UiDescriptor("subunit-browse.xml")
@LookupComponent("subunitsTable")
@LoadDataBeforeShow
public class SubunitBrowse extends StandardLookup<Subunit> {
}