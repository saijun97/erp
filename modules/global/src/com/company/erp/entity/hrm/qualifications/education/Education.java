package com.company.erp.entity.hrm.qualifications.education;

import com.company.erp.entity.general.superclasses.NamedEntity;
import com.company.erp.entity.hrm.employee.joined.Employee_Education;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "ERP_EDUCATION")
@Entity(name = "erp_Education")
public class Education extends NamedEntity {
    private static final long serialVersionUID = -8313955446688164957L;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "education")
    protected List<Employee_Education> employee;

    public List<Employee_Education> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee_Education> employee) {
        this.employee = employee;
    }
}