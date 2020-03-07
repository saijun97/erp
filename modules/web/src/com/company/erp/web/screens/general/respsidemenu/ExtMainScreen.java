package com.company.erp.web.screens.general.respsidemenu;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.crm.srf.ServiceRequest;
import com.company.erp.entity.general.contact_person.ContactPerson;
import com.company.erp.entity.general.task.Task;
import com.company.erp.entity.hrm.employee.Employee;
import com.company.erp.entity.sales_inventory.order.Order;
import com.company.erp.entity.sales_inventory.order.joined.payment.Payment;
import com.company.erp.entity.sales_inventory.product.Product;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.app.main.MainScreen;

import javax.inject.Inject;



@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {

    @Inject
    private ScreenBuilders screenBuilders;

    @Subscribe("createTaskBtn")
    public void onCreateTaskBtnClick(Button.ClickEvent event) {

        screenBuilders.editor(Task.class, this)
                .newEntity()
                .build()
                .show();

    }

    @Subscribe("createServiceRequest")
    public void onCreateServiceRequestClick(Button.ClickEvent event) {

        screenBuilders.editor(ServiceRequest.class, this)
                .newEntity()
                .build()
                .show();

    }

    @Subscribe("createOrder")
    public void onCreateOrderClick(Button.ClickEvent event) {

        screenBuilders.editor(Order.class, this)
                .newEntity()
                .build()
                .show();

    }

    @Subscribe("createPayment")
    public void onCreatePaymentClick(Button.ClickEvent event) {

        screenBuilders.editor(Payment.class, this)
                .newEntity()
                .build()
                .show();

    }

    @Subscribe("viewEmployees")
    public void onViewEmployeesClick(Button.ClickEvent event) {

        screenBuilders.lookup(Employee.class, this)
                .build()
                .show();

    }

    @Subscribe("viewContactPersons")
    public void onViewContactPersonsClick(Button.ClickEvent event) {

        screenBuilders.lookup(ContactPerson.class, this)
                .build()
                .show();

    }

    @Subscribe("viewClients")
    public void onViewClientsClick(Button.ClickEvent event) {

        screenBuilders.lookup(Client.class, this)
                .build()
                .show();

    }

    @Subscribe("viewProducts")
    public void onViewProductsClick(Button.ClickEvent event) {

        screenBuilders.lookup(Product.class, this)
                .build()
                .show();

    }

}