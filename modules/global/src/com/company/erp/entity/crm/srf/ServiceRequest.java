package com.company.erp.entity.crm.srf;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.enums.ServiceRequestStatusSelect;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.*;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NamePattern("%s - %s|referenceNumber,customerName")
@Table(name = "ERP_SERVICE_REQUEST")
@Entity(name = "erp_ServiceRequest")
public class ServiceRequest extends StandardEntity {
    private static final long serialVersionUID = -8940085849418223303L;

    @NotNull(message = "Please enter a reference number!")
    @CaseConversion(type = ConversionType.UPPER)
    @Column(name = "REFERENCE_NUMBER", unique = true, nullable = false)
    protected String referenceNumber;

    @OnDeleteInverse(DeletePolicy.DENY)
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXISTING_CLIENT_ID")
    protected Client existingClient;

    @NotNull(message = "Please enter customer name!")
    @Column(name = "CUSTOMER_NAME", nullable = false)
    protected String customerName;

    @Column(name = "MOBILE_PHONE")
    protected String mobilePhone;

    @Column(name = "HOME_PHONE")
    protected String homePhone;

    @Column(name = "WORK_PHONE")
    protected String workPhone;

    @Email(message = "Please enter a valid email address!")
    @Column(name = "EMAIL")
    protected String email;

    @Lob
    @Column(name = "ADDRESS")
    protected String address;

    @Column(name = "INVOICE_NUMBER")
    protected String invoiceNumber;

    @NumberFormat(pattern = "0.00")
    @Column(name = "TOTAL_PRICE")
    protected BigDecimal totalPrice = BigDecimal.ZERO;

    @Column(name = "STATUS", nullable = false)
    protected String status;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_RECEIVED", nullable = false)
    protected Date dateReceived;

    @Composition
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "serviceRequest")
    protected List<Equipment> equipment;

    public ServiceRequestStatusSelect getStatus() {
        return status == null ? null : ServiceRequestStatusSelect.fromId(status);
    }

    public void setStatus(ServiceRequestStatusSelect status) {
        this.status = status == null ? null : status.getId();
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Client getExistingClient() {
        return existingClient;
    }

    public void setExistingClient(Client existingClient) {
        this.existingClient = existingClient;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}