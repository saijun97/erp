package com.company.erp.web.screens.general.widgets.TopBrandsInInventory;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_TopBrandsInInventoryFragment")
@UiDescriptor("top-brands-in-inventory-fragment.xml")
public class TopBrandsInInventoryFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader topBrandsInInventoryPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        topBrandsInInventoryPieChartLoader.load();

    }


}