package app.finsuit.views.deposits;

import app.finsuit.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Deposits")
@Route(value = "deposit", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class DepositsView extends Composite<VerticalLayout> {

    private HorizontalLayout layoutRow = new HorizontalLayout();

    private H3 h3 = new H3();

    private VerticalLayout layoutColumn2 = new VerticalLayout();

    private TabSheet tabSheet = new TabSheet();

    private HorizontalLayout layoutRow2 = new HorizontalLayout();

    private Paragraph textMedium = new Paragraph();

    public DepositsView() {
        getContent().setHeightFull();
        getContent().setWidthFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.addClassName(Padding.SMALL);
        layoutRow.setWidthFull();
        h3.setText("Deposits");
        getContent().setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, tabSheet);
        tabSheet.setWidthFull();
        setTabSheetSampleData(tabSheet);
        layoutRow2.setWidthFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        textMedium.setText("Application footer");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        getContent().add(layoutRow);
        layoutRow.add(h3);
        getContent().add(layoutColumn2);
        layoutColumn2.add(tabSheet);
        getContent().add(layoutRow2);
        layoutRow2.add(textMedium);
    }

    private void setTabSheetSampleData(TabSheet tabSheet) {
        tabSheet.add("Dashboard", new Div(new Text("This is the Dashboard tab content")));
        tabSheet.add("Payment", new Div(new Text("This is the Payment tab content")));
        tabSheet.add("Shipping", new Div(new Text("This is the Shipping tab content")));
    }
}
