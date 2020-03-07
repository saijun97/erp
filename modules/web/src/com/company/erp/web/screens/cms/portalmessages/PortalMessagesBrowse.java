package com.company.erp.web.screens.cms.portalmessages;

import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.cms.portal_messages.PortalMessages;

@UiController("erp_PortalMessages.browse")
@UiDescriptor("portal-messages-browse.xml")
@LookupComponent("portalMessagesesTable")
@LoadDataBeforeShow
public class PortalMessagesBrowse extends StandardLookup<PortalMessages> {
}