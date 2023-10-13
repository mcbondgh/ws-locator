package app.wslocator.prompts;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

public class UserDialogs extends ConfirmDialog{

    private static String title;
    private static String body;
    private static String description;
    private static Button confirmButton = new Button("APPROVE");
    private static Button cancelButton = new Button("CANCEL");
    boolean isConfirmed = false;

    public UserDialogs(String headerText, String bodyText, String descString) {
        
        setCloseOnEsc(true);
        setCancelButton(cancelButton);
        setConfirmButton(confirmButton);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        confirmButton.addClassName("saveButton");
        confirmButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        setHeader(title);
        setText(body);
        open();
    }




}//end of class..
