package com.company.erp.entity.cms.portal_messages;

import com.company.erp.entity.general.enums.MessageStatus;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@NamePattern("%s|personName")
@Table(name = "ERP_PORTAL_MESSAGES")
@Entity(name = "erp_PortalMessages")
public class PortalMessage extends BaseStringIdEntity {
    private static final long serialVersionUID = -6827668699079940246L;
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    protected String id;

    @Column(name = "PERSON_NAME", nullable = false)
    protected String personName;

    @Email(message = "Please enter a valid email address.")
    @Column(name = "EMAIL", nullable = false)
    protected String email;

    @Column(name = "PHONE_NUMBER")
    protected String phoneNumber;

    @Lob
    @Column(name = "SUBJECT", nullable = false)
    protected String subject;

    @Lob
    @Column(name = "MESSAGE", nullable = false)
    protected String message;

    @Column(name = "STATUS", nullable = false)
    protected String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RECEIVED_TS", nullable = false)
    protected Date receivedTs;

    public Date getReceivedTs() {
        return receivedTs;
    }

    public void setReceivedTs(Date receivedTs) {
        this.receivedTs = receivedTs;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public MessageStatus getStatus() {
        return status == null ? null : MessageStatus.fromId(status);
    }

    public void setStatus(MessageStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}