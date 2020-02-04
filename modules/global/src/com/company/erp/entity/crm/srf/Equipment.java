package com.company.erp.entity.crm.srf;

import com.company.erp.entity.general.enums.EquipmentStatusSelect;
import com.company.erp.entity.sales_inventory.product.master_data.product_category.ProductCategory;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.CaseConversion;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NamePattern("%s - %s|makeModel,status")
@Table(name = "ERP_EQUIPMENT")
@Entity(name = "erp_Equipment")
public class Equipment extends StandardEntity {
    private static final long serialVersionUID = -4511887263169691755L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_CATEGORY_ID")
    protected ProductCategory productCategory;

    @NotNull(message = "Please enter the make and model of equipment!")
    @Column(name = "MAKE_MODEL", nullable = false)
    protected String makeModel;

    @CaseConversion
    @Column(name = "SERIAL_NUMBER")
    protected String serialNumber;

    @Lob
    @Column(name = "VISIBLE_DEFECT")
    protected String visibleDefect;

    @Lob
    @Column(name = "PROBLEM_DESCRIPTION")
    protected String problemDescription;

    @Lob
    @Column(name = "TECHNICIAN_REPORT")
    protected String technicianReport;

    @Column(name = "STATUS", nullable = false)
    protected String status;

    @Column(name = "PRICE")
    protected BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SERVICE_REQUEST_ID")
    protected ServiceRequest serviceRequest;

    public EquipmentStatusSelect getStatus() {
        return status == null ? null : EquipmentStatusSelect.fromId(status);
    }

    public void setStatus(EquipmentStatusSelect status) {
        this.status = status == null ? null : status.getId();
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public ServiceRequest getServiceRequest() {
        return serviceRequest;
    }

    public void setServiceRequest(ServiceRequest serviceRequest) {
        this.serviceRequest = serviceRequest;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTechnicianReport() {
        return technicianReport;
    }

    public void setTechnicianReport(String technicianReport) {
        this.technicianReport = technicianReport;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getVisibleDefect() {
        return visibleDefect;
    }

    public void setVisibleDefect(String visibleDefect) {
        this.visibleDefect = visibleDefect;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }
}