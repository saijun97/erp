package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum PaymentTypeSelect implements EnumClass<String> {

    CASH("CASH"),
    CHEQUE("CHEQUE"),
    CARD("CARD"),
    BANK_TRANSFER("BANK_TRANSFER"),
    MCB_JUICE("MCB_JUICE"),
    MYT_MONEY("MYT_MONEY");

    private String id;

    PaymentTypeSelect(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PaymentTypeSelect fromId(String id) {
        for (PaymentTypeSelect at : PaymentTypeSelect.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}