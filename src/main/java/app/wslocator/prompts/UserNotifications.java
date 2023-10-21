package app.wslocator.prompts;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.dom.Style;

public class UserNotifications {
    private Notification notification = new Notification();
    private  String content;
    private Icon icon;

    public UserNotifications(String content) {
        this.content = content;
        icon.addClassName("notify-icon");
        notification.getStyle().setDisplay(Style.Display.FLEX);
        notification.getStyle().set("align-items", "center");
        notification.getStyle().set("justify-content", "space-between");
        notification.addClassName("notification-variable");
        notification.setText(content);
        notification.setDuration(3000);
        notification.setPosition(Position.TOP_END);
    }

    public void showError() {
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.add(content);
        icon.getStyle().setBackground("#ff0000").setColor("#fff");
        notification.add(icon = new Icon(VaadinIcon.CLOSE_SMALL));
        notification.open();
    }

    public void showSuccess() {
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        icon.getStyle().setBackground("#2BD100").setColor("#fff");
        notification.add(icon = new Icon(VaadinIcon.CHECK));
        notification.add(content);
        notification.open();
    }
    public void showWarning() {
        notification.addThemeVariants(NotificationVariant.LUMO_WARNING);
        icon.getStyle().setBackground("#FFEB2E").setColor("#00000");
        notification.add(icon = new Icon(VaadinIcon.WARNING));
        notification.add(content);
    }

}//end of class...

