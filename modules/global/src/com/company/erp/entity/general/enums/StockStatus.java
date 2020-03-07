package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum StockStatus implements EnumClass<String> {

    AVAILABLE("AVAILABLE"),
    OUT_OF_STOCK("OUT OF STOCK");

    private String id;

    StockStatus(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static StockStatus fromId(String id) {
        for (StockStatus at : StockStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}