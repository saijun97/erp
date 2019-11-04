package com.company.erp.web.screens.hrm.department.subunit;

import com.company.erp.entity.hrm.dept.Subunit;
import com.haulmont.cuba.gui.screen.*;

@UiController("erp_Subunit.edit")
@UiDescriptor("subunit-edit.xml")
@EditedEntityContainer("subunitDc")
@LoadDataBeforeShow
public class SubunitEdit extends StandardEditor<Subunit> {
}