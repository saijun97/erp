package com.company.erp.entity.sales_inventory.product;

import com.company.erp.entity.general.superclasses.Item;
import com.company.erp.entity.sales_inventory.product.master_data.make_manufacturer.Make_Manufacturer;
import com.company.erp.entity.sales_inventory.product.master_data.product_category.ProductCategory;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@NamePattern("%s|item")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("PRODUCT")
@Table(name = "ERP_PRODUCT")
@Entity(name = "erp_Product")
public class Product extends Item {

    private static final long serialVersionUID = -301243273538645092L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_CATEGORY_ID")
    protected ProductCategory productCategory;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAKE_MANUFACTURER_ID")
    protected Make_Manufacturer make_manufacturer;

    @Column(name = "QTY_STORE1", nullable = false)
    protected Integer qtyStore1 = 0;

    @Column(name = "QTY_STORE2", nullable = false)
    protected Integer qtyStore2 = 0;

    @Column(name = "QTY_STORE3", nullable = false)
    protected Integer qtyStore3 = 0;

    @Column(name = "QTY_TOTAL", nullable = false)
    protected Integer qtyTotal = 0;

    @Column(name = "MONITOR_STOCK")
    protected Boolean monitorStock;

    public Boolean getMonitorStock() {
        return monitorStock;
    }

    public void setMonitorStock(Boolean monitorStock) {
        this.monitorStock = monitorStock;
    }

    public Integer getQtyTotal() {
        return qtyTotal;
    }

    public void setQtyTotal(Integer qtyTotal) {
        this.qtyTotal = qtyTotal;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Make_Manufacturer getMake_manufacturer() {
        return make_manufacturer;
    }

    public void setMake_manufacturer(Make_Manufacturer make_manufacturer) {
        this.make_manufacturer = make_manufacturer;
    }

    public Integer getQtyStore3() {
        return qtyStore3;
    }

    public void setQtyStore3(Integer qtyStore3) {
        this.qtyStore3 = qtyStore3;
    }

    public Integer getQtyStore2() {
        return qtyStore2;
    }

    public void setQtyStore2(Integer qtyStore2) {
        this.qtyStore2 = qtyStore2;
    }

    public Integer getQtyStore1() {
        return qtyStore1;
    }

    public void setQtyStore1(Integer qtyStore1) {
        this.qtyStore1 = qtyStore1;
    }

}