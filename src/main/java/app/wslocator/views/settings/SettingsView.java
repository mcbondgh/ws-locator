package app.wslocator.views.settings;

import app.wslocator.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@PageTitle("Settings")
@AnonymousAllowed
@Route(value = "/settings", layout = MainLayout.class)
public class SettingsView extends VerticalLayout {

    public SettingsView() {

    }

}//end of class...
