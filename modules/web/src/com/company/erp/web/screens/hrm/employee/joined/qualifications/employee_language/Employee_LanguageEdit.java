package com.company.erp.web.screens.hrm.employee.joined.qualifications.employee_language;

import com.company.erp.entity.hrm.employee.joined.Employee_Language;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@UiController("erp_Employee_Language.edit")
@UiDescriptor("employee_language-edit.xml")
@EditedEntityContainer("employee_LanguageDc")
@LoadDataBeforeShow
public class Employee_LanguageEdit extends StandardEditor<Employee_Language> {

    @Inject
    protected InstanceContainer<Employee_Language> employee_LanguageDc;
    @Inject
    protected LookupField<String> fluencyField;
    @Inject
    protected LookupField<String> competencyField;

    @Subscribe
    protected void onInit(InitEvent event) {
        final List<String> fluencyList = new ArrayList<>(Arrays.asList("Writing", "Speaking", "Reading"));
        fluencyField.setOptionsList(fluencyList);

        fluencyField.setNewOptionHandler(caption -> {
            fluencyList.add(caption);
            fluencyField.setOptionsList(fluencyList);

        });

        final List<String> competencyList = new ArrayList<>(Arrays.asList("Poor", "Basic", "Good", "Mother Tongue"));
        competencyField.setOptionsList(competencyList);

        competencyField.setNewOptionHandler(caption -> {
            competencyList.add(caption);
            competencyField.setOptionsList(competencyList);

        });
    }

}