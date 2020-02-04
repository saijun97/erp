package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TaskCategorySelect implements EnumClass<String> {

    DELIVERY("DELIVERY"),
    COLLECTION("COLLECTION"),
    SELF_COLLECT("SELF_COLLECT"),
    INTERVENTION("INTERVENTION"),
    COMMISSIONING("COMMISSIONING"),
    OTHER("OTHER");

    private String id;

    TaskCategorySelect(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TaskCategorySelect fromId(String id) {
        for (TaskCategorySelect at : TaskCategorySelect.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}