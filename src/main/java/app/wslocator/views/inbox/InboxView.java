package app.wslocator.views.inbox;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Position;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datepicker.DatePickerVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.Column;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import app.wslocator.data.entity.InboxEntity;
import app.wslocator.dialogboxs.CustomDialogBoxes;
import app.wslocator.grids.InboxGrid;
import app.wslocator.prompts.UserNotifications;
import app.wslocator.views.includes.HeaderAndFooter;
import app.wslocator.views.layouts.MainLayout;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Inbox")
@Route(value = "/inbox", layout = MainLayout.class)
@DeclareRoles("ADMIN")
public class InboxView extends Composite<VerticalLayout> implements HeaderAndFooter{

    private Grid<InboxEntity> inboxTable = new Grid<>(InboxEntity.class);
    CustomDialogBoxes dialogBoxes;
    UserNotifications NOTIFY;

    private HorizontalLayout pageBodyLayout = new HorizontalLayout(); 
    private HorizontalLayout pageHeaderLayout;
    private H3 headerText = new H3();
    private Paragraph footerText = new Paragraph();
    private TextField emailField = new TextField("Sender's Email");
    private TextField titleField = new TextField("Message Title");
    private TextArea bodyField = new TextArea("Message Body");
    private DatePicker date = new DatePicker("Date Received");
    private Button replyButton =new Button("Reply Message");
    
    public InboxView() {
        addClassName("inbox-main-layout");
        replyButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        emailField.setRequired(true);
        replyButton.addClassName("save-button");
        getContent().add(pageHeaderLayout(), generatePageBody(), pageFooterLayout());
        getSelectedTableItem();
        replyMessageButtonClicked();

    }

    
    //IMPLEMENT HEADER
    @Override
    public HorizontalLayout pageHeaderLayout() {
        pageHeaderLayout = new HorizontalLayout();
        pageHeaderLayout.addClassName(Gap.MEDIUM);
        pageHeaderLayout.setWidthFull();
        pageHeaderLayout.addClassName(Padding.SMALL);
        headerText.setText("MESSAGES FROM VISITORS");
        headerText.setClassName("header-text", true);
        pageHeaderLayout.add(headerText);

        return pageHeaderLayout;
    }


    //CREATE A BODY CONTENT TO HOLD ALL PAGE CONENTS...
    private HorizontalLayout generatePageBody() {
        pageBodyLayout.addClassName("content-area");
        pageBodyLayout.setWidthFull();


        //GENERATE MESSAGES TABLE...
        Section mainPageSection = new Section();
        mainPageSection.addClassName("page-section");
        mainPageSection.setHeightFull();
        

        Div displayMessagesDiv = new Div();
        Div readMessageDiv = new Div();
        displayMessagesDiv.addClassName("messages-container");
        readMessageDiv.addClassName("read-messages-container");
        displayMessagesDiv.setWidthFull();
        readMessageDiv.setWidthFull();
        


        //MESSAGE CONTAINER CONETNT.
        H4 messageHeaderLabel = new H4("INBOX MESSAGES");
        H4 messageContentLabel = new H4("VIEW CONTENT");
        messageHeaderLabel.setClassName("header4");
        messageContentLabel.setClassName("header4");


        //ADD TEXT FIELDS TO THE READ-MESSAGE CONTAINER...
        // CREATE A FORM LAYOUT TO HOLD THE FORM...
        FormLayout formLayout = new FormLayout();
        formLayout.getStyle().setMargin("10px");
        formLayout.add(date, 0);
        formLayout.add(titleField, 1);
        formLayout.add(emailField, 1);
        formLayout.add(bodyField, 1);
        formLayout.add(replyButton, 1);
        bodyField.setHeight("150px");

        
        //LOAD TABLE WITH DATA...
        inboxTable.setItems(InboxGrid.populateGrid());
        inboxTable.addClassName("inbox-grid");
        inboxTable.setColumns("id", "title", "email", "body", "date");
        inboxTable.getColumns().forEach(items -> items.setResizable(true));


        //ADD COMPONENTS TO ITEM...
        displayMessagesDiv.add(messageHeaderLabel, new Hr(), inboxTable);
        readMessageDiv.add(messageContentLabel, new Hr(), formLayout);
        mainPageSection.add(displayMessagesDiv, readMessageDiv);
        pageBodyLayout.add(mainPageSection);
        return pageBodyLayout;
    }


    //IMPLEMNT FOOTER METHOD;
    @Override 
    public HorizontalLayout pageFooterLayout() { 
        pageHeaderLayout = new HorizontalLayout();
        pageHeaderLayout.addClassName(Gap.MEDIUM);
        footerText.setText("Powered By MCs Republic | 2023");
        footerText.setClassName("footer-text");
        footerText.getStyle().set("font-size", "var(--lumo-font-size-s)");
        pageHeaderLayout.add(footerText);


        return pageHeaderLayout;
    }


    /****************************************************************************************************************
     * ACTION EVENT METHODS IMPLEMENTATION
     ***************************************************************************************************************/
    private void getSelectedTableItem() {
        date.addThemeVariants(DatePickerVariant.LUMO_ALIGN_CENTER);
        date.setReadOnly(true);
        inboxTable.addItemClickListener(clicked -> {
          titleField.setValue(clicked.getItem().getTitle());
          bodyField.setValue(clicked.getItem().getBody());
          emailField.setValue(clicked.getItem().getEmail());
          date.setValue(clicked.getItem().getSendDate().toLocalDate());
        });
    }

    private void replyMessageButtonClicked() {
        
        TextField replyEmailField = new TextField("Customer Email");
        TextArea textArea = new TextArea("Message Area");
        textArea.setRequired(true);
        Button sendEmailBtn = new Button("Reply Message");
        sendEmailBtn.addClassName("save-button");
        
        replyEmailField.setReadOnly(true);
        textArea.setPlaceholder("Enter your message here...");
        textArea.setHeight("140px");

        H4 title = new H4("REPLY SELECTED CUSTOMER");
        title.addClassName("dialog-title");
        title.setWidthFull();
        

        FormLayout layout = new FormLayout();
        layout.addClassName("dialog-form-layout");
        
        layout.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("500px", 1)
    );
        layout.add(replyEmailField, textArea, sendEmailBtn);

        //show dialog box on button clicked...
        replyButton.addClickListener(click -> {
             String selectedCustomerMail = emailField.getValue();

            //Check if the email field is empty, if true display prompt else show dialog box...
            if(selectedCustomerMail.isBlank()) {
                NOTIFY = new UserNotifications("No selection made, please select a message to repy");
                NOTIFY.showError();
            }else {
                dialogBoxes = new CustomDialogBoxes(title.getText(), layout);
                replyEmailField.setValue(selectedCustomerMail);
                dialogBoxes.setWidth("500px");
                dialogBoxes.open();
            }
        });
    }
    
    
}//end of class
