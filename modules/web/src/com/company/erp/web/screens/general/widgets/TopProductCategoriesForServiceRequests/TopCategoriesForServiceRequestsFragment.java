package com.company.erp.web.screens.general.widgets.TopProductCategoriesForServiceRequests;

import com.haulmont.cuba.gui.model.KeyValueCollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("erp_TopCategoriesForServiceRequestsFragment")
@UiDescriptor("top-categories-for-service-requests-fragment.xml")
public class TopCategoriesForServiceRequestsFragment extends ScreenFragment {
    @Inject
    protected KeyValueCollectionLoader topProductCategoriesForSRFLoader;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        topProductCategoriesForSRFLoader.load();

    }
}