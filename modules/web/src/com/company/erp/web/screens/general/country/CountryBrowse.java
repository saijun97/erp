package com.company.erp.web.screens.general.country;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.country.Country;

@UiController("erp_Country.browse")
@UiDescriptor("country-browse.xml")
@LookupComponent("countriesTable")
@LoadDataBeforeShow
public class CountryBrowse extends StandardLookup<Country> {
}