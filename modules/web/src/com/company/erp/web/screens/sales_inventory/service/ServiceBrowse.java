package com.company.erp.web.screens.sales_inventory.service;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.service.Service;

@UiController("erp_Service.browse")
@UiDescriptor("service-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class ServiceBrowse extends MasterDetailScreen<Service> {
}