package com.company.erp.entity.hrm.qualifications.work_exp;

import com.company.erp.entity.hrm.employee.Employee;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s - %s|company,jobTitle")
@Table(name = "ERP_WORK_EXPERIENCE")
@Entity(name = "erp_Work_Experience")
public class Work_Experience extends StandardEntity {
    private static final long serialVersionUID = -2137743847880885692L;

    @Column(name = "COMPANY", nullable = false)
    protected String company;
    @Column(name = "JOB_TITLE", nullable = false)
    protected String jobTitle;
    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    protected Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    protected Date endDate;
    @Lob
    @Column(name = "COMMENT_")
    protected String comment;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}