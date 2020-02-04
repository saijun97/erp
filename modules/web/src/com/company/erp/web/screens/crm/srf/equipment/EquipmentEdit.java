package com.company.erp.web.screens.crm.srf.equipment;

import com.company.erp.entity.general.enums.EquipmentStatusSelect;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.Equipment;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@UiController("erp_Equipment.edit")
@UiDescriptor("equipment-edit.xml")
@EditedEntityContainer("equipmentDc")
@LoadDataBeforeShow
public class EquipmentEdit extends StandardEditor<Equipment> {
    @Inject
    protected LookupField<String> statusField;

    @Subscribe
    protected void onInitEntity(InitEntityEvent<Equipment> event) {

        getEditedEntity().setStatus(EquipmentStatusSelect.PENDING);

    }


}