package com.company.erp.entity.crm.client.superclasses;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;

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

    @Email(message = "Not an email!")
    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "PREFERRED_CONTACT_PHONE")
    protected String preferredContactPhone;

    @Column(name = "SHIPPING_ADDRESS")
    protected String shippingAddress;

    @Column(name = "BILLING_ADDRESS")
    protected String billingAddress;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }


     public String getPreferredContactPhone() {
        return preferredContactPhone;
    }

    public void setPreferredContactPhone(String preferredContactPhone) {
        this.preferredContactPhone = preferredContactPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }
}