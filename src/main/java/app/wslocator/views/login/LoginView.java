package app.wslocator.views.login;

import app.wslocator.security.AuthenticatedUser;
import app.wslocator.views.Homepage;
import app.wslocator.views.includes.HeaderAndFooter;
import app.wslocator.views.layouts.HeaderFooterLayouts;

import java.util.Collection;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.internal.RouteUtil;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@AnonymousAllowed
@PageTitle("Login")
@RouteAlias(value = "/login")
@Route(value = "/login")
public class LoginView extends LoginOverlay implements BeforeEnterObserver {

    private final AuthenticatedUser authenticatedUser;

    private Anchor anchorButton = new Anchor("/", "Return To Homepage");
            H5 linkText = new H5("Return To Homepage");

    public LoginView(AuthenticatedUser authenticatedUser) {
        anchorButtonClicked();
        this.authenticatedUser = authenticatedUser;
        setAction(RouteUtil.getRoutePath(VaadinService.getCurrent().getContext(), getClass()));

        LoginI18n loginForm = LoginI18n.createDefault();

        loginForm.setHeader(new LoginI18n.Header());
        loginForm.getHeader().setTitle("WS-LOCATOR");
        H6 header6 = new H6("Please Provide Your Credentials For Authentication Into The Portal");

        header6.getStyle().setTextAlign(Style.TextAlign.CENTER);
        loginForm.getHeader().setDescription(header6.getText());
        loginForm.setAdditionalInformation(linkText.getText());
        setI18n(loginForm);
        
        setForgotPasswordButtonVisible(false);
        setOpened(true);
        }


    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        if (authenticatedUser.get().isPresent()) {
            // Already logged in
            setOpened(false);
            event.forwardTo("/dashboard");
        }

        setError(event.getLocation().getQueryParameters().getParameters().containsKey("error"));
    }

    private void anchorButtonClicked() {
        linkText.addClickListener(click ->  {
            getUI().flatMap(e -> e.navigate(Homepage.class));
        });  
    }
}
