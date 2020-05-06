package com.company.erp.web.screens.sales_inventory.product;

import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.CurrencyField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.product.Product;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Objects;

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

    public void calcVatPrice() {

        BigDecimal vatValue;

        if (applyVatField.isChecked()) {

            try {

                vatValue = (Objects.requireNonNull(priceField.getValue())).multiply(BigDecimal.valueOf(1.15));
                vatPriceField.setValue(vatValue);

            } catch (NullPointerException e) {

                System.out.println("Exception Handled.");
            }
        }

        else vatPriceField.setValue(priceField.getValue());
    }

    public void calcQtyTotal (){

        Integer qtyTotalValue = getEditedEntity().getQtyStore1() + getEditedEntity().getQtyStore2() + getEditedEntity().getQtyStore3();
        getEditedEntity().setQtyTotal(qtyTotalValue);

    }

    @Subscribe("priceField")
    public void onPriceFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {

        calcVatPrice();
    }

    @Subscribe("applyVatField")
    public void onApplyVatFieldValueChange(HasValue.ValueChangeEvent<Boolean> event) {

        calcVatPrice();

    }

    @Subscribe("qtyStore1Field")
    protected void onQtyStore1FieldValueChange(HasValue.ValueChangeEvent<Integer> event) {

        calcQtyTotal();

    }

    @Subscribe("qtyStore2Field")
    protected void onQtyStore2FieldValueChange(HasValue.ValueChangeEvent<Integer> event) {

        calcQtyTotal();

    }

    @Subscribe("qtyStore3Field")
    protected void onQtyStore3FieldValueChange(HasValue.ValueChangeEvent<Integer> event) {

        calcQtyTotal();

    }

}