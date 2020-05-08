package com.company.erp.web.screens.general.widgets.TopProductCategoriesForServiceRequests;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_TopCategoriesForServiceRequestsFragment")
@UiDescriptor("top-categories-for-service-requests-fragment.xml")
public class TopCategoriesForServiceRequestsFragment extends ScreenFragment {
    @Inject
    protected KeyValueCollectionLoader topProductCategoriesForSRFLoader;
    @Inject
    private PieChart topProductCategoriesPieChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            topProductCategoriesPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        topProductCategoriesForSRFLoader.load();

    }
}