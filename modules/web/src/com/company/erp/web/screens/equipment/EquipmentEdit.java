package com.company.erp.web.screens.equipment;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.Equipment;

@UiController("erp_Equipment.edit")
@UiDescriptor("equipment-edit.xml")
@EditedEntityContainer("equipmentDc")
@LoadDataBeforeShow
public class EquipmentEdit extends StandardEditor<Equipment> {
}