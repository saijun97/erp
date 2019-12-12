package com.company.erp.web.screens.hrm.job_position;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.job_positions.Job_Position;

@UiController("erp_Job_Position.browse")
@UiDescriptor("job_position-browse.xml")
@LookupComponent("job_PositionsTable")
@LoadDataBeforeShow
public class Job_PositionBrowse extends StandardLookup<Job_Position> {
}