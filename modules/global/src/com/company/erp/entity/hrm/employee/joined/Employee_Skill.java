package com.company.erp.entity.hrm.employee.joined;

import com.company.erp.entity.hrm.employee.Employee;
import com.company.erp.entity.hrm.qualifications.skill.Skill;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;

@NamePattern("%s|skill")
@Table(name = "ERP_EMPLOYEE_SKILL")
@Entity(name = "erp_Employee_Skill")
public class Employee_Skill extends StandardEntity {

    private static final long serialVersionUID = -3739092663768331185L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    @OnDeleteInverse(DeletePolicy.DENY)
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SKILL_ID")
    protected Skill skill;

    @Column(name = "YEARS_OF_EXPERIENCE")
    protected Integer yearsOfExperience;

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    @Lob
    @Column(name = "COMMENT")
    protected String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}