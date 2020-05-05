package com.company.erp.entity.sales_inventory.product.master_data.product_category;

import com.company.erp.entity.cms.catalog_product.CatalogProduct;
import com.company.erp.entity.crm.srf.Equipment;
import com.company.erp.entity.crm.srf.ServiceRequest;
import com.company.erp.entity.general.superclasses.NamedEntity;
import com.company.erp.entity.sales_inventory.product.Product;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "ERP_PRODUCT_CATEGORY")
@Entity(name = "erp_ProductCategory")
public class ProductCategory extends NamedEntity {
    private static final long serialVersionUID = 9216316103960898421L;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "productCategory")
    protected List<Product> product;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "category")
    protected List<CatalogProduct> catalogProduct;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "productCategory")
    protected List<Equipment> serviceRequestEquipment;

    public List<Equipment> getServiceRequestEquipment() {
        return serviceRequestEquipment;
    }

    public void setServiceRequestEquipment(List<Equipment> serviceRequestEquipment) {
        this.serviceRequestEquipment = serviceRequestEquipment;
    }

    public List<CatalogProduct> getCatalogProduct() {
        return catalogProduct;
    }

    public void setCatalogProduct(List<CatalogProduct> catalogProduct) {
        this.catalogProduct = catalogProduct;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}