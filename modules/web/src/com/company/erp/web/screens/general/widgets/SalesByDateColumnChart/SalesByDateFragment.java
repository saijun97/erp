package com.company.erp.web.screens.general.widgets.SalesByDateColumnChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_SalesByDateFragment")
@UiDescriptor("sales-by-date-fragment.xml")
public class SalesByDateFragment extends ScreenFragment {

    @Inject
    protected KeyValueCollectionLoader salesByDateColumnChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        salesByDateColumnChartLoader.load();

    }


}