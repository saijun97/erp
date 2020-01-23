package com.company.erp.web.screens.crm.srf.equipment;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.Equipment;

@UiController("erp_Equipment.browse")
@UiDescriptor("equipment-browse.xml")
@LookupComponent("equipmentsTable")
@LoadDataBeforeShow
public class EquipmentBrowse extends StandardLookup<Equipment> {
}