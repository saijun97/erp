package com.company.erp.web.screens.sales_inventory.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.product.Product;

@UiController("erp_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}