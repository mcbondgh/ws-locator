package app.wslocator.prompts;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;

public class UserNotifications {
    private Notification notification = new Notification();

    public UserNotifications(String content) {
        notification.setText(content);
        notification.setDuration(3000);
        notification.setPosition(Position.TOP_END);
        
    }


    public void showError() {
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.open();
    }

    public void showSuccess() {
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.open();
    }
}//end of class...

