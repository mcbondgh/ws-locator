package app.wslocator.views.settings;

import app.wslocator.prompts.UserDialogs;
import app.wslocator.views.MainLayout;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@PageTitle("Settings")
@AnonymousAllowed
@Route(value = "/settings", layout = MainLayout.class)
public class SettingsView extends VerticalLayout {

    private FormLayout formLayout = new FormLayout();
    UserDialogs CONFIRM;

    private TextField firstNameField = new TextField("First Name");
    private TextField lastNameField = new TextField("Last Name", "", (e) -> e.getValue());
    private TextField emailField = new TextField("Email Address");
    private TextField digitalAddressField = new TextField("Digital Address");
    private TextField numberField = new TextField("Mobile Number");
    private DatePicker employmentDatePicker = new DatePicker("Employment Date");
    private TextField usernameField = new TextField("Username");
    private PasswordField passwordField = new PasswordField("Password");
    private PasswordField confirmPasswordField = new PasswordField("Confirm Password");
    private ComboBox<String> userRolePicker = new ComboBox("User Role");
    private Button addButton = new Button("Add Employee");
    private Button clearButton = new Button("Clear");
    

    public SettingsView() {
        
        
    }

}//end of class...
