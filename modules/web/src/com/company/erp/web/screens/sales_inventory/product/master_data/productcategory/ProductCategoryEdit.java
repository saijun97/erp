package com.company.erp.web.screens.sales_inventory.product.master_data.productcategory;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.product.master_data.product_category.ProductCategory;

@UiController("erp_ProductCategory.edit")
@UiDescriptor("product-category-edit.xml")
@EditedEntityContainer("productCategoryDc")
@LoadDataBeforeShow
public class ProductCategoryEdit extends StandardEditor<ProductCategory> {
}