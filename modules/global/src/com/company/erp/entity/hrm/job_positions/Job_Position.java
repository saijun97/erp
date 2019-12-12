package com.company.erp.entity.hrm.job_positions;

import com.company.erp.entity.general.superclasses.NamedEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "ERP_JOB_POSITION")
@Entity(name = "erp_Job_Position")
public class Job_Position extends NamedEntity {
    private static final long serialVersionUID = -2546984030083424525L;

    @Lob
    @Column(name = "RESPONSIBILITIES")
    protected String responsibilities;

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

}