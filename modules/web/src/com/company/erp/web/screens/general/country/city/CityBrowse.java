package com.company.erp.web.screens.general.country.city;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.country.City;

@UiController("erp_City.browse")
@UiDescriptor("city-browse.xml")
@LookupComponent("citiesTable")
@LoadDataBeforeShow
public class CityBrowse extends StandardLookup<City> {
}