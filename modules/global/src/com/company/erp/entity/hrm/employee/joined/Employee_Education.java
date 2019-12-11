package com.company.erp.entity.hrm.employee.joined;

import com.company.erp.entity.hrm.employee.Employee;
import com.company.erp.entity.hrm.qualifications.education.Education;
import com.company.erp.entity.hrm.qualifications.language.Language;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s|education")
@Table(name = "ERP_EMPLOYEE_EDUCATION")
@Entity(name = "erp_Employee_Education")
public class Employee_Education extends StandardEntity {
    private static final long serialVersionUID = 2073399229770567617L;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EDUCATION_ID", unique = true)
    protected Education education;

    @Column(name = "INSTITUTE", nullable = false)
    protected String institute;

    @Column(name = "MAJOR_SPECIALIZATION")
    protected String majorSpecialization;

    @Temporal(TemporalType.DATE)
    @Column(name = "YEAR_")
    protected Date year;

    @Column(name = "GPA_SCORE")
    protected Integer gpaScore;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    protected Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    protected Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
         this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getGpaScore() {
        return gpaScore;
    }

    public void setGpaScore(Integer gpaScore) {
        this.gpaScore = gpaScore;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public String getMajorSpecialization() {
        return majorSpecialization;
    }

    public void setMajorSpecialization(String majorSpecialization) {
        this.majorSpecialization = majorSpecialization;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}