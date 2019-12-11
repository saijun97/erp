package com.company.erp.entity.general.country;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@NamePattern("%s|country")
@Table(name = "ERP_COUNTRY")
@Entity(name = "erp_Country")
public class Country extends BaseStringIdEntity implements HasUuid {
    private static final long serialVersionUID = -9649097526378150L;
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    protected String ID;

    @Column(name = "UUID")
    protected UUID uuid;

    @Column(name = "COUNTRY", nullable = false)
    protected String country;

    @Composition
    @OneToMany(mappedBy = "country")
    protected List<City> city;

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public void setId(String id) {
        this.ID = id;
    }

    @Override
    public String getId() {
        return ID;
    }
}