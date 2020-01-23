package com.company.erp.entity.sales_inventory.order.joined.order_item;

import com.company.erp.entity.general.superclasses.Item;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;

@NamePattern("%s|item")
@Table(name = "ERP_ORDER_ITEM")
@Entity(name = "erp_OrderItem")
public class OrderItem extends StandardEntity {
    private static final long serialVersionUID = -1684371168176867317L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ITEM_ID")
    protected Item item;

    @Column(name = "QUANTITY", nullable = false)
    protected String quantity;

    @Column(name = "PRICE", nullable = false)
    protected String price;
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}