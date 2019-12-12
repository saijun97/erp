package com.company.erp.web.screens.hrm.job_position;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.job_positions.Job_Position;

@UiController("erp_Job_Position.edit")
@UiDescriptor("job_position-edit.xml")
@EditedEntityContainer("job_PositionDc")
@LoadDataBeforeShow
public class Job_PositionEdit extends StandardEditor<Job_Position> {
}