package com.company.erp.entity.crm.client.subclasses.person;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.enums.GenderSelect;
import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s %s %s|lastName,firstName,middleName")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("PERSON")
@Table(name = "ERP_CLIENT_PERSON")
@Entity(name = "erp_ClientPerson")
public class ClientPerson extends Client {
    private static final long serialVersionUID = 3109903081173547114L;

    @Column(name = "FIRST_NAME", nullable = false)
    protected String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "MIDDLE_NAME")
    protected String middleName;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "LAST_NAME", nullable = false)
    protected String lastName;


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull
    @Column(name = "GENDER", nullable = false)
    protected Integer gender;

    public void setGender(GenderSelect gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public GenderSelect getGender() {
        return gender == null ? null : GenderSelect.fromId(gender);
    }

    @Column(name = "MOBILE_PHONE")
    protected String mobilePhone;

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Column(name = "HOME_PHONE")
    protected String homePhone;

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    @Column(name = "WORK_PHONE")
    protected String workPhone;

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

}