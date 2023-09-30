package app.wslocator.views.regions_districts;

import app.wslocator.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Regions | Districts")
@Route(value = "/regions_districts", layout = MainLayout.class)
@AnonymousAllowed
public class RegionsAndDistricts extends VerticalLayout {
    public RegionsAndDistricts() {
    }


}//end of class...
