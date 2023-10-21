package app.wslocator.views.settings;

import app.wslocator.data.entity.EmployeesEntity;
import app.wslocator.prompts.UserDialogs;
import app.wslocator.prompts.UserNotifications;
import app.wslocator.specialMehods.SpecialMethods;
import app.wslocator.views.includes.HeaderAndFooter;
import app.wslocator.views.layouts.MainLayout;
import com.vaadin.flow.router.RouteAlias;
import jakarta.annotation.security.RolesAllowed;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;


@PageTitle("Settings")
@RolesAllowed("ADMIN")
@Route(value = "/settings", layout = MainLayout.class)
@RouteAlias(value = "app_settings", layout = MainLayout.class)
public class SettingsView extends VerticalLayout implements HeaderAndFooter{

    UserNotifications NOTIFY;
    UserDialogs DIALOG;

    private FormLayout formLayout = new FormLayout();
    UserDialogs CONFIRM;

    HorizontalLayout pageHeaderLayout;
    private H4 headerText = new H4();
    private Paragraph footerText = new Paragraph();
    

    private TextField firstNameField = new TextField("First Name");
    private TextField lastNameField = new TextField("Last Name", "", (e) -> e.getValue());
    private TextField emailField = new TextField("Email Address");
    private TextField digitalAddressField = new TextField("Digital Address");
    private TextField numberField = new TextField("Mobile Number");
    private DatePicker employmentDatePicker = new DatePicker("Employment Date");
    private TextField usernameField = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private PasswordField confirmPasswordField = new PasswordField("Confirm Password");
    private final ComboBox<String> userRolePicker = new ComboBox<>("User Role");
    private final ComboBox<String> genderPicker = new ComboBox<>("Gender");
    Dialog addEmployeeFormDialog = new Dialog();
    private Button addButton = new Button("Add Employee");
    private Button exitButton = new Button("X");
    private Button clearButton = new Button("Clear");
    private Button addEmployeeButton = new Button("Add Employee");
    private Grid<EmployeesEntity> employeesTable = new Grid<>();

/***********************************************************************************************************************
            TRUE OR FALSE STATEMENTS.
 ***********************************************************************************************************************/
    boolean isFirstnameEmpty() {return firstNameField.getValue().isEmpty();}
    

    public SettingsView() {
        exitFormButtonClicked();
        setAddEmployeeButtonClicked();
        add(
            buildAddEmployeeButton(),
            pageHeaderLayout(), 
            pageBodyLayout(),
            pageFooterLayout()
       );
       SpecialMethods.setGender(genderPicker);
       SpecialMethods.setUserRoles(userRolePicker);
       addEmployeesButtonClicked();
       setRequiredFields();
    }


    @Override
    public HorizontalLayout pageHeaderLayout() {
        pageHeaderLayout = new HorizontalLayout();
        pageHeaderLayout.addClassName(Gap.MEDIUM);
        pageHeaderLayout.setWidthFull();
        pageHeaderLayout.addClassName(Padding.SMALL);
        headerText.setText("MANAGE EMPLOYEES");
        headerText.setClassName("header-text", true);
        pageHeaderLayout.add(headerText);

        return pageHeaderLayout;
    }
/*******************************************************************************************************************
     ***************************************** UI VIEWS IMPLEMENTATION *************************************
     ******************************************************************************************************************/
    private Component buildAddEmployeeButton() {
        HorizontalLayout layout = new HorizontalLayout();
        addEmployeeButton.addClassName("view-supplier-button");
        layout.addClassName("header-layout");
        layout.setWidthFull();
        layout.add(addEmployeeButton);
        return layout;
    }

    @RolesAllowed("USER")
    //page body
    private HorizontalLayout pageBodyLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addClassName("content-area");
        layout.setSizeFull();

        employeesTable.addClassName("inbox-grid");
        employeesTable.addColumn(EmployeesEntity::getId).setHeader("ID");
        employeesTable.addColumn(EmployeesEntity::getFullname).setHeader("FULLNAME");
        employeesTable.addColumn(EmployeesEntity::getEmail).setHeader("EMAIL");
        employeesTable.addColumn(EmployeesEntity::getFormattedDate).setHeader("DATE JOINED");
        employeesTable.addColumn(EmployeesEntity::getMobileNumber).setHeader("MOBILE NUMBER");
        employeesTable.addColumn(EmployeesEntity::getUserRole).setHeader("ROLE");
        employeesTable.getColumns().forEach(col -> col.setResizable(true));

