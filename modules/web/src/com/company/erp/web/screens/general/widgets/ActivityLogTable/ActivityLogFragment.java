package com.company.erp.web.screens.general.widgets.ActivityLogTable;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.entity.EntityLogItem;

import javax.inject.Inject;

@UiController("erp_ActivityLogFragment")
@UiDescriptor("activity-log-fragment.xml")
public class ActivityLogFragment extends ScreenFragment {
    @Inject
    protected CollectionLoader<EntityLogItem> logDl;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    protected void onBeforeShow(Screen.BeforeShowEvent event) {

        logDl.load();

    }


}