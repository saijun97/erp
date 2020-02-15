package com.company.erp.web.screens.hrm.employee;

import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.ListComponent;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.employee.Employee;
import de.diedavids.cuba.attachable.web.WithAttachmentsSupport;

import javax.inject.Inject;

@UiController("erp_Employee.browse")
@UiDescriptor("employee-browse.xml")
@LookupComponent("employeesTable")
@LoadDataBeforeShow
public class EmployeeBrowse extends StandardLookup<Employee> implements WithAttachmentsSupport {
    @Inject
    private GroupTable<Employee> employeesTable;
    @Inject
    private ButtonsPanel buttonsPanel;

    @Override
    public ListComponent getListComponentForAttachments() {
        return employeesTable;
    }

    @Override
    public ButtonsPanel getButtonsPanelForAttachments() {
        return buttonsPanel;
    }

    @Override
    public WindowManager.OpenType attachmentListOpenType() {
        return WindowManager.OpenType.DIALOG;
    }
}