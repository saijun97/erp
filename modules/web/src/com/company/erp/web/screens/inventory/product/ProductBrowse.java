package com.company.erp.web.screens.inventory.product;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.inventory.Product;

@UiController("erp_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}