package com.company.erp.entity.crm.client.subclasses.company;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;

@NamePattern("%s|displayName")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("COMPANY")
@Table(name = "ERP_CLIENT_COMPANY")
@Entity(name = "erp_ClientCompany")

public class ClientCompany extends Client {
    private static final long serialVersionUID = 7311058099581783252L;

    @Column(name = "COMPANY_NAME", nullable = false, unique = true)
    protected String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Column(name = "COMPANY_ADDRESS")
    protected String companyAddress;

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }


}