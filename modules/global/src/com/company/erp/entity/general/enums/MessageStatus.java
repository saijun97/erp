package com.company.erp.entity.general.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum MessageStatus implements EnumClass<String> {

    READ("READ"),
    UNREAD("UNREAD");

    private String id;

    MessageStatus(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static MessageStatus fromId(String id) {
        for (MessageStatus at : MessageStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}