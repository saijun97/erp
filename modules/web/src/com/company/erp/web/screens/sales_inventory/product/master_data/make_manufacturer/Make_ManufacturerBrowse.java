package com.company.erp.web.screens.sales_inventory.product.master_data.make_manufacturer;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.product.master_data.make_manufacturer.Make_Manufacturer;

@UiController("erp_Make_Manufacturer.browse")
@UiDescriptor("make_manufacturer-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class Make_ManufacturerBrowse extends MasterDetailScreen<Make_Manufacturer> {
}