        layout.add(employeesTable);
        return layout;
    }


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


    /******************************************************************************************************************************
     * IMPLEMENTATION OF ACTION EVENT METHODS
     *****************************************************************************************************************************/

    private void setRequiredFields() {
        //SET REQUIRED FIELDS
        firstNameField.setRequired(firstNameField.getValue().isEmpty());
        firstNameField.setRequiredIndicatorVisible(firstNameField.getValue().isBlank());
        lastNameField.setRequired(lastNameField.getValue().isBlank());
        lastNameField.setRequiredIndicatorVisible(lastNameField.getValue().isBlank());
        numberField.setRequiredIndicatorVisible(numberField.getValue().isBlank());
        numberField.setRequired(numberField.getValue().isBlank());
        emailField.setRequired(emailField.getValue().isBlank());
        emailField.setRequiredIndicatorVisible(emailField.getValue().isBlank());
        genderPicker.setRequired(genderPicker.getOptionalValue().isEmpty());
        genderPicker.setRequiredIndicatorVisible(genderPicker.getOptionalValue().isEmpty());
        digitalAddressField.setRequired(digitalAddressField.getValue().isBlank());
        digitalAddressField.setRequiredIndicatorVisible(digitalAddressField.getValue().isBlank());
        employmentDatePicker.setRequired(employmentDatePicker.getOptionalValue().isEmpty());
        employmentDatePicker.setRequiredIndicatorVisible(employmentDatePicker.getOptionalValue().isEmpty());
        usernameField.setRequired(usernameField.getValue().isBlank());
        passwordField.setRequired(passwordField.getValue().isBlank());
        passwordField.setRequiredIndicatorVisible(passwordField.getValue().isBlank());
        confirmPasswordField.setRequiredIndicatorVisible(confirmPasswordField.getValue().isBlank());
        userRolePicker.setRequiredIndicatorVisible(userRolePicker.getOptionalValue().isEmpty());
    }

    private void addEmployeesButtonClicked() {
        addEmployeeFormDialog.setModal(true);
        addEmployeeFormDialog.setDraggable(true);
        addEmployeeFormDialog.setCloseOnEsc(true);

        addEmployeeFormDialog.setClassName("employees-dialog-box");
        formLayout.setClassName("settings-form-layout");

        HorizontalLayout dialogHeaderContaier = new HorizontalLayout();
        dialogHeaderContaier.setClassName("dialog-header-container");
        H4 headerText = new H4("ADD NEW EMPLOYEE TO LIST");
        dialogHeaderContaier.setWidthFull();

        exitButton.addThemeVariants(ButtonVariant.LUMO_SMALL);

        exitButton.setClassName("exit-button");
        dialogHeaderContaier.add(headerText, exitButton);

        formLayout.setResponsiveSteps(
            new FormLayout.ResponsiveStep("0", 1),
            new FormLayout.ResponsiveStep("600px",3)
        );

        formLayout.add(
            firstNameField, lastNameField,numberField,
            emailField, genderPicker,digitalAddressField,
            employmentDatePicker, usernameField, passwordField, 
            confirmPasswordField, userRolePicker
        );
        formLayout.setColspan(usernameField, 2);
        
        HorizontalLayout buttonsContainer = new HorizontalLayout();
        buttonsContainer.setJustifyContentMode(JustifyContentMode.END);
        buttonsContainer.add(addButton, clearButton);
        addButton.addClassName("save-button");
        clearButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        addButton.addThemeVariants(ButtonVariant.LUMO_SMALL);


        addEmployeeFormDialog.add(dialogHeaderContaier, formLayout, buttonsContainer);

        addEmployeeButton.addClickListener(e -> {
            addEmployeeFormDialog.open();
        });
    }

/***********************************************************************************************************************
******************************************** ACTION EVENT METHODS IMPLEMENTATION ***************************************
************************************************************************************************************************/
private void exitFormButtonClicked() {
    exitButton.addSingleClickListener(buttonClickEvent -> {
       addEmployeeFormDialog.close();
    });
}

private void setAddEmployeeButtonClicked() {
        addButton.addClickListener(buttonClickEvent -> {
            NOTIFY = new UserNotifications("You have empty fields please fill out all required fields.");
            if (isFirstnameEmpty()){
                NOTIFY.showError();
            }
        });


}



}//end of class...
