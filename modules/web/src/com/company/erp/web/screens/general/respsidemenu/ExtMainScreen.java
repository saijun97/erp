package com.company.erp.web.screens.general.respsidemenu;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.crm.srf.ServiceRequest;
import com.company.erp.entity.general.contact_person.ContactPerson;
import com.company.erp.entity.general.task.Task;
import com.company.erp.entity.hrm.employee.Employee;
import com.company.erp.entity.sales_inventory.order.Order;
import com.company.erp.entity.sales_inventory.product.Product;
import com.haulmont.addon.dnd.components.DDVerticalLayout;
import com.haulmont.addon.dnd.components.DropHandler;
import com.haulmont.addon.dnd.components.acceptcriterion.AcceptCriterion;
import com.haulmont.addon.dnd.components.dragevent.DragAndDropEvent;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.Timer;
import com.haulmont.cuba.gui.components.mainwindow.SideMenu;
import com.haulmont.cuba.gui.screen.LoadDataBeforeShow;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.web.app.main.MainScreen;
import com.google.common.collect.Iterables;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.web.theme.HaloTheme;
import com.haulmont.addon.dnd.components.DDVerticalLayoutTargetDetails;
import com.haulmont.addon.dnd.components.LayoutBoundTransferable;
import com.haulmont.addon.dnd.components.enums.VerticalDropLocation;

import de.diedavids.cuba.userinbox.web.screens.UserInboxMessageMenuBadge;

import javax.inject.Inject;
import java.util.*;

@UiController("extMainScreen")
@UiDescriptor("ext-main-screen.xml")
@LoadDataBeforeShow
public class ExtMainScreen extends MainScreen {

    @Inject
    private ScreenBuilders screenBuilders;

    @Inject
    private UiComponents uiComponents;

    @Inject
    private DDVerticalLayout dashboard;

    @Inject
    private DDVerticalLayout palette;

    @Inject
    protected SideMenu sideMenu;

    @Inject
    protected Timer updateCountersTimer;

    @Inject
    protected UserInboxMessageMenuBadge userInboxMessageMenuBadge;


    @Subscribe
    public void onInit(InitEvent initEvent) {

        userInboxMessageMenuBadge.initMessagesMenuItem(
                sideMenu,
                updateCountersTimer,
                this
        );

        addCreateActions();

        dashboard.setDropHandler(new DropHandler() {
            @Override
            public void drop(DragAndDropEvent event) {
                LayoutBoundTransferable t = (LayoutBoundTransferable) event.getTransferable();
                DDVerticalLayoutTargetDetails details = (DDVerticalLayoutTargetDetails) event.getTargetDetails();

                Component sourceLayout = t.getSourceComponent();
                DDVerticalLayout targetLayout = (DDVerticalLayout) details.getTarget();
                Component tComponent = t.getTransferableComponent();

                VerticalDropLocation loc = details.getDropLocation();

                int indexTo = details.getOverIndex();
                int indexFrom = targetLayout.indexOf(tComponent);

                if (tComponent == null) {
                    return;
                }
                Component componentToAdd;

                if (sourceLayout == targetLayout) {
                    componentToAdd = tComponent;
                    if (indexFrom == indexTo) {
                        return;
                    }
                    targetLayout.remove(tComponent);
                    if (indexTo > indexFrom) {
                        indexTo--;
                    }
                    if (indexTo == -1) {
                        targetLayout.add(tComponent, indexFrom);
                    }
                } else {
                    componentToAdd = createDashboardElement(tComponent);
                    if (indexTo == -1) {
                        targetLayout.add(componentToAdd, targetLayout.getOwnComponents().size());
                    }
                }

                if (indexTo != -1) {
                    if (loc == VerticalDropLocation.MIDDLE || loc == VerticalDropLocation.BOTTOM) {
                        indexTo++;
                    }
                    targetLayout.add(componentToAdd, indexTo);
                }
                updateDashboardComponents(targetLayout);
            }

            @Override
            public AcceptCriterion getCriterion() {
                return AcceptCriterion.ACCEPT_ALL;
            }
        });
    }

    public Component createDashboardElement(Component component) {
        HBoxLayout layout = uiComponents.create(HBoxLayout.class);
        layout.setStyleName("dashboard-" + component.getId());
        layout.setWidth("100%");
        layout.setSpacing(true);

        Label countLabel = uiComponents.create(Label.class);
        countLabel.setStyleName("label-count");
        countLabel.setWidth("20px");

        Label titleLabel = uiComponents.create(Label.class);
        titleLabel.setValue(((Button) component).getCaption());
        titleLabel.setStyleName("bold");
        titleLabel.setWidth("60px");

        layout.add(countLabel);
        layout.add(titleLabel);

        Component field = createField(Objects.requireNonNull(component.getId()));
        layout.add(field);

        Button deleteButton = uiComponents.create(Button.class);
        deleteButton.addStyleName(HaloTheme.BUTTON_BORDERLESS_COLORED);
        deleteButton.addStyleName("button-remove");
        deleteButton.setIcon("font-icon:TIMES");
        BaseAction action = new BaseAction("remove") {
            @Override
            public void actionPerform(Component component) {
                ComponentContainer hBox = (ComponentContainer) component.getParent();
                DDVerticalLayout ddLayout = (DDVerticalLayout) hBox.getParent();
                ddLayout.remove(hBox);
                updateDashboardComponents(ddLayout);
            }
        };
        action.setCaption("");
        deleteButton.setAction(action);

        layout.add(deleteButton);
        layout.expand(field);

        return layout;
    }

    private Component createField(String id) {
        Component field;
        if (id.equals("meeting") || id.equals("other") || (id.equals("chat")) || (id.equals("call"))) {
            field = uiComponents.create(TextField.class);
        } else if (id.equals("buy")) {
            field = uiComponents.create(TextField.class);

            }
        else {
            field = uiComponents.create(TextField.class);
        }

        return field;
    }

    public void addCreateActions(){
        List<Component> buttonsList = new ArrayList<>(palette.getOwnComponents());
        for (Component component : buttonsList) {
            BaseAction createAction = new BaseAction("create") {
                @Override
                public void actionPerform(Component component) {
                    Component componentToAdd = createDashboardElement(component);
                    dashboard.add(componentToAdd);
                    updateDashboardComponents(dashboard);
                }
            };
            createAction.setCaption("");
            ((Button) component).setAction(createAction);
        }
    }

    public void updateDashboardComponents(DDVerticalLayout layout) {
        List<Component> components = new ArrayList<>(layout.getOwnComponents());
        int count = 0;
        for (Component component : components) {
            BoxLayout lineLayout = (BoxLayout) component;
            Label countLabel = (Label) Iterables.get(lineLayout.getComponents(), 0);
            countLabel.setValue(++count);
        }
    }

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

    @Subscribe
    public void onAfterInit(AfterInitEvent event) {
        userInboxMessageMenuBadge.updateMessageCounter(sideMenu);
    }

    @Subscribe("updateCountersTimer")
    protected void onUpdateCountersTimerTimerAction(Timer.TimerActionEvent event) {
        userInboxMessageMenuBadge.updateMessageCounter(sideMenu);
    }

}