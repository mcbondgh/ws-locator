package app.wslocator.prompts;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;

public class UserDialogs extends Dialog{

    private static String title;
    private static String body;
    public static Button confirmButton = new Button("APPROVE");
    public static Button cancelButton = new Button("CANCEL");
    private boolean buttonStatus = false;

    public UserDialogs(String headerText, String bodyText) {
        title = headerText;
        body = bodyText;

        setHeaderTitle(title);
    
        setCloseOnEsc(true);
        setCloseOnOutsideClick(false);
        setModal(true);
        getFooter().add(cancelButton, confirmButton);

        VerticalLayout layout = new VerticalLayout();
        layout.getStyle().setBackground("#f5f8fd");
        layout.setSizeFull();
        layout.getStyle().set("border-radius", "5px");
        layout.getStyle().setWidth("500px");
        layout.add(body);
        add(layout);

        confirmButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        cancelButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        confirmButton.addClassName("save-button");
        confirmButton.addClickShortcut(Key.ENTER);

        cancelButton.addClickListener(e -> {close();});
        
        open();
    }



}//end of class..
