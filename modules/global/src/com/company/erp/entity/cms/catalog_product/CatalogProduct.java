package com.company.erp.entity.cms.catalog_product;

import com.company.erp.entity.general.enums.StockStatus;
import com.company.erp.entity.general.superclasses.NamedEntity;
import com.company.erp.entity.sales_inventory.product.Product;
import com.company.erp.entity.sales_inventory.product.master_data.make_manufacturer.Make_Manufacturer;
import com.company.erp.entity.sales_inventory.product.master_data.product_category.ProductCategory;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.NumberFormat;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.math.BigDecimal;

@NamePattern("%s|name")
@Table(name = "ERP_CATALOG_PRODUCT")
@Entity(name = "erp_CatalogProduct")
public class CatalogProduct extends NamedEntity {
    private static final long serialVersionUID = 7123575211205597784L;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @OnDeleteInverse(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    protected Product product;

    @NumberFormat(pattern = "0.00")
    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price = BigDecimal.ZERO;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open", "clear"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    protected Make_Manufacturer brand;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup", "open"})
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    protected ProductCategory category;

    @Column(name = "STOCK_STATUS")
    protected String stockStatus;

    @MetaProperty(datatype = "EntitySoftReference")
    @Column(name = "IMAGE")
    protected com.haulmont.cuba.core.entity.Entity image;

    @Lob
    @Column(name = "PUBLIC_IMAGE")
    protected String publicImage;

    public String getPublicImage() {
        return publicImage;
    }

    public void setPublicImage(String publicImage) {
        this.publicImage = publicImage;
    }

    public Make_Manufacturer getBrand() {
        return brand;
    }

    public void setBrand(Make_Manufacturer brand) {
        this.brand = brand;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public com.haulmont.cuba.core.entity.Entity getImage() {
        return image;
    }

    public void setImage(com.haulmont.cuba.core.entity.Entity image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public StockStatus getStockStatus() {

        return stockStatus == null ? null : StockStatus.fromId(stockStatus);

    }

    public void setStockStatus(StockStatus stockStatus) {
        this.stockStatus = stockStatus == null ? null : stockStatus.getId();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}