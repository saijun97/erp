package com.company.erp.web.screens.general.widgets.TopBrandsInInventory;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_TopBrandsInInventoryFragment")
@UiDescriptor("top-brands-in-inventory-fragment.xml")
public class TopBrandsInInventoryFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader topBrandsInInventoryPieChartLoader;
    @Inject
    private PieChart topBrandsInInventoryPieChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            topBrandsInInventoryPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        topBrandsInInventoryPieChartLoader.load();

    }


}