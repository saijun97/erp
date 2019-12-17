package com.company.erp.entity.general.superclasses;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NamePattern("#getfullName|firstName,middleName,lastName")
@MappedSuperclass
public class Person extends StandardEntity {
    private static final long serialVersionUID = 6929497339503047073L;



    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    protected String firstName;

    @Column(name = "MIDDLE_NAME")
    protected String middleName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    protected String lastName;

    @Column(name = "MOBILE_PHONE", unique = true)
    protected String mobilePhone;

    @Column(name = "HOME_PHONE")
    protected String homePhone;

    @Email(message = "Not an email!")
    @Column(name = "EMAIL", unique = true)
    protected String email;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Transient
    @MetaProperty(related = "firstName,middleName,lastName")
    public String getfullName() {

        String fullName;
        fullName = firstName;

        if (middleName != null) {

            fullName += " " + middleName;

        }

        if (lastName != null) {

            fullName += " " + lastName;

        }

        return fullName;

    }

}