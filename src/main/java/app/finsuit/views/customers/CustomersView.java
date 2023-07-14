package app.finsuit.views.customers;

import app.finsuit.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Customers")
@Route(value = "customers", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class CustomersView extends Composite<VerticalLayout> {

    private HorizontalLayout layoutRow = new HorizontalLayout();

    private H3 h3 = new H3();

    private VerticalLayout layoutColumn2 = new VerticalLayout();

    private HorizontalLayout layoutRow2 = new HorizontalLayout();

    private Paragraph textMedium = new Paragraph();

    public CustomersView() {
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow.setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        h3.setText("Customer List");
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidthFull();
        layoutRow2.setWidthFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        textMedium.setText("Application footer");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        getContent().add(layoutRow);
        layoutRow.add(h3);
        getContent().add(layoutColumn2);
        getContent().add(layoutRow2);
        layoutRow2.add(textMedium);
    }
}