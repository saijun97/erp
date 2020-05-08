package com.company.erp.web.screens.general.widgets.BestSellingProducts;

import com.company.erp.entity.general.superclasses.Item;
import com.company.erp.entity.sales_inventory.product.Product;
import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.KeyValueCollectionContainer;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_BestSellingProductsFragment")
@UiDescriptor("best-selling-products-fragment.xml")
public class BestSellingProductsFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader bestSellingProductsPieChartLoader;

    @Inject
    protected UserSettingsTools userSettingsTools;
    @Inject
    private PieChart bestSellingProductsPieChart;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            bestSellingProductsPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        bestSellingProductsPieChartLoader.load();

    }

}