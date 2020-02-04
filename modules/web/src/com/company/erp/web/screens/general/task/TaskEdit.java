package com.company.erp.web.screens.general.task;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.general.country.City;
import com.company.erp.entity.general.country.Country;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.general.task.Task;

import javax.inject.Inject;
import java.util.Date;

@UiController("erp_Task.edit")
@UiDescriptor("task-edit.xml")
@EditedEntityContainer("taskDc")
@LoadDataBeforeShow
public class TaskEdit extends StandardEditor<Task> {
    @Inject
    protected LookupField<Country> countryField;
    @Inject
    protected LookupField<City> cityField;
    @Inject
    protected LookupPickerField<Order> orderNumField;
    @Inject
    protected LookupPickerField<Client> clientField;
    @Inject
    protected DateField<Date> startDateField;
    @Inject
    protected CollectionContainer<Country> countriesDc;
    @Inject
    protected LookupField<String> statusField;
    @Inject
    private Notifications notifications;

    @Subscribe
    protected void onBeforeCommitChanges(BeforeCommitChangesEvent event) {

        if (getEditedEntity().getOrderNum() != null) {

            if (getEditedEntity().getClient() != getEditedEntity().getOrderNum().getClient()) {

                notifications.create()
                        .withCaption("Selected order number is not assigned to the same customer " +
                                "this task is currently assigned.\n Press X button next to order field and select again.")
                        .withType(Notifications.NotificationType.ERROR)
                        .show();
                event.preventCommit();
            }

        }
    }


    @Subscribe("orderNumField")
    protected void onOrderNumFieldValueChange(HasValue.ValueChangeEvent<Order> event) {

        clientField.setEditable(false);

        try {
            if (countryField.getValue() == null & cityField.getValue() == null) {

                clientField.setValue(orderNumField.getValue().getClient());
            }

        } catch (NullPointerException e) {

            System.out.println("Order number clear operation exception for client field handled!");
        }
    }

    @Subscribe(id = "clientsDc", target = Target.DATA_CONTAINER)
    protected void onClientsDcItemChange(InstanceContainer.ItemChangeEvent<Client> event) {

       try {
           if (countryField.getValue() == null & cityField.getValue() == null) {

               countryField.setValue(clientField.getValue().getCountry());
               cityField.setValue(clientField.getValue().getCity());

           }
       } catch (NullPointerException e) {
           System.out.println("Order number clear operation exception for country and city fields handled!");
       }

    }

    @Subscribe("clientField.clear")
    protected void onClientFieldClear(Action.ActionPerformedEvent event) {

        clientField.clear();
        countryField.clear();
        cityField.clear();
        orderNumField.setEditable(true);

    }

    @Subscribe("orderNumField.clear")
    protected void onOrderNumFieldClear(Action.ActionPerformedEvent event) {

        orderNumField.clear();
        clientField.clear();
        countryField.clear();
        cityField.clear();
        clientField.setEditable(true);

    }

}