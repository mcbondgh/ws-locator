package app.wslocator.views.contact;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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

    public ContactView() {
        addClassName("contact-page-view");
        add(
                heroDisplayArea(),
                pageContent()
        );
    }


    private Component heroDisplayArea() {
        VerticalLayout layout = new VerticalLayout();
        H1 heroText = new H1("Get In Touch With Us 😀");
        Text contentText = new Text("Want to know more about our operations or our agenda? We'd love to chat.");

        heroText.addClassName("hero-text");
        contentText.addClassName("content-text");
        layout.addClassName("header-layout-container");

        layout.add(heroText, contentText);
        return layout;
    }

    private Component pageContent() {
        HorizontalLayout layout = new HorizontalLayout();

        return layout;
    }

    
}
