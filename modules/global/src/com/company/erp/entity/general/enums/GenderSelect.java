package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum GenderSelect implements EnumClass<Integer> {

    MALE(10),
    FEMALE(20);

    private Integer id;

    GenderSelect(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static GenderSelect fromId(Integer id) {
        for (GenderSelect at : GenderSelect.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}