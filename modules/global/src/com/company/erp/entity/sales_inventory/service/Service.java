package com.company.erp.entity.sales_inventory.service;

import com.company.erp.entity.general.superclasses.Item;
import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@NamePattern("%s|item")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("SERVICE")
@Table(name = "ERP_SERVICE")
@Entity(name = "erp_Service")
public class Service extends Item {
    private static final long serialVersionUID = 4450325310208986785L;

}