package com.company.erp.entity.hrm.job_positions;

import com.company.erp.entity.general.superclasses.NamedEntity;
import com.company.erp.entity.hrm.employee.Employee;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "ERP_JOB_POSITION")
@Entity(name = "erp_Job_Position")
public class Job_Position extends NamedEntity {
    private static final long serialVersionUID = -2546984030083424525L;

    @Lob
    @Column(name = "RESPONSIBILITIES")
    protected String responsibilities;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "jobPosition")
    protected List<Employee> employee;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

}