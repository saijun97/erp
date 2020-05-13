package com.company.erp.web.screens.cms.catalogproduct;

import com.company.erp.entity.sales_inventory.product.Product;
import com.company.erp.entity.sales_inventory.product.master_data.make_manufacturer.Make_Manufacturer;
import com.company.erp.entity.sales_inventory.product.master_data.product_category.ProductCategory;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.cms.catalog_product.CatalogProduct;

import javax.inject.Inject;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Objects;

@UiController("erp_CatalogProduct.edit")
@UiDescriptor("catalog-product-edit.xml")
@EditedEntityContainer("catalogProductDc")
@LoadDataBeforeShow
public class CatalogProductEdit extends StandardEditor<CatalogProduct> {
    @Inject
    private LookupPickerField<Product> productField;
    @Inject
    private TextField<String> nameField;
    @Inject
    private LookupField<Make_Manufacturer> brandField;
    @Inject
    private LookupField<ProductCategory> categoryField;
    @Inject
    private CurrencyField<BigDecimal> priceField;
    @Inject
    private RichTextArea descriptionField;

    @Subscribe("productField")
    public void onProductFieldValueChange(HasValue.ValueChangeEvent<Product> event) {

        productField.setEditable(false);

        nameField.setValue(Objects.requireNonNull(productField.getValue()).getItem());

        brandField.setValue(productField.getValue().getMake_manufacturer());

        categoryField.setValue(productField.getValue().getProductCategory());

        priceField.setValue(productField.getValue().getVatPrice());

        try {

            if (descriptionField.getValue() == null) {

                descriptionField.setValue(getEditedEntity().getProduct().getDescription());

            }

        } catch (NullPointerException e) {

            System.out.println("Description null Exception Handled.");
        }


    }

}