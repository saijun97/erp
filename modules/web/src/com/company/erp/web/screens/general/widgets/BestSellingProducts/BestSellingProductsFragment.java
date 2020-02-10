package com.company.erp.web.screens.general.widgets.BestSellingProducts;

import com.company.erp.entity.general.superclasses.Item;
import com.company.erp.entity.sales_inventory.product.Product;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.KeyValueCollectionContainer;
import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_BestSellingProductsFragment")
@UiDescriptor("best-selling-products-fragment.xml")
public class BestSellingProductsFragment extends ScreenFragment {
    @Inject
    private KeyValueCollectionLoader bestSellingProductsPieChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        bestSellingProductsPieChartLoader.load();

    }

}