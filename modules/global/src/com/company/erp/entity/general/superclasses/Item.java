package com.company.erp.entity.general.superclasses;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@NamePattern("%s|item")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("ITEM")
@Table(name = "ERP_ITEM")
@Entity(name = "erp_Item")
public class Item extends StandardEntity {
    private static final long serialVersionUID = -2443831023789493823L;

    @Column(name = "ITEM", nullable = false)
    protected String item;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @NumberFormat(pattern = "0.00")
    @Column(name = "COST")
    protected BigDecimal cost = BigDecimal.ZERO;

    @NumberFormat(pattern = "0.00")
    @Column(name = "PRICE")
    protected BigDecimal price = BigDecimal.ZERO;

    @Column(name = "APPLY_VAT")
    protected Boolean applyVat;

    @NumberFormat(pattern = "0.00")
    @Column(name = "VAT_PRICE")
    protected BigDecimal vatPrice = BigDecimal.ZERO;

    public Boolean getApplyVat() {
        return applyVat;
    }

    public void setApplyVat(Boolean applyVat) {
        this.applyVat = applyVat;
    }

    public BigDecimal getVatPrice() {
        return vatPrice;
    }

    public void setVatPrice(BigDecimal vatPrice) {
        this.vatPrice = vatPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}