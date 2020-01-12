package com.company.erp.entity.general.superclasses;

import com.company.erp.entity.general.embeddables.PersonName;
import com.company.erp.entity.general.enums.GenderSelect;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NamePattern("%s|fullName")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ERP_PERSON")
@Entity(name = "erp_Person")

public class Person extends StandardEntity {
    private static final long serialVersionUID = 6929497339503047073L;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "NAME_FIRST_NAME")),
            @AttributeOverride(name = "middleName", column = @Column(name = "NAME_MIDDLE_NAME")),
            @AttributeOverride(name = "lastName", column = @Column(name = "NAME_LAST_NAME"))
    })
    protected PersonName name;

    @Column(name = "FULL_NAME",nullable = false)
    protected String fullName;

    @NotNull
    @Column(name = "GENDER", nullable = false)
    protected Integer gender;

    @Column(name = "MOBILE_PHONE")
    protected String mobilePhone;

    @Column(name = "HOME_PHONE")
    protected String homePhone;

    @Email(message = "Not an email!")
    @Column(name = "EMAIL")
    protected String email;

    public PersonName getName() {
        return name;
    }

    public void setName(PersonName name) {
        this.name = name;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getFullName() { return fullName;}

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public void setGender(GenderSelect gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public GenderSelect getGender() {
        return gender == null ? null : GenderSelect.fromId(gender);
    }
}