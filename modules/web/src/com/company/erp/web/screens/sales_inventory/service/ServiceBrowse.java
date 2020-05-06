package com.company.erp.web.screens.sales_inventory.service;

import com.haulmont.cuba.gui.components.CheckBox;
import com.haulmont.cuba.gui.components.CurrencyField;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.service.Service;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Objects;

@UiController("erp_Service.browse")
@UiDescriptor("service-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class ServiceBrowse extends MasterDetailScreen<Service> {
    @Inject
    private CheckBox applyVatField;
    @Inject
    private CurrencyField<BigDecimal> priceField;
    @Inject
    private CurrencyField<BigDecimal> vatPriceField;

    @Subscribe("priceField")
    public void onPriceFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {

        calcVatPrice();
    }

    @Subscribe("applyVatField")
    public void onApplyVatFieldValueChange(HasValue.ValueChangeEvent<Boolean> event) {

        calcVatPrice();

    }

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
}