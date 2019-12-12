package com.company.erp.entity.general.country;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.*;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.List;

@NamePattern("%s|country")
@Table(name = "ERP_COUNTRY")
@Entity(name = "erp_Country")
public class Country extends StandardEntity{
    private static final long serialVersionUID = 6557717258140789980L;

    @Column(name = "COUNTRY_CODE", nullable = false, unique = true, length = 5)
    protected String countryCode;

    @Column(name = "COUNTRY", nullable = false, unique = true)
    protected String country;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "country")
    protected List<City> city;

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