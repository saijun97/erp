package com.company.erp.entity.hrm.dept;

import com.company.erp.entity.hrm.Employee;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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