package com.company.erp.entity.sales_inventory.order;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@NamePattern("%s - %s|orderNum, client")
@Table(name = "ERP_ORDER")
@Entity(name = "erp_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -9089137288481687275L;

    @Column(name = "ORDER_NUM", nullable = false, unique = true)
    protected String orderNum;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_ID")
    protected Client client;

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