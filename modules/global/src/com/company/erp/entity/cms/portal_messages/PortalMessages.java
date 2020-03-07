package com.company.erp.entity.cms.portal_messages;

import com.company.erp.entity.general.enums.MessageStatus;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@NamePattern("%s|personName")
@Table(name = "ERP_PORTAL_MESSAGES")
@Entity(name = "erp_PortalMessages")
public class PortalMessages extends StandardEntity {
    private static final long serialVersionUID = 6674657305905388437L;

    @Column(name = "PERSON_NAME", nullable = false)
    protected String personName;

    @Email
    @Column(name = "EMAIL")
    protected String email;

    @Column(name = "PHONE_NUMBER")
    protected String phoneNumber;

    @Lob
    @Column(name = "MESSAGE", nullable = false)
    protected String message;

    @Column(name = "STATUS")
    protected String status;

    public MessageStatus getStatus() {
        return status == null ? null : MessageStatus.fromId(status);
    }

    public void setStatus(MessageStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}