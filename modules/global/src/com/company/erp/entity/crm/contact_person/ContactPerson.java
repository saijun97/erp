package com.company.erp.entity.crm.contact_person;

import com.company.erp.entity.general.superclasses.Person;
import com.haulmont.chile.core.annotations.NamePattern;

import javax.persistence.*;

@NamePattern("%s|fullName")
@Table(name = "ERP_CONTACT_PERSON")
@Entity(name = "erp_ContactPerson")
public class ContactPerson extends Person {
    private static final long serialVersionUID = -4028025489066728451L;

}