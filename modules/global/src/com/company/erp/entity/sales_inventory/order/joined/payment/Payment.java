package com.company.erp.entity.sales_inventory.order.joined.payment;

import com.company.erp.entity.general.enums.PaymentTypeSelect;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NamePattern("%s - Rs %s|paymentType,amount")
@Table(name = "ERP_PAYMENT")
@Entity(name = "erp_Payment")
public class Payment extends StandardEntity {
    private static final long serialVersionUID = 8373965178519062867L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXECUTION_DATE", nullable = false)
    protected Date executionDate = new Date();

    @Temporal(TemporalType.DATE)
    @Column(name = "EXECUTION_DATE_INVISIBLE", nullable = false)
    protected Date executionDateInvisible;

    @Column(name = "PAYMENT_TYPE", nullable = false)
    protected String paymentType;

    @NumberFormat(pattern = "0.00")
    @Column(name = "AMOUNT", nullable = false)
    protected BigDecimal amount = BigDecimal.ZERO;

    @CaseConversion
    @Column(name = "CHEQUE_REFERENCE")
    protected String chequeReference;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORDER_ID")
    protected Order order;

    public Date getExecutionDateInvisible() {
        return executionDateInvisible;
    }

    public void setExecutionDateInvisible(Date executionDateInvisible) {
        this.executionDateInvisible = executionDateInvisible;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public String getChequeReference() {
        return chequeReference;
    }

    public void setChequeReference(String chequeReference) {
        this.chequeReference = chequeReference;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentTypeSelect getPaymentType() {
        return paymentType == null ? null : PaymentTypeSelect.fromId(paymentType);
    }

    public void setPaymentType(PaymentTypeSelect paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.getId();
    }
}