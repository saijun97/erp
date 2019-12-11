package com.company.erp.entity.hrm.employee;

import com.company.erp.entity.general.enums.GenderSelect;
import com.company.erp.entity.general.superclasses.Person;
import com.company.erp.entity.hrm.dept.Department;
import com.company.erp.entity.hrm.dept.Subunit;
import com.company.erp.entity.hrm.employee.joined.Employee_Education;
import com.company.erp.entity.hrm.employee.joined.Employee_Language;
import com.company.erp.entity.hrm.employee.joined.Employee_License;
import com.company.erp.entity.hrm.employee.joined.Employee_Skill;
import com.company.erp.entity.hrm.qualifications.work_exp.Work_Experience;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@NamePattern("%s - %s %s|empId,firstName,lastName")
@Table(name = "ERP_EMPLOYEE")
@Entity(name = "erp_Employee")
public class Employee extends Person {
    private static final long serialVersionUID = 5786142805887575707L;

    @CaseConversion
    @NotNull
    @Column(name = "EMP_ID", nullable = false, unique = true)
    protected String empId;

    @Column(name = "NIC", unique = true)
    protected String nic;

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

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBUNIT_ID")
    protected Subunit subunit;

    @Column(name = "MOBILE_PHONE", unique = true)
    protected String mobilePhone;

    @Column(name = "HOME_PHONE")
    protected String homePhone;

    @Email(message = "Not an email!")
    @Column(name = "EMAIL", unique = true)
    protected String email;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "employee")
    protected List<Employee_Skill> skill;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "employee")
    protected List<Employee_Education> education;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "employee")
    protected List<Work_Experience> workExperience;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "employee")
    protected List<Employee_Language> language;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "employee")
    protected List<Employee_License> license;

    public List<Employee_License> getLicense() {
        return license;
    }

    public void setLicense(List<Employee_License> license) {
        this.license = license;
    }

    public List<Employee_Language> getLanguage() {
        return language;
    }

    public void setLanguage(List<Employee_Language> language) {
        this.language = language;
    }

    public List<Work_Experience> getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(List<Work_Experience> workExperience) {
        this.workExperience = workExperience;
    }

    public List<Employee_Education> getEducation() {
        return education;
    }

    public void setEducation(List<Employee_Education> education) {
        this.education = education;
    }

    public List<Employee_Skill> getSkill() {
        return skill;
    }

    public void setSkill(List<Employee_Skill> skill) {
        this.skill = skill;
    }

    public Subunit getSubunit() {
        return subunit;
    }

    public void setSubunit(Subunit subunit) {
        this.subunit = subunit;
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}