package com.company.erp.entity.hrm;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

@NamePattern("%s %s %s|empId,firstName,lastName")
@Table(name = "ERP_EMPLOYEE")
@Entity(name = "erp_Employee")
public class Employee extends StandardEntity {
    private static final long serialVersionUID = 5786142805887575707L;

    @CaseConversion
    @NotNull
    @Column(name = "EMP_ID", nullable = false, unique = true)
    protected String empId;

    @Column(name = "NIC", unique = true)
    protected String nic;

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)
    protected String firstName;

    @Column(name = "MIDDLE_NAME")
    protected String middleName;

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)
    protected String lastName;

    @Past(message = "Date of birth should be in the past.")
    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "DOB", nullable = false)
    protected Date dob;

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}