package com.company.erp.web.screens.general.task;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.task.Task;

@UiController("erp_Task.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTable")
@LoadDataBeforeShow
public class TaskBrowse extends StandardLookup<Task> {

}