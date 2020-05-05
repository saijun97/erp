package com.company.erp.entity.sales_inventory.product.master_data.make_manufacturer;

import com.company.erp.entity.cms.catalog_product.CatalogProduct;
import com.company.erp.entity.general.superclasses.NamedEntity;
import com.company.erp.entity.sales_inventory.product.Product;
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
@Table(name = "ERP_MAKE_MANUFACTURER")
@Entity(name = "erp_Make_Manufacturer")
public class Make_Manufacturer extends NamedEntity {
    private static final long serialVersionUID = 2985929092210912164L;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "make_manufacturer")
    protected List<Product> product;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "brand")
    protected List<CatalogProduct> catalogProduct;

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