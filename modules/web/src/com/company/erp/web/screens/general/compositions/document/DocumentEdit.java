package com.company.erp.web.screens.general.compositions.document;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.compositions.Document;

@UiController("erp_Document.edit")
@UiDescriptor("document-edit.xml")
@EditedEntityContainer("documentDc")
@LoadDataBeforeShow
public class DocumentEdit extends StandardEditor<Document> {
}