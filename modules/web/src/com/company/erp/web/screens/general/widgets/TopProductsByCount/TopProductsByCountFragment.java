package com.company.erp.web.screens.general.widgets.TopProductsByCount;

import com.company.erp.entity.sales_inventory.product.Product;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_TopProductsByCountFragment")
@UiDescriptor("top-products-by-count-fragment.xml")
public class TopProductsByCountFragment extends ScreenFragment {


    @Inject
    private CollectionLoader<Product> topProductsByCountRadarChartLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        topProductsByCountRadarChartLoader.load();

    }

}