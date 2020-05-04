package com.company.erp.web.screens.hrm.qualifications.language;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.hrm.qualifications.language.Language;

@UiController("erp_Language.browse")
@UiDescriptor("language-browse.xml")
@LookupComponent("table")
@LoadDataBeforeShow
public class LanguageBrowse extends MasterDetailScreen<Language> {
}