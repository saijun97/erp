package com.company.erp.entity.general.country;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;

import javax.persistence.*;
import java.util.UUID;

@NamePattern("%s|city")
@Table(name = "ERP_CITY")
@Entity(name = "erp_City")
public class City extends BaseStringIdEntity implements HasUuid {
    private static final long serialVersionUID = -2646160433746077559L;
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    protected String ID;
    @Column(name = "UUID")
    protected UUID uuid;

    @Column(name = "CITY", nullable = false)
    protected String city;

    @Column(name = "COORDINATES")
    protected String coordinates;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COUNTRY_ID")
    protected Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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