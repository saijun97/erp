package com.company.erp.web.screens.general.widgets.TopProductCategoriesInInventory;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_TopProductCategoriesInInventoryFragment")
@UiDescriptor("top-product-categories-in-inventory-fragment.xml")
public class TopProductCategoriesInInventoryFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader topProductCategoriesInInventoryLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        topProductCategoriesInInventoryLoader.load();
    }


}