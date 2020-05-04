package com.company.erp.entity.hrm.employee.joined;

import com.company.erp.entity.hrm.employee.Employee;
import com.company.erp.entity.hrm.qualifications.education.Education;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NamePattern("%s|education")
@Table(name = "ERP_EMPLOYEE_EDUCATION")
@Entity(name = "erp_Employee_Education")
public class Employee_Education extends StandardEntity {
    private static final long serialVersionUID = 2073399229770567617L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    @OnDeleteInverse(DeletePolicy.DENY)
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EDUCATION_ID")
    protected Education education;

    @Column(name = "INSTITUTE", nullable = false)
    protected String institute;

    @Column(name = "MAJOR_SPECIALIZATION")
    protected String majorSpecialization;

    @Temporal(TemporalType.DATE)
    @Column(name = "YEAR_")
    protected Date year;

    @NumberFormat(pattern = "0.00")
    @Column(name = "GPA_SCORE")
    protected BigDecimal gpaScore;

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

    public BigDecimal getGpaScore() {
        return gpaScore;
    }

    public void setGpaScore(BigDecimal gpaScore) {
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