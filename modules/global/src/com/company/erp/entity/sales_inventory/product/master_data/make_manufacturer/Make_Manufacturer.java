package com.company.erp.entity.sales_inventory.product.master_data.make_manufacturer;

import com.company.erp.entity.general.superclasses.NamedEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "ERP_MAKE_MANUFACTURER")
@Entity(name = "erp_Make_Manufacturer")
public class Make_Manufacturer extends NamedEntity {
    private static final long serialVersionUID = 2985929092210912164L;
}