package com.company.erp.web.screens.sales_inventory.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.product.Product;

@UiController("erp_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}