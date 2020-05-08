package com.company.erp.web.screens.general.widgets.LanguageDistributionPieChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_LanguageDistributionFragment")
@UiDescriptor("language-distribution-fragment.xml")
public class LanguageDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader LanguageDistributionPieChartLoader;
    @Inject
    private PieChart languageDistributionPieChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            languageDistributionPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        LanguageDistributionPieChartLoader.load();
    }


}