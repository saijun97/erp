package com.company.erp.entity.hrm.dept;

import com.company.erp.entity.hrm.employee.Employee;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|department")
@Table(name = "ERP_DEPARTMENT")
@Entity(name = "erp_Department")
public class Department extends StandardEntity {
    private static final long serialVersionUID = -4265061052975944847L;

    @NotNull
    @Column(name = "DEPARTMENT", nullable = false, unique = true)
    protected String department;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "department")
    protected List<Subunit> subunit;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "department")
    protected List<Employee> employee;

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Subunit> getSubunit() {
        return subunit;
    }

    public void setSubunit(List<Subunit> subunit) {
        this.subunit = subunit;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}