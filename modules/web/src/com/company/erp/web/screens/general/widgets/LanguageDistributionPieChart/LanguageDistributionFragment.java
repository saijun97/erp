package com.company.erp.web.screens.general.widgets.LanguageDistributionPieChart;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_LanguageDistributionFragment")
@UiDescriptor("language-distribution-fragment.xml")
public class LanguageDistributionFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader LanguageDistributionPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        LanguageDistributionPieChartLoader.load();
    }


}