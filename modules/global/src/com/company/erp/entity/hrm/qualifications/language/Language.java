package com.company.erp.entity.hrm.qualifications.language;

import com.company.erp.entity.general.superclasses.NamedEntity;
import com.company.erp.entity.hrm.employee.joined.Employee_Education;
import com.company.erp.entity.hrm.employee.joined.Employee_Language;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "ERP_LANGUAGE")
@Entity(name = "erp_Language")
public class Language extends NamedEntity {
    private static final long serialVersionUID = 2436808891587972103L;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "language")
    protected List<Employee_Language> employee;

    public List<Employee_Language> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee_Language> employee) {
        this.employee = employee;
    }
}