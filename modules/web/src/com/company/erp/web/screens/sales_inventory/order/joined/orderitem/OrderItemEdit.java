package com.company.erp.web.screens.sales_inventory.order.joined.orderitem;

import com.company.erp.entity.general.superclasses.Item;
import com.haulmont.cuba.gui.components.CurrencyField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("erp_OrderItem.edit")
@UiDescriptor("order-item-edit.xml")
@EditedEntityContainer("orderItemDc")
@LoadDataBeforeShow
public class OrderItemEdit extends StandardEditor<OrderItem> {
    @Inject
    private CurrencyField<BigDecimal> unitVatPriceField;
    @Inject
    private LookupField<Item> itemField;
    @Inject
    private CurrencyField<BigDecimal> amountField;
    @Inject
    private TextField<Integer> quantityField;

    @Subscribe("itemField")
    public void onItemFieldValueChange(HasValue.ValueChangeEvent<Item> event) {

        unitVatPriceField.setValue(itemField.getValue().getVatPrice());
        amountField.setValue(unitVatPriceField.getValue());
    }

    @Subscribe("quantityField")
    public void onQuantityFieldValueChange(HasValue.ValueChangeEvent<Integer> event) {

        BigDecimal amountValue;

        amountValue = unitVatPriceField.getValue().multiply(BigDecimal.valueOf(quantityField.getValue()));

        amountField.setValue(amountValue);

    }

    @Subscribe("unitVatPriceField")
    protected void onUnitVatPriceFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {

        if (itemField.getValue() != null) {

            BigDecimal amountValue;

            amountValue = unitVatPriceField.getValue().multiply(BigDecimal.valueOf(quantityField.getValue()));

            amountField.setValue(amountValue);

        }

    }
}