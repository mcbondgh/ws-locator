package app.wslocator.views.suppliers;

import app.wslocator.data.entity.SuppliersEntity;
import app.wslocator.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.model.Navigation;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import jakarta.annotation.security.PermitAll;

@PageTitle("Suppliers")
@Route(value = "/suppiers", layout = MainLayout.class)
@PermitAll
@Uses(Icon.class)
public class SupplersView extends Composite<VerticalLayout> {

    private HorizontalLayout pageHeaderLayout = new HorizontalLayout();

    private H3 headerText = new H3();

    private VerticalLayout verticalLayout = new VerticalLayout();

    private VerticalLayout pageBodyLayout = new VerticalLayout();

    private HorizontalLayout pageFooterLayout = new HorizontalLayout();

    private Paragraph footerText = new Paragraph();


    //PRIVATE DIV CONTAINERS.
    private Div buttonContainer = new Div();
    private Div filterTextContainer = new Div();
    private Div tableContainer = new Div();

    //PRIVATE COMPONENTS
    private Button addNewSupplierButton = new Button("Add Supplier");
    private TextField filterTableField = new TextField();
    private Grid<SuppliersEntity> suppliersTable = new Grid<>(SuppliersEntity.class);
    private Button editSupplierButton = new Button("?");



    public SupplersView() {
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setFlexGrow(1.0, pageBodyLayout);
        getContent().add(generatePageHeader(), generatePageBodyContent(), generatePageFooter());
        pageFooterLayout.add(footerText);

        addSuppliersButtonClicked();
        //<theme-editor-local-classname>
        addClassName("supplers-view-vertical-layout-1");
    }


    //This method returns the Page Header Content...
    private Component generatePageHeader() {
        pageHeaderLayout.setWidthFull();
        pageHeaderLayout.addClassName(Gap.MEDIUM);
        pageHeaderLayout.setClassName("button-container");
        addNewSupplierButton.addClassName("add-supplier-button");

        headerText.setText("SUPPLIERS VIEW");
        headerText.setClassName("header-text");

        pageHeaderLayout.add(addNewSupplierButton);
        return pageHeaderLayout;
    }

    //This method returns Page Body Content.
    private Component generatePageBodyContent() {
        pageBodyLayout.setWidthFull();
        verticalLayout.addClassName("content-area");
        verticalLayout.setSizeFull();
        filterTableField.addClassName("filter-text-field");
        filterTableField.setPlaceholder("Filter by Supplier Name");

        filterTextContainer.add(filterTableField);
        verticalLayout.add(filterTextContainer, configureGrid());
        pageBodyLayout.add(verticalLayout);
        return pageBodyLayout;
    }

    //This method return the Page Footer...
    private Component generatePageFooter() {
        pageFooterLayout.setWidthFull();
        pageFooterLayout.addClassName(Gap.MEDIUM);
        footerText.setClassName("footer-text");
        footerText.setText("Powered By MCs Republic | 2023");
        footerText.getStyle().set("font-size", "var(--lumo-font-size-s)");
        return pageFooterLayout;
    }


    /*******************************************************************************************************************
     ***************************************** OTHER METHODS IMPLEMENTATION *************************************
     ******************************************************************************************************************/
    private Component configureGrid() {

        //suppliers grid implementation
        suppliersTable.setColumns("id", "businessName", "location", "hotLine", "supplier", "status", "description", "viewButton");
        suppliersTable.getColumns().get(0).setHeader("NO");
        suppliersTable.getColumns().get(1).setHeader("BUSINESS NAME");
        suppliersTable.getColumns().get(2).setHeader("LOCATION");
        suppliersTable.getColumns().get(3).setHeader("HOT LINE");
        suppliersTable.getColumns().get(4).setHeader("BUSINESS OWNER");
        suppliersTable.getColumns().get(5).setHeader("STATUS");
        suppliersTable.getColumns().get(6).setHeader("DESCRIPTION");
        suppliersTable.getColumns().get(7).setHeader("VIEW");
        suppliersTable.getColumns().forEach(item-> item.setAutoWidth(true).setFrozen(true));
        return suppliersTable;

    }




    /*******************************************************************************************************************
     ***************************************** ACTION EVENT METHODS IMPLEMENTATION *************************************
     ******************************************************************************************************************/

    void addSuppliersButtonClicked() {
        addNewSupplierButton.addClickListener(clickEvent -> {
            getUI().flatMap(ui -> ui.navigate(AddSupplier.class));
        });
    }

}// end of class...
