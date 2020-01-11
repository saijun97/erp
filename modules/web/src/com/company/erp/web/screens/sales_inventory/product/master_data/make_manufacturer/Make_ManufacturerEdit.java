package com.company.erp.web.screens.sales_inventory.product.master_data.make_manufacturer;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.product.master_data.make_manufacturer.Make_Manufacturer;

@UiController("erp_Make_Manufacturer.edit")
@UiDescriptor("make_manufacturer-edit.xml")
@EditedEntityContainer("make_ManufacturerDc")
@LoadDataBeforeShow
public class Make_ManufacturerEdit extends StandardEditor<Make_Manufacturer> {
}