package com.company.erp.web.screens.sales_inventory.product;

import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.CurrencyField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.product.Product;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("erp_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
    @Inject
    private CurrencyField<BigDecimal> priceField;
    @Inject
    private CheckBox applyVatField;
    @Inject
    private CurrencyField<BigDecimal> vatPriceField;

    @Subscribe("priceField")
    public void onPriceFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {

        vatPriceField.setValue(priceField.getValue());

    }

    @Subscribe("applyVatField")
    public void onApplyVatFieldValueChange(HasValue.ValueChangeEvent<Boolean> event) {

        BigDecimal vatValue;

        if (applyVatField.getValue()) {

            vatValue = priceField.getValue().multiply(BigDecimal.valueOf(1.15));
            vatPriceField.setValue(vatValue);
        }

        else vatPriceField.setValue(priceField.getValue());


    }


}