package com.company.erp.web.screens.sales_inventory.order.joined.orderitem;

import com.company.erp.entity.general.superclasses.Item;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;

import org.jsoup.Jsoup;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Objects;

@UiController("erp_OrderItem.edit")
@UiDescriptor("order-item-edit.xml")
@EditedEntityContainer("orderItemDc")
@LoadDataBeforeShow
public class OrderItemEdit extends StandardEditor<OrderItem> {
    @Inject
    protected ResizableTextArea<String> descriptionField;
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

        if (itemField.getValue() == null) {

            itemField.setEditable(true);
        }

        if (itemField.getValue() != null) {

            itemField.setEditable(false);
        }

        try {

            if ((descriptionField.getValue() == null) && (Objects.equals(unitVatPriceField.getValue(), BigDecimal.ZERO)) && (Objects.equals(amountField.getValue(), BigDecimal.ZERO))) {

                unitVatPriceField.setValue(itemField.getValue().getVatPrice());
                amountField.setValue(unitVatPriceField.getValue());


                if (!(itemField.getValue().getDescription().isEmpty())) {

                    String parsedDescription = html2text(itemField.getValue().getDescription());
                    descriptionField.setValue(parsedDescription);

                }

            }

        }catch (NullPointerException e) {

            System.out.println("OrderItem edited item open screen exception handled!");
        }
    }

    @Subscribe("quantityField")
    public void onQuantityFieldValueChange(HasValue.ValueChangeEvent<Integer> event) {


            BigDecimal amountValue;

            amountValue = Objects.requireNonNull(unitVatPriceField.getValue()).multiply(BigDecimal.valueOf(quantityField.getValue()));

            amountField.setValue(amountValue);

    }

    @Subscribe("unitVatPriceField")
    protected void onUnitVatPriceFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {

        if (itemField.getValue() != null) {

            BigDecimal amountValue;

            amountValue = getEditedEntity().getUnitVatPrice().multiply(BigDecimal.valueOf(getEditedEntity().getQuantity()));

            amountField.setValue(amountValue);

        }

    }

    public static String html2text(String html) {

        return Jsoup.parse(html).text();
    }
}