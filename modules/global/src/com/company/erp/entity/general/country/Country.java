package com.company.erp.entity.general.country;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.*;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;


@Table(name = "ERP_COUNTRY")
@Entity(name = "erp_Country")
public class Country extends BaseGenericIdEntity implements Creatable,Updatable,Versioned{
    private static final long serialVersionUID = 6557717258140789980L;

    @Id
    @Column(name = "COUNTRY_CODE", nullable = false, unique = true, length = 10)
    protected String countryCode;

    @Column(name = "COUNTRY", nullable = false, unique = true)
    protected String country;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "country")
    protected List<City> city;

    @Override
    public void setId(Object id) {

    }

    @Override
    public Object getId() {
        return null;
    }

    @Override
    public Date getCreateTs() {
        return null;
    }

    @Override
    public void setCreateTs(Date date) {

    }

    @Override
    public String getCreatedBy() {
        return null;
    }

    @Override
    public void setCreatedBy(String createdBy) {

    }

    @Override
    public Date getUpdateTs() {
        return null;
    }

    @Override
    public void setUpdateTs(Date updateTs) {

    }

    @Override
    public String getUpdatedBy() {
        return null;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {

    }

    @Override
    public Integer getVersion() {
        return null;
    }

    @Override
    public void setVersion(Integer version) {

    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}