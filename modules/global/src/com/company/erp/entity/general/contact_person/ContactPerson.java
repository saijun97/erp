package com.company.erp.entity.general.contact_person;

import com.company.erp.entity.crm.client.subclasses.company.joined.Company_ContactPersons;
import com.company.erp.entity.general.superclasses.Person;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NamePattern("%s|fullName")
@Table(name = "ERP_CONTACT_PERSON")
@Entity(name = "erp_ContactPerson")

public class ContactPerson extends Person {
    private static final long serialVersionUID = -4028025489066728451L;

    @Column(name = "WORK_PHONE")
    protected String workPhone;

    @Column(name = "PREFERRED_PHONE")
    protected String preferredPhone;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "contactPerson")
    protected List<Company_ContactPersons> clientCompany;

    public String getPreferredPhone() {
        return preferredPhone;
    }

    public void setPreferredPhone(String preferredPhone) {
        this.preferredPhone = preferredPhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public List<Company_ContactPersons> getClientCompany() {
        return clientCompany;
    }

    public void setClientCompany(List<Company_ContactPersons> clientCompany) {
        this.clientCompany = clientCompany;
    }
}