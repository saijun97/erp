package com.company.erp.entity.hrm.employee.joined;

import com.company.erp.entity.hrm.employee.Employee;
import com.company.erp.entity.hrm.qualifications.license.License;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s|license")
@Table(name = "ERP_EMPLOYEE_LICENSE")
@Entity(name = "erp_Employee_License")
public class Employee_License extends StandardEntity {
    private static final long serialVersionUID = -4646705480245412404L;

    @OnDeleteInverse(DeletePolicy.DENY)
    @Lookup(type = LookupType.DROPDOWN)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LICENSE_ID")
    protected License license;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    @Column(name = "LICENSE_NUMBER", nullable = false, unique = true)
    protected String licenseNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "ISSUED_DATE")
    protected Date issuedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "EXPIRY_DATE")
    protected Date expiryDate;

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }
}