package app.wslocator.views.visitors;

import app.wslocator.views.MainLayout;
import app.wslocator.views.includes.HeaderAndFooter;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Visitors")
@Route(value = "/visitors", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class VisitorsView extends Composite<VerticalLayout> implements HeaderAndFooter{

    private HorizontalLayout pageLayout;
    private HorizontalLayout pageHeaderLayout = new HorizontalLayout();
    private HorizontalLayout pageFooterLayout = new HorizontalLayout();

    private H3 headerText = new H3();
    private Paragraph footerText = new Paragraph();
     


    

    public VisitorsView() {
       addClassName("visitors-main-view");
       getContent().add(pageHeaderLayout(), visitorsTableSection(), graphProjectionSection() ,pageFooterLayout());
    }


    @Override
    public HorizontalLayout pageHeaderLayout() {
        pageHeaderLayout.addClassName(Gap.MEDIUM);
        pageHeaderLayout.setWidthFull();
        pageHeaderLayout.addClassName(Padding.SMALL);
        headerText.setText("REVIEW SUPPLIERS WITH MOST VISITORS");
        headerText.setClassName("header-text", true);
        pageHeaderLayout.add(headerText);
        return pageHeaderLayout;
    }

    

    private HorizontalLayout graphProjectionSection() {
        pageLayout = new HorizontalLayout();
        addClassName("content-area");



        pageLayout.add(new Text("dfasdoifhdifhoiaf"));
        return pageLayout;
        
    }


    private HorizontalLayout visitorsTableSection() {
        pageLayout = new HorizontalLayout();


        return pageLayout;
    }


    @Override
    public HorizontalLayout pageFooterLayout() {
        pageFooterLayout.setHeightFull();
        pageFooterLayout.addClassName(Gap.MEDIUM);
        footerText.setText("Powered By MCs Republic | 2023");
        footerText.setClassName("footer-text");
        footerText.getStyle().set("font-size", "var(--lumo-font-size-s)");
        pageFooterLayout.add(footerText);
        return pageFooterLayout;
    }


    
}
