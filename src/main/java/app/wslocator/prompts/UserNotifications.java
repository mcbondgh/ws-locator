package app.wslocator.prompts;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.dom.Style;

import java.time.Duration;

public class UserNotifications extends Notification{

    Notification notification = new Notification();
    String message;
    Icon icon = new Icon(VaadinIcon.CLOSE);

    public UserNotifications(String message) {
        this.message = message;
        addClassName("notification-panel");
        notification.setDuration(3000);
        notification.setPosition(Position.TOP_END);
        notification.add(message);
    }

    public void showError() {
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.open();
    }
    public void showSuccess() {
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.open();
    }
    public void showWarning() {
        notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
        notification.open();
    }

    public void  show(){
        notification.open();
    }

}//end of class...

