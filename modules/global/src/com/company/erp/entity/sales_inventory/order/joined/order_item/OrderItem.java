package com.company.erp.entity.sales_inventory.order.joined.order_item;

import com.company.erp.entity.general.superclasses.Item;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.math.BigDecimal;

@NamePattern("%s|item")
@Table(name = "ERP_ORDER_ITEM")
@Entity(name = "erp_OrderItem")
public class OrderItem extends StandardEntity {
    private static final long serialVersionUID = -1684371168176867317L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_ID")
    @OnDeleteInverse(DeletePolicy.DENY)
    protected Item item;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @NumberFormat(pattern = "0.00")
    @Column(name = "UNIT_VAT_PRICE", nullable = false)
    protected BigDecimal unitVatPrice = BigDecimal.ZERO;

    @Column(name = "QUANTITY", nullable = false)
    protected Integer quantity = 1;

    @NumberFormat(pattern = "0.00")
    @Column(name = "AMOUNT", nullable = false)
    protected BigDecimal amount = BigDecimal.ZERO;

    @OnDeleteInverse(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getUnitVatPrice() {
        return unitVatPrice;
    }

    public void setUnitVatPrice(BigDecimal unitVatPrice) {
        this.unitVatPrice = unitVatPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}