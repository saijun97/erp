package com.company.erp.web.screens.crm.srf.servicerequest;

import com.company.erp.entity.crm.client.superclasses.Client;
import com.company.erp.entity.crm.srf.Equipment;
import com.company.erp.entity.general.enums.ServiceRequestStatusSelect;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.EmailInfoBuilder;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.reports.gui.actions.EditorPrintFormAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.erp.entity.crm.srf.ServiceRequest;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.*;

@UiController("erp_ServiceRequest.edit")
@UiDescriptor("service-request-edit.xml")
@EditedEntityContainer("serviceRequestDc")
@LoadDataBeforeShow
public class ServiceRequestEdit extends StandardEditor<ServiceRequest> {

    @Inject
    protected LookupField<ServiceRequestStatusSelect> statusField;
    @Inject
    protected DateField<Date> dateReceivedField;
    @Inject
    private TextArea<String> addressField;
    @Inject
    private LookupPickerField<Client> existingClientField;
    @Inject
    private TextField<String> mobilePhoneField;
    @Inject
    private TextField<String> homePhoneField;
    @Inject
    private TextField<String> customerNameField;
    @Inject
    protected EmailService emailService;
    @Inject
    protected Dialogs dialogs;
    @Inject
    private Button generateReportBtn;

    private boolean completed;
    @Inject
    private Table<Equipment> equipmentTable;

    @Subscribe
    public void onInit(InitEvent event) {
        generateReportBtn.setAction(
                new EditorPrintFormAction(this, null)
        );
    }

    @Subscribe
    protected void onInitEntity(InitEntityEvent<ServiceRequest> event) {

        event.getEntity().setStatus(ServiceRequestStatusSelect.PENDING);
        event.getEntity().setDateReceived(new Date());

    }

    @Subscribe("existingClientField")
    public void onExistingClientFieldValueChange(HasValue.ValueChangeEvent<Client> event) {

        if (existingClientField.getValue() == null) {

            customerNameField.clear();
            addressField.clear();
            homePhoneField.clear();
            mobilePhoneField.clear();

        }

        else try {

            customerNameField.setValue(existingClientField.getValue().getDisplayName());
            addressField.setValue(existingClientField.getValue().getBillingAddress());

        } catch (NullPointerException e) {

            System.out.println("Exception Handled.");
        }

        try {

            if (existingClientField.getValue().getPreferredContactPhone().startsWith("5")) {

                mobilePhoneField.setValue(existingClientField.getValue().getPreferredContactPhone());

            } else {

                homePhoneField.setValue(existingClientField.getValue().getPreferredContactPhone());

            }

        } catch (NullPointerException e) {

            System.out.println("Exception Handled.");
        }

    }

    @Subscribe(id = "equipmentDc", target = Target.DATA_CONTAINER)
    public void onEquipmentDcCollectionChange(CollectionContainer.CollectionChangeEvent<Equipment> event) {

        BigDecimal totalAmount = getAggregationResultFromTable(equipmentTable.getAggregationResults());
        getEditedEntity().setTotalPrice(totalAmount);

    }



    @Subscribe("statusField")
    public void onStatusFieldValueChange(HasValue.ValueChangeEvent<ServiceRequestStatusSelect> event) {

        completed = getEditedEntity().getStatus() == ServiceRequestStatusSelect.COMPLETED;
    }


    @Subscribe
    public void onAfterClose(AfterCloseEvent event) {
        if (completed) {
            dialogs.createOptionDialog()
                    .withCaption("SMS")
                    .withMessage("Inform client by sms?")
                    .withType(Dialogs.MessageType.CONFIRMATION)
                    .withActions(
                            new DialogAction(DialogAction.Type.YES) {
                                @Override
                                public void actionPerform(Component component) {

                                    sendByEmail();
                                }
                            },
                            new DialogAction(DialogAction.Type.NO)
                    )
                    .show();
        }
    }

    private void sendByEmail() {
        ServiceRequest serviceRequest = getEditedEntity();
        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses(serviceRequest.getMobilePhone() + "@emtelworld.net")
                .setCaption("Dear customer, Your equipment is ready to be collected. " +
                        "Total Amount due is Rs." + serviceRequest.getTotalPrice() +
                        ". Your reference number is " +
                        serviceRequest.getReferenceNumber() + "." +
                        "            " + "Regards, SRJ Tech Workshop Team")
                .setFrom("postmaster@srjdissert.ga")
                .setBody("Test")
                .setTemplatePath("com/company/erp/templates/srf_completed.txt")
                .setTemplateParameters(Collections.singletonMap("serviceRequest", serviceRequest))
                .build();
        emailService.sendEmailAsync(emailInfo);
    }

    private BigDecimal getAggregationResultFromTable(Map<Object, Object> aggregationResults) {
        BigDecimal amountValue = BigDecimal.ZERO;

        for (int i = 0; i< aggregationResults.size(); i++){
            Set<Object> set = aggregationResults.keySet();
            Iterator itr = set.iterator();
            Object string = itr.next();
            amountValue = (BigDecimal) aggregationResults.get(string);

        }
        return amountValue;
    }

}