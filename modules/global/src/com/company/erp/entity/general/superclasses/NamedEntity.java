package com.company.erp.entity.general.superclasses;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@NamePattern("%s|name")
@MappedSuperclass
public class NamedEntity extends StandardEntity {
    private static final long serialVersionUID = -235808336628528361L;

    @Column(name = "NAME", nullable = false, unique = true)
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}