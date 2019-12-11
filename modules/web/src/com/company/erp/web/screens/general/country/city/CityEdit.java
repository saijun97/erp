package com.company.erp.web.screens.general.country.city;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.country.City;

@UiController("erp_City.edit")
@UiDescriptor("city-edit.xml")
@EditedEntityContainer("cityDc")
@LoadDataBeforeShow
public class CityEdit extends StandardEditor<City> {
}