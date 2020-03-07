package com.company.erp.entity.crm.client.subclasses.company;

import com.company.erp.entity.crm.client.subclasses.company.joined.Company_ContactPersons;
import com.company.erp.entity.crm.client.superclasses.Client;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import com.haulmont.cuba.core.entity.annotation.ConversionType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@NamePattern("%s|displayName")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("COMPANY")
@Table(name = "ERP_CLIENT_COMPANY")
@Entity(name = "erp_ClientCompany")

public class ClientCompany extends Client {
    private static final long serialVersionUID = 7311058099581783252L;

    @Column(name = "COMPANY_NAME", nullable = false)
    protected String companyName;

    @Column(name = "COMPANY_ADDRESS", nullable = false)
    protected String companyAddress;

    @CaseConversion(type = ConversionType.UPPER)
    @Column(name = "BRN")
    protected String brn;

    @CaseConversion(type = ConversionType.UPPER)
    @Column(name = "VAT_NUMBER")
    protected String vatNumber;

    @Email(message = "Not an email!")
    @Column(name = "SECONDARY_EMAIL")
    protected String secondaryEmail;

    @Column(name = "ALTERNATE_PHONE")
    protected String alternatePhone;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "clientCompany")
    protected List<Company_ContactPersons> contactPerson;

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getBrn() {
        return brn;
    }

    public void setBrn(String brn) {
        this.brn = brn;
    }

    public List<Company_ContactPersons> getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(List<Company_ContactPersons> contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

}