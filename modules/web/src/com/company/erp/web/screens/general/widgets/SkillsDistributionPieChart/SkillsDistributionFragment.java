package com.company.erp.web.screens.general.widgets.SkillsDistributionPieChart;

import com.haulmont.charts.gui.amcharts.model.ChartTheme;
import com.haulmont.charts.gui.components.charts.PieChart;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.UserSettingsTools;

import javax.inject.Inject;

@UiController("erp_SkillsDistributionFragment")
@UiDescriptor("skills-distribution-fragment.xml")
public class SkillsDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader SkillsDistributionPieChartLoader;
    @Inject
    private PieChart skillsDistributionPieChart;
    @Inject
    protected UserSettingsTools userSettingsTools;

    @Subscribe
    public void onInit(InitEvent event) {

        String userAppTheme = userSettingsTools.loadAppWindowTheme();

        if (userAppTheme.equals("hover-dark")) {

            skillsDistributionPieChart.setTheme(ChartTheme.DARK);

        }
    }

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        SkillsDistributionPieChartLoader.load();
    }


}