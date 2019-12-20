package com.company.erp.web.screens.general.country.city;

import com.company.erp.entity.general.country.Country;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.country.City;

import javax.inject.Inject;

@UiController("erp_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {

}