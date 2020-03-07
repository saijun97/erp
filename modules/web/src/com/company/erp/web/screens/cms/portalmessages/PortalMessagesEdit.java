package com.company.erp.web.screens.cms.portalmessages;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.cms.portal_messages.PortalMessage;

@UiController("erp_PortalMessages.edit")
@UiDescriptor("portal-messages-edit.xml")
@EditedEntityContainer("portalMessagesDc")
@LoadDataBeforeShow
public class PortalMessagesEdit extends StandardEditor<PortalMessage> {
}