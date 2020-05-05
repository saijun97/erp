package com.company.erp.web.screens.general.task;

import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.task.Task;
import de.diedavids.cuba.userinbox.web.WithEntitySharingSupport;

import javax.inject.Inject;

@UiController("erp_Task.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTable")
@LoadDataBeforeShow
public class TaskBrowse extends StandardLookup<Task> implements WithEntitySharingSupport {

    @Inject
    private GroupTable<Task> tasksTable;
    @Inject
    private ButtonsPanel buttonsPanel;

    @Override
    public Table getListComponent() {
        return tasksTable;
    }

    @Override
    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }
}