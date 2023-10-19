package app.wslocator.views.about;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import app.wslocator.views.layouts.HeaderFooterLayouts;

@AnonymousAllowed
@Route(value = "/about_us", layout = HeaderFooterLayouts.class)
@RouteAlias(value = "about_us", layout = HeaderFooterLayouts.class)
@PageTitle("About Us")
public class AboutView extends VerticalLayout{

    public AboutView() {}
    
}
