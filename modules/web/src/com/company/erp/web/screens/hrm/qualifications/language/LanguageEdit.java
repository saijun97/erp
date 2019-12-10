package com.company.erp.web.screens.hrm.qualifications.language;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.language.Language;

@UiController("erp_Language.edit")
@UiDescriptor("language-edit.xml")
@EditedEntityContainer("languageDc")
@LoadDataBeforeShow
public class LanguageEdit extends StandardEditor<Language> {
}