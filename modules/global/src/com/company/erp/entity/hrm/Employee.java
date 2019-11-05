package com.company.erp.entity.hrm;

import com.company.erp.entity.general.GenderSelect;
import com.company.erp.entity.hrm.dept.Department;
import com.company.erp.entity.hrm.dept.Subunit;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

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

    @NotNull
    @Column(name = "GENDER", nullable = false)
    protected Integer gender;

    @Past(message = "Date of birth should be in the past.")
    @Temporal(TemporalType.DATE)
    @NotNull
    @Column(name = "DOB", nullable = false)
    protected Date dob;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEPARTMENT_ID")
    protected Department department;

    @JoinTable(name = "ERP_EMPLOYEE_SUBUNIT_LINK", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name = "SUBUNIT_ID"))
    @ManyToMany
    protected List<Subunit> subunit;

    @Column(name = "MOBILE_PHONE", unique = true)
    protected String mobilePhone;

    @Column(name = "HOME_PHONE")
    protected String homePhone;

    @Email(message = "Not an email!")
    @Column(name = "EMAIL", unique = true)
    protected String email;

    public void setSubunit(List<Subunit> subunit) {
        this.subunit = subunit;
    }

    public List<Subunit> getSubunit() {
        return subunit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public GenderSelect getGender() {
        return gender == null ? null : GenderSelect.fromId(gender);
    }

    public void setGender(GenderSelect gender) {
        this.gender = gender == null ? null : gender.getId();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

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