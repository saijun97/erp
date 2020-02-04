package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum OrderStatusSelect implements EnumClass<String> {

    QUOTE_REQUEST("QUOTE_REQUEST"),
    UNPAID("UNPAID"),
    PARTIALLY_PAID("PARTIALLY_PAID"),
    PAID("PAID"),
    CANCELLED("CANCELLED"),
    BAD_DEBT("BAD_DEBT");

    private String id;

    OrderStatusSelect(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static OrderStatusSelect fromId(String id) {
        for (OrderStatusSelect at : OrderStatusSelect.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}