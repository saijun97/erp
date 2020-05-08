package com.company.erp.entity.sales_inventory.order;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.enums.OrderStatusSelect;
import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;
import com.company.erp.entity.sales_inventory.order.joined.payment.Payment;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.*;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@PublishEntityChangedEvents
@NamePattern("%s|orderNum")
@Table(name = "ERP_ORDER")
@Entity(name = "erp_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -9089137288481687275L;

    @Column(name = "ORDER_NUM", unique = true)
    protected String orderNum;

    @OnDeleteInverse(DeletePolicy.DENY)
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_ID")
    protected Client client;

    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE", nullable = false)
    protected Date orderDate = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "DELIVERY_DATE")
    protected Date deliveryDate;
    
    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "order")
    protected List<OrderItem> item;

    @Composition
    @OnDelete(DeletePolicy.UNLINK)
    @OneToMany(mappedBy = "order")
    protected List<Payment> payments;

    @NumberFormat(pattern = "0.00")
    @Column(name = "TOTAL_AMOUNT")
    protected BigDecimal totalAmount = BigDecimal.ZERO;

    @NumberFormat(pattern = "0.00")
    @Column(name = "AMOUNT_DUE", nullable = false)
    protected BigDecimal amountDue = BigDecimal.ZERO;

    @Column(name = "STATUS", nullable = false)
    protected String status = "QUOTE_REQUEST";

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public OrderStatusSelect getStatus() {
        return status == null ? null : OrderStatusSelect.fromId(status);
    }

    public void setStatus(OrderStatusSelect status) {
        this.status = status == null ? null : status.getId();
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderItem> getItem() {
        return item;
    }

    public void setItem(List<OrderItem> item) {
        this.item = item;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}