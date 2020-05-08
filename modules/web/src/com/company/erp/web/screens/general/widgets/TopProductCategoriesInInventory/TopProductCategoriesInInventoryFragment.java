package com.company.erp.web.screens.general.widgets.TopProductCategoriesInInventory;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_TopProductCategoriesInInventoryFragment")
@UiDescriptor("top-product-categories-in-inventory-fragment.xml")
public class TopProductCategoriesInInventoryFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader topProductCategoriesInInventoryLoader;
    @Inject
    private PieChart topProductCategoriesInInventoryPieChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            topProductCategoriesInInventoryPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        topProductCategoriesInInventoryLoader.load();
    }


}