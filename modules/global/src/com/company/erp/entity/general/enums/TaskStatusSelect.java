package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum TaskStatusSelect implements EnumClass<String> {


    ACTIVE("ACTIVE"),
    PENDING("PENDING"),
    COMPLETED("COMPLETED");

    private String id;

    TaskStatusSelect(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TaskStatusSelect fromId(String id) {
        for (TaskStatusSelect at : TaskStatusSelect.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}