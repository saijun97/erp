package com.company.erp.web.screens.general.country;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.country.Country;

@UiController("erp_Country.edit")
@UiDescriptor("country-edit.xml")
@EditedEntityContainer("countryDc")
@LoadDataBeforeShow
public class CountryEdit extends StandardEditor<Country> {
}