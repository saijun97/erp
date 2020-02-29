package com.company.erp.entity.crm.client.subclasses.person;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.embeddables.PersonName;
import com.company.erp.entity.general.enums.GenderSelect;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.EmbeddedParameters;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|displayName")
@PrimaryKeyJoinColumn(name = "ID", referencedColumnName = "ID")
@DiscriminatorValue("PERSON")
@Table(name = "ERP_CLIENT_PERSON")
@Entity(name = "erp_ClientPerson")
public class ClientPerson extends Client {
    private static final long serialVersionUID = 3109903081173547114L;

    @Embedded
    @EmbeddedParameters(nullAllowed = false)
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "NAME_FIRST_NAME")),
            @AttributeOverride(name = "middleName", column = @Column(name = "NAME_MIDDLE_NAME")),
            @AttributeOverride(name = "lastName", column = @Column(name = "NAME_LAST_NAME"))
    })
    protected PersonName name;

    @NotNull
    @Column(name = "GENDER", nullable = false)
    protected Integer gender;

    @Column(name = "WORK_PHONE")
    protected String workPhone;

    @Column(name = "MOBILE_PHONE")
    protected String mobilePhone;

    @Column(name = "HOME_PHONE")
    protected String homePhone;

    @Column(name = "HOUSE_ADDRESS")
    protected String houseAddress;

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public void setGender(GenderSelect gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public GenderSelect getGender() {
        return gender == null ? null : GenderSelect.fromId(gender);
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public PersonName getName() {
        return name;
    }

    public void setName(PersonName name) {
        this.name = name;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

}