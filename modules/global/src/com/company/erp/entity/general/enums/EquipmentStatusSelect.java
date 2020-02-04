package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum EquipmentStatusSelect implements EnumClass<String> {

    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    WAITING("WAITING"),
    COMPLETED("COMPLETED"),
    MOVED_TO_STORE("MOVED_TO_STORE");

    private String id;

    EquipmentStatusSelect(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static EquipmentStatusSelect fromId(String id) {
        for (EquipmentStatusSelect at : EquipmentStatusSelect.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}