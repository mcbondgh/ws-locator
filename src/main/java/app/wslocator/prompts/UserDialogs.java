package app.wslocator.prompts;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.notification.Notification;

public class UserDialogs {

    private static ConfirmDialog confirmDialog;
    private static String title;
    private static String body;
    private static String description;
    private static Button confirmButton = new Button("APPROVE");
    private static Button cancelButton = new Button("CANCEL");

    public UserDialogs(String headerText, String bodyText, String s) {
        title = headerText;
        body = bodyText;
    }

    public void showConfirmation() {
        confirmDialog = new ConfirmDialog();
        confirmDialog.setHeader(title);
        confirmDialog.setText(body);
        confirmDialog.setConfirmText(description);
        confirmDialog.setConfirmButton(confirmButton);
        confirmDialog.setCancelable(true);
        confirmDialog.addConfirmListener(click-> {
            Notification.show("You clicked the button");
        });
        confirmDialog.open();
    }



}//end of class..
