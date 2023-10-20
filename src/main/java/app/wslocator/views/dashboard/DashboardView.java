package app.wslocator.views.dashboard;

import app.wslocator.data.entity.SuppliersEntity;
import app.wslocator.views.includes.HeaderAndFooter;
import app.wslocator.views.layouts.MainLayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import com.vaadin.flow.component.formlayout.*;

import java.util.List;


@PageTitle("Dashboard")
@Route(value = "/dashboard", layout = MainLayout.class)
@RouteAlias(value = "/dashboard", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class DashboardView extends Composite<VerticalLayout> implements HeaderAndFooter{

    private HorizontalLayout pageHeaderLayout = new HorizontalLayout();

    private H3 h3 = new H3();

    private VerticalLayout verticalLayout = new VerticalLayout();

    private HorizontalLayout pageBodyLayout = new HorizontalLayout();

    private HorizontalLayout pageFooterLayout = new HorizontalLayout();

    private Paragraph footerText = new Paragraph();
    private Section pageSection = new Section();
    private Grid<SuppliersEntity> suppliersGrid = new Grid<>(SuppliersEntity.class);

    public DashboardView() {
        getContent().setHeightFull();
        getContent().setWidthFull();
        getContent().setFlexGrow(1.0, verticalLayout);
        verticalLayout.setSizeFull();
        verticalLayout.setClassName("content-area");

        getContent().add(pageHeaderLayout(), createPageBody(), pageFooterLayout());
    }


    // this method contains all components in the header field of the returning a horizontal layout
    @Override
    public HorizontalLayout pageHeaderLayout() {
        // TODO Auto-generated method stub
        pageHeaderLayout.addClassName(Gap.MEDIUM);
        pageHeaderLayout.setWidthFull();
        pageHeaderLayout.addClassName(Padding.SMALL);
        h3.setText("DASHBOARD ANALYSIS");
        h3.setClassName("header-text", true);
        pageHeaderLayout.add(h3);
        return pageHeaderLayout;
    }
   

    //This method returns a horizontal layout that contains all the content rendered in the body of the page.
    private VerticalLayout createPageBody() {
        pageSection.addClassName("dashboard-page-section");
        pageSection.setSizeFull();

        pageBodyLayout.setWidthFull();
        pageBodyLayout.addClassName(Gap.MEDIUM);
        pageBodyLayout.setFlexGrow(1.0, pageFooterLayout);

        //SUPPLIERS DIV CONTAINER
        Div totalSuppliersContainer = new Div();
        totalSuppliersContainer.setClassName("item-container");
        H4 suppliersLabel = new H4("Total Suppliers");
        H4 suppliersCountValue = new H4("1000");
        suppliersLabel.setClassName("item-container-label", true);
        suppliersCountValue.setClassName("item-container-values", true);
        totalSuppliersContainer.add(suppliersLabel, suppliersCountValue);

        //VISITORS DIV CONTAINER
        Div monthlyVisitors = new Div();
        monthlyVisitors.setClassName("item-container");
        H4 visitorsLabel = new H4("Total Visitors");
        H4 visitorsCountValue = new H4("1000");
        visitorsLabel.setClassName("item-container-label", true);
        visitorsCountValue.setClassName("item-container-values", true);
        monthlyVisitors.add(visitorsLabel, visitorsCountValue);


        //REGIONS AND DISTRICTS DIV CONTAINER
        Div districtsContainer = new Div();
        districtsContainer.setClassName("item-container");
        H4 districtsLabel = new H4("Total Districts");
        H4 districtsCountValue = new H4("1000");
        districtsLabel.setClassName("item-container-label", true);
        districtsCountValue.setClassName("item-container-values", true);
        districtsContainer.add(districtsLabel, districtsCountValue);

        //REGIONS AND DISTRICTS DIV CONTAINER
        Div regionalContainer = new Div();
        regionalContainer.setClassName("item-container");
        H4 regionalLabel = new H4("Total Regions");
        H4 regionalCountValue = new H4("1000");
        regionalLabel.setClassName("item-container-label", true);
        regionalCountValue.setClassName("item-container-values", true);
        regionalContainer.add(regionalLabel, regionalCountValue);

        pageSection.add(totalSuppliersContainer, monthlyVisitors, districtsContainer, regionalContainer);

        pageBodyLayout.add(pageSection);

        H4 gridNameLabel = new H4("TOP 5 SUPPLIERS");
        gridNameLabel.getStyle().setColor("gray");
        verticalLayout.add(pageBodyLayout, gridNameLabel, gridConfiguration());
        return verticalLayout;

    }//end of pageBodyLayout...


    //This method shall implement the grid configuration;

    private Component gridConfiguration() {
        suppliersGrid.addClassName("suppliers-grid");
        suppliersGrid.setWidthFull();
        suppliersGrid.setColumns("id", "supplier", "waterLocation", "mobileNumber", "totalVisits");
        suppliersGrid.getColumns().get(0).setHeader("ID");
        suppliersGrid.getColumns().get(1).setHeader("SUPPLIER");
        suppliersGrid.getColumns().get(2).setHeader("LOCATION");
        suppliersGrid.getColumns().get(3).setHeader("MOBILE NUMBER");
        suppliersGrid.getColumns().get(4).setHeader("TOTAL VISITS");
        suppliersGrid.getColumns().forEach(item -> item.setAutoWidth(true));
        

        return suppliersGrid;
    }


    //This method returns a horizontal layout that contains all the content rendered in the footer of the page.
    @Override
    public HorizontalLayout pageFooterLayout() {
        // TODO Auto-generated method stub
        pageFooterLayout.setHeightFull();
        pageFooterLayout.addClassName(Gap.MEDIUM);
        footerText.setText("Powered By MCs Republic | 2023");
        footerText.setClassName("footer-text");
        footerText.getStyle().set("font-size", "var(--lumo-font-size-s)");
        pageFooterLayout.add(footerText);
        return pageFooterLayout;
        
    }


}//end of class...
