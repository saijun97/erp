package com.company.erp.entity.crm.client.superclasses;

import com.company.erp.entity.crm.srf.ServiceRequest;
import com.company.erp.entity.general.country.City;
import com.company.erp.entity.general.country.Country;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

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

    @Email(message = "Please enter a valid email address!")
    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "PREFERRED_CONTACT_PHONE")
    protected String preferredContactPhone;

    @Column(name = "FAX_NUMBER")
    protected String faxNumber;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    protected Country country;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID", nullable = false)
    protected City city;

    @Lob
    @Column(name = "SHIPPING_ADDRESS")
    protected String shippingAddress;

    @Lob
    @Column(name = "BILLING_ADDRESS")
    protected String billingAddress;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "client")
    protected List<Order> order;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "existingClient")
    protected List<ServiceRequest> serviceRequests;

    public List<ServiceRequest> getServiceRequests() {
        return serviceRequests;
    }

    public void setServiceRequests(List<ServiceRequest> serviceRequests) {
        this.serviceRequests = serviceRequests;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

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