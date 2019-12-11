package com.company.erp.entity.hrm.qualifications.license;

import com.company.erp.entity.general.superclasses.NamedEntity;
import com.company.erp.entity.hrm.employee.joined.Employee_License;
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
@Table(name = "ERP_LICENSE")
@Entity(name = "erp_License")
public class License extends NamedEntity {
    private static final long serialVersionUID = -1152969138810061024L;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "license")
    protected List<Employee_License> employee;

    public List<Employee_License> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee_License> employee) {
        this.employee = employee;
    }
}