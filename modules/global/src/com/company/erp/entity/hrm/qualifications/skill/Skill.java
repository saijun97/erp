package com.company.erp.entity.hrm.qualifications.skill;

import com.company.erp.entity.general.superclasses.NamedEntity;
import com.company.erp.entity.hrm.employee.joined.Employee_Skill;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "ERP_SKILL")
@Entity(name = "erp_Skill")
public class Skill extends NamedEntity {
    private static final long serialVersionUID = -6729537307433015837L;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "skill")
    protected List<Employee_Skill> employee;

    public List<Employee_Skill> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee_Skill> employee) {
        this.employee = employee;
    }
}