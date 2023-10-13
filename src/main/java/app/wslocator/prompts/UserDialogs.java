package app.wslocator.prompts;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.shared.Registration;

public class UserDialogs extends ConfirmDialog{

    private static ConfirmDialog confirmDialog;
    private static String title;
    private static String body;
    private static String description;
    private static Button confirmButton = new Button("APPROVE");

    public UserDialogs(String headerText, String bodyText, String descString) {
  
    }




}//end of class..
