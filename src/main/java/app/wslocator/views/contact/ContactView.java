package app.wslocator.views.contact;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import app.wslocator.views.layouts.HeaderFooterLayouts;

@AnonymousAllowed
@Route(value = "/contact", layout = HeaderFooterLayouts.class)
@RouteAlias(value = "contact", layout = HeaderFooterLayouts.class)
@PageTitle("Contact Us")
public class ContactView extends VerticalLayout {

    public ContactView() {}
    
}
