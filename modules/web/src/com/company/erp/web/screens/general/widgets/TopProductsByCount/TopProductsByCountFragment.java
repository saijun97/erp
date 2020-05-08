package com.company.erp.web.screens.general.widgets.TopProductsByCount;

import com.company.erp.entity.sales_inventory.product.Product;
import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.RadarChart;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_TopProductsByCountFragment")
@UiDescriptor("top-products-by-count-fragment.xml")
public class TopProductsByCountFragment extends ScreenFragment {


    @Inject
    private CollectionLoader<Product> topProductsByCountRadarChartLoader;
    @Inject
    private RadarChart radarChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            radarChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        topProductsByCountRadarChartLoader.load();

    }

}