package com.company.erp.entity.hrm.employee;

import com.company.erp.entity.general.country.City;
import com.company.erp.entity.general.country.Country;
import com.company.erp.entity.general.superclasses.Person;
import com.company.erp.entity.hrm.dept.Department;
import com.company.erp.entity.hrm.dept.Subunit;
import com.company.erp.entity.hrm.employee.joined.Employee_Education;
import com.company.erp.entity.hrm.employee.joined.Employee_Language;
import com.company.erp.entity.hrm.employee.joined.Employee_License;
import com.company.erp.entity.hrm.employee.joined.Employee_Skill;
import com.company.erp.entity.hrm.job_positions.Job_Position;
import com.company.erp.entity.hrm.qualifications.work_exp.Work_Experience;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.*;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.security.entity.User;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@NamePattern("%s|fullName")
@Table(name = "ERP_EMPLOYEE")
@Entity(name = "erp_Employee")
public class Employee extends Person {
    private static final long serialVersionUID = 5786142805887575707L;

    @CaseConversion(type = ConversionType.UPPER)
    @NotNull(message = "Please enter employee ID!")
    @Column(name = "EMP_ID", nullable = false)
    protected String empId;

    @Column(name = "NIC")
    protected String nic;

    @Past(message = "Date of birth should be in the past.")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Please enter date of birth!")
    @Column(name = "DOB", nullable = false)
    protected Date dob;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NATIONALITY_ID")
    protected Country nationality;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_OF_RESIDENCE_ID")
    protected Country countryOfResidence;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Lob
    @Column(name = "STREET_ADDRESS_APARTMENT")
    protected String streetAddressApartment;

    @Lob
    @Column(name = "ADDRESS")
    protected String address;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEPARTMENT_ID")
    protected Department department;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBUNIT_ID")
    protected Subunit subunit;

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

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_POSITION_ID")
    protected Job_Position jobPosition;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreetAddressApartment() {
        return streetAddressApartment;
    }

    public void setStreetAddressApartment(String streetAddressApartment) {
        this.streetAddressApartment = streetAddressApartment;
    }

    public Country getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(Country countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public Job_Position getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(Job_Position jobPosition) {
        this.jobPosition = jobPosition;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

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