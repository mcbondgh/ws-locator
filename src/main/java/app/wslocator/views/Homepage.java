package app.wslocator.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import app.wslocator.views.layouts.HeaderFooterLayouts;


@PageTitle("Homepage")
@Route(value = "",  layout = HeaderFooterLayouts.class)
@RouteAlias(value = "",  layout = HeaderFooterLayouts.class)
@AnonymousAllowed
public class Homepage extends VerticalLayout {


    //PRIVATE FIELDS;

    private TextField searchField = new TextField();
    private Button searchButton = new Button("Search Supplier");


    public Homepage() {
        add(searchLayout(), pageBody());
    }


    @Override
    public void onAttach(AttachEvent attachEvent){
        super.onAttach(attachEvent);
        attachEvent.getUI().getPage().executeJs("window.location.href = 'frontend://template.html';");
    }

    public Component searchLayout() {
        VerticalLayout layout = new VerticalLayout(getDefaultHorizontalComponentAlignment());
        layout.addClassName("search-container");
        layout.setWidthFull();
        Div section = new Div();
        section.addClassName("container");
        section.setWidth("600px");

        searchButton.setClassName("search-button");
        searchField.setClassName("search-field");
        searchField.setPlaceholder("SEARCH FOR SUPPLIER HERE...");
        searchField.setTooltipText("Search for vender here...");
        
        section.add(searchField, searchButton);
        layout.add(section);
        return layout;

    }

    public Component pageBody() {
        HorizontalLayout layout = new HorizontalLayout();

        return layout;
    }


    
    
}//end of class...
