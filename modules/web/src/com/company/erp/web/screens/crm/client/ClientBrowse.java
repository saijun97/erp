package com.company.erp.web.screens.crm.client;

import com.company.erp.entity.crm.client.subclasses.company.ClientCompany;
import com.company.erp.entity.crm.client.subclasses.person.ClientPerson;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.client.superclasses.Client;

import javax.inject.Inject;

@UiController("erp_Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
@LoadDataBeforeShow
public class ClientBrowse extends StandardLookup<Client> {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private GroupTable<Client> clientsTable;

    @Inject
    private Metadata metadata;

    @Subscribe("createBtn.createCompany")
    protected void onCreateBtnCreateClientCompany(Action.ActionPerformedEvent event) {
        ClientCompany clientCompany = metadata.create(ClientCompany.class);
        showCreateEditorForClient(clientCompany);
    }

    @Subscribe("createBtn.createPerson")
    protected void onCreateBtnCreateClientPerson(Action.ActionPerformedEvent event) {
        ClientPerson clientPerson = metadata.create(ClientPerson.class);
        showCreateEditorForClient(clientPerson);
    }

    private void showCreateEditorForClient(Client client) {
        screenBuilders.editor(clientsTable)
                .editEntity(client)
                .build()
                .show();
    }


}