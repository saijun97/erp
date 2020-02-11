package com.company.erp.entity.hrm.employee.joined;

import com.company.erp.entity.hrm.employee.Employee;
import com.company.erp.entity.hrm.qualifications.language.Language;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;

@NamePattern("%s|language")
@Table(name = "ERP_EMPLOYEE_LANGUAGE")
@Entity(name = "erp_Employee_Language")
public class Employee_Language extends StandardEntity {
    private static final long serialVersionUID = 5876255225687038201L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    @OnDeleteInverse(DeletePolicy.DENY)
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LANGUAGE_ID")
    protected Language language;

    @Column(name = "FLUENCY", nullable = false)
    protected String fluency;

    @Column(name = "COMPETENCY", nullable = false)
    protected String competency;

    @Lob
    @Column(name = "COMMENTS")
    protected String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCompetency() {
        return competency;
    }

    public void setCompetency(String competency) {
        this.competency = competency;
    }

    public String getFluency() {
        return fluency;
    }

    public void setFluency(String fluency) {
        this.fluency = fluency;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}