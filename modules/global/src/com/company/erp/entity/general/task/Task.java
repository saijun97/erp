package com.company.erp.entity.general.task;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.country.City;
import com.company.erp.entity.general.country.Country;
import com.company.erp.entity.general.enums.TaskCategorySelect;
import com.company.erp.entity.general.enums.TaskStatusSelect;
import com.company.erp.entity.hrm.employee.Employee;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s - %s|taskNum,client")
@Table(name = "ERP_TASK")
@Entity(name = "erp_Task")
public class Task extends StandardEntity {
    private static final long serialVersionUID = 8719083966825545607L;

    @Column(name = "TASK_NUM", unique = true)
    protected String taskNum;

    @Column(name = "CATEGORY", nullable = false)
    protected String category;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_NUM_ID")
    protected Order orderNum;

    @Column(name = "PO_INVOICE_NUM")
    protected String poInvoiceNum;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CLIENT_ID")
    protected Client client;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    protected Country country;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    protected City city;

    @Lob
    @Column(name = "CONTACT")
    protected String contact;

    @Lob
    @Column(name = "REQUEST")
    protected String request;

    @Lob
    @Column(name = "REMARK")
    protected String remark;

    @Lob
    @Column(name = "ITEM_REQUIRED")
    protected String itemRequired;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EMPLOYEE_ID")
    protected Employee employee;

    @Column(name = "STATUS", nullable = false)
    protected String status = "PENDING";

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", nullable = false)
    protected Date startDate = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "COMPLETION_DATE")
    protected Date completionDate;

    public TaskStatusSelect getStatus() {
        return status == null ? null : TaskStatusSelect.fromId(status);
    }

    public void setStatus(TaskStatusSelect status) {
        this.status = status == null ? null : status.getId();
    }

    public TaskCategorySelect getCategory() {
        return category == null ? null : TaskCategorySelect.fromId(category);
    }

    public void setCategory(TaskCategorySelect category) {
        this.category = category == null ? null : category.getId();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getItemRequired() {
        return itemRequired;
    }

    public void setItemRequired(String itemRequired) {
        this.itemRequired = itemRequired;
    }

    public String getPoInvoiceNum() {
        return poInvoiceNum;
    }

    public void setPoInvoiceNum(String poInvoiceNum) {
        this.poInvoiceNum = poInvoiceNum;
    }

    public Order getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Order orderNum) {
        this.orderNum = orderNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getTaskNum() {
        return taskNum;
    }

    public void setTaskNum(String taskNum) {
        this.taskNum = taskNum;
    }
}