package com.company.erp.entity.sales_inventory.product.master_data.product_category;

import com.company.erp.entity.general.superclasses.NamedEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import jdk.jfr.Name;

import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "ERP_PRODUCT_CATEGORY")
@Entity(name = "erp_ProductCategory")
public class ProductCategory extends NamedEntity {
    private static final long serialVersionUID = 9216316103960898421L;
}