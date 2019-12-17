package com.company.erp.entity.crm.contact_person;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.superclasses.Person;
import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.*;

@NamePattern("#getFullName,firstName,middleName,lastName")
@Table(name = "ERP_CONTACT_PERSON")
@Entity(name = "erp_ContactPerson")
public class ContactPerson extends Person {
    private static final long serialVersionUID = -4028025489066728451L;

    @Column(name = "JOB_POSITION")
    protected String jobPosition;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_ID")
    protected Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }
}