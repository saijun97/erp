package com.company.erp.entity.crm.client.subclasses.company.joined;

import com.company.erp.entity.crm.client.subclasses.company.ClientCompany;
import com.company.erp.entity.crm.contact_person.ContactPerson;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NamePattern("%s|contactPerson")
@Table(name = "ERP_COMPANY_CONTACT_PERSONS")
@Entity(name = "erp_Company_ContactPersons")
public class Company_ContactPersons extends StandardEntity {
    private static final long serialVersionUID = -4456777061214988408L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_COMPANY_ID")
    protected ClientCompany clientCompany;

    @NotNull
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONTACT_PERSON_ID")
    protected ContactPerson contactPerson;

    @Column(name = "WORK_PHONE")
    protected String workPhone;

    @Email(message = "Please enter a valid E-mail Address.")
    @Column(name = "PREFERRED_EMAIL")
    protected String preferredEmail;

    public String getPreferredEmail() {
        return preferredEmail;
    }

    public void setPreferredEmail(String preferredEmail) {
        this.preferredEmail = preferredEmail;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }


    public ClientCompany getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(ClientCompany clientCompany) {
        this.clientCompany = clientCompany;
    }
}