package app.wslocator.views.layouts;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.charts.model.Navigation;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;

import app.wslocator.views.Homepage;
import app.wslocator.views.about.AboutView;
import app.wslocator.views.contact.ContactView;
import app.wslocator.views.login.LoginView;

public class HeaderFooterLayouts extends AppLayout{

    private Button aboutButton = new Button("About Us");
    private Button contactUsBtn = new Button("Contact Us");
    private Button loginButton = new Button("Login");
    private Div logoContainer = new Div();

    public HeaderFooterLayouts() {
        addToNavbar(true, createPageHeader());
        setClassName("homepage-container");
        setContent(createPageFooter());
        setPrimarySection(Section.NAVBAR);
        loginButtonClicked();
        aboutButtonClicked();
        contactUsButtonClicked();
        logoButtonClicked();
        //<theme-editor-local-classname>
        addClassName("contact-page");

    }

    //PAGE HEADER
    private Component createPageHeader() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.addClassName("homepage-header");
        layout.setAlignItems(Alignment.CENTER);


        //SET APPLICATION LOGO INTO THE HEADER..
        logoContainer.setClassName("logo-container");
        String imageSource = "/images/ws-locator-logo.png";
        Image appLogo = new Image(imageSource ,"WS-LOCATOR");
        appLogo.setClassName("homepageImage");
        logoContainer.add(appLogo);


        //CREATE A BUTTON CONTAINER 
        Div buttonsContainer = new Div();
        buttonsContainer.addClassName("homepage-buttons-container");
        buttonsContainer.add(loginButton, contactUsBtn, aboutButton);
        loginButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        contactUsBtn.addThemeVariants(ButtonVariant.LUMO_SMALL);
        aboutButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        
        loginButton.setId("login-button");
        contactUsBtn.setClassName("contactUs-button");
        aboutButton.setClassName("about-button");


        layout.add(logoContainer, buttonsContainer);
        return layout;
    }


    //PAGE FOOTER...
    private Component createPageFooter() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidthFull();
        layout.setClassName("homepage-footer", isAttached());


        return layout;
    }


    /*************************************************************************************************************************
     ********************* ACTION EVENT METHODS....
     ************************************************************************************************************************/
    
    private void loginButtonClicked() {
        loginButton.addClickListener(click -> {
            getUI().flatMap(nav -> nav.navigate(LoginView.class));
        });

    }
    private void contactUsButtonClicked() {
        contactUsBtn.addClickListener(click -> {
            getUI().flatMap(nav -> nav.navigate(ContactView.class));
        });
    }
    private void aboutButtonClicked() {
        aboutButton.addClickListener(click -> {
            getUI().flatMap(nav -> nav.navigate(AboutView.class));
        });
    }

    private void logoButtonClicked() {
        logoContainer.addClickListener(click -> {
            getUI().flatMap(nav -> nav.navigate(Homepage.class));
        });
    }

}//end of class...
