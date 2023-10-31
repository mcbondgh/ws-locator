package app.wslocator.views.settings;

import app.wslocator.config.PasswordValidation;
import app.wslocator.data.entity.EmployeesEntity;
import app.wslocator.prompts.UserDialogs;
import app.wslocator.prompts.UserNotifications;
import app.wslocator.specialMehods.SpecialMethods;
import app.wslocator.views.includes.HeaderAndFooter;
import app.wslocator.views.layouts.MainLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.RouteAlias;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import oshi.driver.mac.net.NetStat.IFdata;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.JavaScript;
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
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

@JavaScript("frontend://scripts/customJs.js")
@PageTitle("Settings")
@RolesAllowed("ADMIN")
@Route(value = "/settings", layout = MainLayout.class)
@RouteAlias(value = "app_settings", layout = MainLayout.class)
public class SettingsView extends VerticalLayout implements HeaderAndFooter {

    UserNotifications NOTIFY;
    UserDialogs DIALOG;
    EmployeesEntity employeesEntity = new EmployeesEntity();

    // *******************************************************************************************************

    private FormLayout formLayout = new FormLayout();
    UserDialogs CONFIRM;

    HorizontalLayout pageHeaderLayout;
    private H4 headerText = new H4();
    private Paragraph footerText = new Paragraph();

    private TextField firstNameField = new TextField("First Name");
    private TextField lastNameField = new TextField("Last Name", "", (e) -> e.getValue());
    private EmailField emailField = new EmailField("Email Address");
    private TextField digitalAddressField = new TextField("Digital Address");
    private NumberField numberField = new NumberField("Mobile Number");
    private DatePicker employmentDatePicker = new DatePicker("Employment Date");
    private TextField usernameField = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private PasswordField confirmPasswordField = new PasswordField("Confirm Password");
    private final ComboBox<String> userRolePicker = new ComboBox<>("User Role");
    private final ComboBox<String> genderPicker = new ComboBox<>("Gender");
    Dialog addEmployeeFormDialog = new Dialog();
    private Button saveEmployee = new Button("Save Employee");
    private Button exitButton = new Button("X");
    private Button clearButton = new Button("Reset Fields");
    private Button addEmployeeButton = new Button("Add Employee");
    private Grid<EmployeesEntity> employeesTable = new Grid<>();

    /***********************************************************************************************************************
     * TRUE OR FALSE STATEMENTS.
     ***********************************************************************************************************************/

    public SettingsView() {
        add(
                buildAddEmployeeButton(),
                pageHeaderLayout(),
                pageBodyLayout(),
                pageFooterLayout());
        exitFormButtonClicked();
        setAddEmployeeButtonClicked();
        SpecialMethods.setGender(genderPicker);
        SpecialMethods.setUserRoles(userRolePicker);
        addEmployeesButtonClicked();
        resetButtonClicked();
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

    // page body
    @NotNull
    private HorizontalLayout pageBodyLayout() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.addClassName("content-area");
        layout.setSizeFull();

        employeesTable.addClassName("inbox-grid");
        employeesTable.addColumn(EmployeesEntity::getEmp_id).setHeader("ID");
        employeesTable.addColumn(EmployeesEntity::getFullName).setHeader("FULLNAME");
        employeesTable.addColumn(EmployeesEntity::getEmail).setHeader("EMAIL");
        employeesTable.addColumn(EmployeesEntity::getFormattedDate).setHeader("DATE JOINED");
        employeesTable.addColumn(EmployeesEntity::getMobile).setHeader("MOBILE NUMBER");
        employeesTable.addColumn(EmployeesEntity::getRole_name).setHeader("ROLE");
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
     * IMPLEMENTATION OF ACTION RELATED METHODS
     *****************************************************************************************************************************/

    private void setRequiredFields() {
        // SET REQUIRED FIELDS
        firstNameField.setInvalid(firstNameField.getValue().isBlank());
        firstNameField.setRequired(true);
        firstNameField.setErrorMessage("fill out space");
        lastNameField.setInvalid(lastNameField.getValue().isBlank());
        lastNameField.setRequired(true);
        numberField.setRequired(true);
        numberField.setInvalid(numberField.getValue().isBlank());
        emailField.setRequired(true);
        emailField.setInvalid(emailField.getValue().isBlank());
        emailField.setRequired(true);
        emailField.setErrorMessage("provide a valid email");
        genderPicker.setInvalid(genderPicker.getOptionalValue().isEmpty());
        genderPicker.setRequired(true);
        employmentDatePicker.setInvalid(employmentDatePicker.getOptionalValue().isEmpty());
        employmentDatePicker.setRequired(true);
        digitalAddressField.setInvalid(digitalAddressField.getValue().isBlank());
        digitalAddressField.setRequired(true);
        usernameField.setInvalid(usernameField.getValue().isBlank());
        usernameField.setRequired(true);
        passwordField.setInvalid(passwordField.getValue().isBlank());
        passwordField.setRequired(true);
        confirmPasswordField.setRequired(true);
        confirmPasswordField.setInvalid(confirmPasswordField.getValue().isBlank());
        userRolePicker.setRequired(true);
        userRolePicker.setInvalid(userRolePicker.getOptionalValue().isEmpty());
    }

    void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        genderPicker.clear();
        userRolePicker.clear();
        digitalAddressField.clear();
        employmentDatePicker.clear();
        usernameField.clear();
        passwordField.clear();
        confirmPasswordField.clear();
        numberField.clear();
    }

