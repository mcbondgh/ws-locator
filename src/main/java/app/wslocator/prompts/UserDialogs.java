package app.wslocator.prompts;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

public class UserDialogs extends Dialog{

    private static String title;
    private static String body;
    private static Button confirmButton = new Button("APPROVE");
    private static Button cancelButton = new Button("CANCEL");
    private boolean buttonStatus = false;

    public UserDialogs(String headerText, String bodyText) {
        title = headerText;
        body = bodyText;

        setHeaderTitle(title);
    
        setCloseOnEsc(true);
        setCloseOnOutsideClick(false);
        setModal(true);
        getFooter().add(cancelButton, confirmButton);
        add(body);

        confirmButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        confirmButton.addClassName("save-button");
        confirmButton.addClickShortcut(Key.ENTER);
        open();
        
        cancelButton.addClickListener(e -> {
            buttonStatus = false;
            close();
        });
        confirmButton.addClickListener(e -> {
            buttonStatus = true;
            close();
        });
    }

    public boolean isConfirmed() {
        return buttonStatus;
    }






}//end of class..
