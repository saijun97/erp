package com.company.erp.entity.crm.client.superclasses;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@NamePattern("%s|displayName")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("Client")
@Table(name = "ERP_CLIENT")
@Entity(name = "erp_Client")
public class Client extends StandardEntity {
    private static final long serialVersionUID = 4780989409314858228L;

    @Column(name = "DISPLAY_NAME")
    protected String displayName;

    public String getDisplayName() {
        return displayName;
    }

    @Column(name = "WORK_PHONE")
    protected String workPhone;

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    @Column(name = "SHIPPING_ADDRESS")
    protected String shippingAddress;

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Column(name = "BILLING_ADDRESS")
    protected String billingAddress;

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}