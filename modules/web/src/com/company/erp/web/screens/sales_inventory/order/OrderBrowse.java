package com.company.erp.web.screens.sales_inventory.order;

import com.company.erp.entity.sales_inventory.order.joined.order_item.OrderItem;
import com.company.erp.service.DataGridDetailsGeneratorService;
import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.sales_inventory.order.Order;
import com.haulmont.cuba.gui.screen.LookupComponent;
import de.diedavids.cuba.attachable.web.WithAttachmentsSupport;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.List;

@UiController("erp_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> implements WithAttachmentsSupport {
    @Inject
    protected DataGrid<Order> ordersTable;
    @Inject
    private UiComponents uiComponents;
    @Inject
    protected DataGridDetailsGeneratorService service;
    @Inject
    private MetadataTools metadataTools;
    @Inject
    private ButtonsPanel buttonsPanel;

    @Subscribe
    protected void onInit(InitEvent event) {
        ordersTable.setItemClickAction(new BaseAction("itemClickAction")
                .withHandler(actionPerformedEvent ->
                        ordersTable.setDetailsVisible(ordersTable.getSingleSelected(), true)));
    }

    @Install(to = "ordersTable", subject = "detailsGenerator")
    protected Component ordersDataGridDetailsGenerator(Order order) {
        VBoxLayout mainLayout = uiComponents.create(VBoxLayout.NAME);
        mainLayout.setWidth("100%");
        mainLayout.setMargin(true);

        HBoxLayout headerBox = uiComponents.create(HBoxLayout.NAME);
        headerBox.setWidth("100%");

        Label<String> infoLabel = uiComponents.create(Label.NAME);
        infoLabel.setHtmlEnabled(true);
        infoLabel.setStyleName("h1");
        infoLabel.setValue("Order info:");

        Component closeButton = createCloseButton(order);
        headerBox.add(infoLabel);
        headerBox.add(closeButton);
        headerBox.expand(infoLabel);

        Component content = getContent(order);

        mainLayout.add(headerBox);
        mainLayout.add(content);
        mainLayout.expand(content);

        return mainLayout;
    }

    private Component createCloseButton(Order entity) {
        Button closeButton = uiComponents.create(Button.class);
        closeButton.setIcon("icons/close.png");
        BaseAction closeAction = new BaseAction("closeAction")
                .withHandler(actionPerformedEvent ->
                        ordersTable.setDetailsVisible(entity, false))
                .withCaption("");
        closeButton.setAction(closeAction);
        return closeButton;
    }

    private Component getContent(Order entity) {
        Label<String> content = uiComponents.create(Label.TYPE_STRING);
        content.setHtmlEnabled(true);

        StringBuilder sb = new StringBuilder();
        sb.append("<table cellspacing=3px cellpadding=3px>")
                .append("<tr>")
                .append("<th>Item</th>")
                .append("<th>Quantity</th>")
                .append("<th>Unit Vat Price</th>")
                .append("<th>Total</th>")
                .append("</tr>");

        List<OrderItem> orderItems = service.loadOrderItemsById(entity.getId());
        for (OrderItem item : orderItems) {
            sb.append("<tr>");
            sb.append("<td>").append(metadataTools.getInstanceName(item.getItem())).append("</td>");
            sb.append("<td>").append(item.getQuantity()).append("</td>");
            sb.append("<td>").append(item.getUnitVatPrice()).append("</td>");

            BigDecimal total = item.getAmount();
            sb.append("<td>").append(total).append("</td>");
            sb.append("</tr>");
        }

        sb.append("<tr>")
                .append("<th>Total:</th>")
                .append("<th></th>").append("<th></th>")
                .append("<th>").append(entity.getTotalAmount()).append("</th>")
                .append("</tr>")
                .append("</table>");

        content.setValue(sb.toString());

        return content;
    }

    @Override
    public ListComponent getListComponentForAttachments() {
        return ordersTable;
    }

    @Override
    public ButtonsPanel getButtonsPanelForAttachments() {
        return buttonsPanel;
    }

    @Override
    public WindowManager.OpenType attachmentListOpenType() {
        return WindowManager.OpenType.NEW_TAB;
    }

}