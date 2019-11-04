package com.company.erp.web.screens.subunit;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.dept.Subunit;

@UiController("erp_Subunit.edit")
@UiDescriptor("subunit-edit.xml")
@EditedEntityContainer("subunitDc")
@LoadDataBeforeShow
public class SubunitEdit extends StandardEditor<Subunit> {
}