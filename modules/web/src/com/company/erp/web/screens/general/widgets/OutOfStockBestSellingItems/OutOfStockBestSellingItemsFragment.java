package com.company.erp.web.screens.general.widgets.OutOfStockBestSellingItems;

import com.company.erp.entity.sales_inventory.product.Product;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_OutOfStockBestSellingItemsFragment")
@UiDescriptor("out-of-stock-best-selling-items-fragment.xml")
public class OutOfStockBestSellingItemsFragment extends ScreenFragment {
    @Inject
    private CollectionLoader<Product> outOfStockBestSellingProductsLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    public void onBeforeShow(Screen.BeforeShowEvent event) {

        outOfStockBestSellingProductsLoader.load();
    }


}