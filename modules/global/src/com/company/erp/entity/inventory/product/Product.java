package com.company.erp.entity.inventory.product;

import com.company.erp.entity.general.superclasses.Item;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.*;

@NamePattern("%s|item")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("PRODUCT")
@Table(name = "ERP_PRODUCT")
@Entity(name = "erp_Product")
public class Product extends Item {

    private static final long serialVersionUID = -301243273538645092L;

    @Column(name = "QTY_STORE1")
    protected Integer qtyStore1;

    @Column(name = "QTY_STORE2")
    protected Integer qtyStore2;

    @Column(name = "QTY_STORE3")
    protected Integer qtyStore3;

    @Transient
    @MetaProperty(related = {"qtyStore1", "qtyStore2", "qtyStore3"})
    protected Integer qtyTotal;

    public Integer getQtyTotal() { return qtyTotal; }

    public void setQtyTotal(Integer qtyTotal) {this.qtyTotal = qtyTotal;}

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