package com.company.erp.entity.crm.client.subclasses.company;

import com.company.erp.entity.crm.client.subclasses.company.joined.Company_ContactPersons;
import com.company.erp.entity.crm.client.superclasses.Client;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s|companyName")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("COMPANY")
@Table(name = "ERP_CLIENT_COMPANY")
@Entity(name = "erp_ClientCompany")

public class ClientCompany extends Client {
    private static final long serialVersionUID = 7311058099581783252L;

    @Column(name = "COMPANY_NAME", nullable = false)
    protected String companyName;

    @Column(name = "COMPANY_ADDRESS")
    protected String companyAddress;

    @Column(name = "BRN", unique = true)
    protected String brn;

    @CaseConversion
    @Column(name = "VAT_NUMBER", unique = true)
    protected String vatNumber;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "clientCompany")
    protected List<Company_ContactPersons> contactPerson;

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

}