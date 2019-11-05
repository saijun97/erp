package com.company.erp.entity.hrm.dept;

import com.company.erp.entity.hrm.Employee;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|subunit")
@Table(name = "ERP_SUBUNIT")
@Entity(name = "erp_Subunit")
public class Subunit extends StandardEntity {
    private static final long serialVersionUID = 3473706214278719417L;

    @NotNull
    @Column(name = "SUBUNIT", nullable = false)
    protected String subunit;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DEPARTMENT_ID")
    protected Department department;

    @JoinTable(name = "ERP_EMPLOYEE_SUBUNIT_LINK",
            joinColumns = @JoinColumn(name = "SUBUNIT_ID"),
            inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
    @ManyToMany
    protected List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSubunit() {
        return subunit;
    }

    public void setSubunit(String subunit) {
        this.subunit = subunit;
    }
}