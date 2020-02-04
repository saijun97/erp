package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ServiceRequestStatusSelect implements EnumClass<String> {

    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    WAITING("WAITING"),
    COMPLETED("COMPLETED");

    private String id;

    ServiceRequestStatusSelect(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static ServiceRequestStatusSelect fromId(String id) {
        for (ServiceRequestStatusSelect at : ServiceRequestStatusSelect.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}