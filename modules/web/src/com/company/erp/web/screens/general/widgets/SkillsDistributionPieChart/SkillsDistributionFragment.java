package com.company.erp.web.screens.general.widgets.SkillsDistributionPieChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_SkillsDistributionFragment")
@UiDescriptor("skills-distribution-fragment.xml")
public class SkillsDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader SkillsDistributionPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        SkillsDistributionPieChartLoader.load();
    }


}