    boolean matchPasswords() {
        return passwordField.getValue().equals(confirmPasswordField.getValue());
    }

    /***********************************************************************************************************************
     ******************************************** ACTION EVENT METHODS IMPLEMENTATION ***************************************
     ************************************************************************************************************************/
    private void exitFormButtonClicked() {
        exitButton.addSingleClickListener(buttonClickEvent -> {
            addEmployeeFormDialog.close();
        });
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
                new FormLayout.ResponsiveStep("600px", 3));

        formLayout.add(
                firstNameField, lastNameField, numberField,
                emailField, genderPicker, digitalAddressField,
                employmentDatePicker, usernameField, passwordField,
                confirmPasswordField, userRolePicker);
        formLayout.setColspan(usernameField, 2);

        HorizontalLayout buttonsContainer = new HorizontalLayout();
        buttonsContainer.setJustifyContentMode(JustifyContentMode.END);
        buttonsContainer.add(saveEmployee, clearButton);
        saveEmployee.addClassName("save-button");
        clearButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        saveEmployee.addThemeVariants(ButtonVariant.LUMO_SMALL);

        addEmployeeFormDialog.add(dialogHeaderContaier, formLayout, buttonsContainer);

        addEmployeeButton.addClickListener(e -> {
            addEmployeeFormDialog.open();
        });
    }

    private void setAddEmployeeButtonClicked() {
        saveEmployee.addClickListener(buttonClickEvent -> {
            setRequiredFields();
            if (!(firstNameField.isInvalid() || lastNameField.isInvalid() || numberField.isInvalid()
                    || emailField.isInvalid() ||
                    digitalAddressField.isInvalid() || genderPicker.isInvalid() || employmentDatePicker.isInvalid()
                    || usernameField.isInvalid() ||
                    passwordField.isInvalid() || confirmPasswordField.isInvalid() || userRolePicker.isInvalid())) {
                if (!matchPasswords()) {
                    NOTIFY = new UserNotifications("Sorry your password fields do no match ❌");
                    NOTIFY.showWarning();
                    passwordField.setInvalid(true);
                    confirmPasswordField.setInvalid(true);
                } else {
                    String firstname = firstNameField.getValue();
                    String lastname = lastNameField.getValue();
                    String number = numberField.getValue();
                    String email = emailField.getValue();
                    String gender = genderPicker.getValue();
                    String digital = digitalAddressField.getValue();
                    LocalDate date = employmentDatePicker.getValue();
                    String username = usernameField.getValue();
                    String password = passwordField.getValue();
                    String userRole = userRolePicker.getValue();
                    String hashedPassword = PasswordValidation.hashPlainText(password);
                    DIALOG = new UserDialogs("SAVE EMPLOYEE",
                            "ARE YOU SURE YOU WANT TO ADD ["+firstname.concat(" " + lastname)+"] TO YOUR LIST OF EMPLOYEES? ");
                    UserDialogs.cancelButton.addClickListener(e -> {
                        DIALOG.close();
                    });
                    UserDialogs.confirmButton.addClickListener(e -> {
                        employeesEntity.setFirstname(firstname);
                        employeesEntity.setLastname(lastname);
                        employeesEntity.setMobile(number);
                        DIALOG.close();
                        
                    });
                }
            }
        });
    }

    private void resetButtonClicked() {
        clearButton.addClickListener((e) -> {
            firstNameField.clear();
            lastNameField.clear();
            emailField.clear();
            userRolePicker.clear();
            genderPicker.clear();
            numberField.clear();
            digitalAddressField.clear();
            employmentDatePicker.clear();
            usernameField.clear();
            passwordField.clear();
            confirmPasswordField.clear();

        });
    }

}// end of class...
