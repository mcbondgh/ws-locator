package app.wslocator.views.layouts;

import app.wslocator.data.entity.User;
import app.wslocator.security.AuthenticatedUser;
import app.wslocator.views.dashboard.DashboardView;
import app.wslocator.views.regions_districts.RegionsAndDistricts;
import app.wslocator.views.inbox.InboxView;
import app.wslocator.views.settings.SettingsView;
import app.wslocator.views.suppliers.SupplersView;
import app.wslocator.views.visitors.VisitorsView;

import com.flowingcode.vaadin.addons.fontawesome.FontAwesome;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;
import com.vaadin.flow.theme.lumo.LumoUtility;
import java.io.ByteArrayInputStream;
import java.util.Optional;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    private AuthenticatedUser authenticatedUser;
    private AccessAnnotationChecker accessChecker;

    public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
        this.authenticatedUser = authenticatedUser;
        this.accessChecker = accessChecker;

        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    // DRAWER CONTENT HERE...
    private void addDrawerContent() {
        H1 appName = new H1("WS-LOCATOR");
        Image appLogo = new Image("images/ws-locator-logo.png", appName.getText());
        appLogo.setClassName("application-logo");
        appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
        Header header = new Header(appLogo);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();
        nav.setClassName("side-menu");

        if (accessChecker.hasAccess(DashboardView.class)) {
            nav.addItem(new SideNavItem("Dashboard", DashboardView.class, FontAwesome.Solid.DASHBOARD.create()));
        }

        if (accessChecker.hasAccess(InboxView.class)) {
            nav.addItem(new SideNavItem("Inbox", InboxView.class, FontAwesome.Solid.INBOX.create()));
        }

        if (accessChecker.hasAccess(SupplersView.class)) {
            nav.addItem(new SideNavItem("Suppliers", SupplersView.class, FontAwesome.Solid.FILL_DRIP.create()));
        }

        if (accessChecker.hasAccess(VisitorsView.class)) {
            nav.addItem(new SideNavItem("Visitors", VisitorsView.class, FontAwesome.Solid.USERS_BETWEEN_LINES.create()));
        }
        if (accessChecker.hasAccess(RegionsAndDistricts.class)) {
            nav.addItem(new SideNavItem("Regions & Districts", RegionsAndDistricts.class, FontAwesome.Solid.MAP.create()));
        }

        if (accessChecker.hasAccess(SettingsView.class)) {
            nav.addItem(new SideNavItem("Settings", SettingsView.class, FontAwesome.Solid.GEAR.create()));
        }

        return nav;
    }

    //FOOTER CONTENT
    private Footer createFooter() {
        Footer layout = new Footer();
        layout.setClassName("footer");

        Optional<User> maybeUser = authenticatedUser.get();
        if (maybeUser.isPresent()) {
            User user = maybeUser.get();
        
            Avatar avatar = new Avatar(user.getName());
            avatar.getStyle().setBackground("white");
            StreamResource resource = new StreamResource("profile-pic",
                    () -> new ByteArrayInputStream(user.getProfilePicture()));
            avatar.setImageResource(resource);
            avatar.setThemeName("xsmall");
            avatar.getElement().setAttribute("tabindex", "-1");

            MenuBar userMenu = new MenuBar();
            userMenu.setThemeName("tertiary-inline contrast");

            MenuItem userName = userMenu.addItem("");
            userName.getStyle().setColor("#fff");
            Div div = new Div();
            div.add(avatar);
            div.add(user.getName());
            div.add(new Icon("lumo", "dropdown"));
            div.getElement().getStyle().set("display", "flex");
            div.getElement().getStyle().set("align-items", "center");
            div.getElement().getStyle().set("gap", "var(--lumo-space-s)");
            userName.add(div);
            userName.getSubMenu().addItem("Sign out", e -> {
                authenticatedUser.logout();
            });

            layout.add(userMenu);
        } else {
            Anchor loginLink = new Anchor("/homepage", "Sign in");
            layout.add(loginLink);
        }

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
