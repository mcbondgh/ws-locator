package app.wslocator.views.regions_districts;

import app.wslocator.data.entity.RegionalAndDistrictEntity;
import app.wslocator.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Regions | Districts")
@Route(value = "/regions_districts", layout = MainLayout.class)
@AnonymousAllowed
public class RegionsAndDistricts extends VerticalLayout {


    /*
     * PRIVATE FIELDS DELARATION...
     */

     private TextField filterRegionsField = new TextField();
     private Grid<RegionalAndDistrictEntity> regionsTable = new Grid<>(RegionalAndDistrictEntity.class, isAttached());
     private TextField districtField = new TextField();
     private NumberField sizeField = new NumberField();
     private ComboBox<RegionalAndDistrictEntity> regionsSelector = new ComboBox();
     private Button updateButton = new Button("Update");
     private Button cancelButton = new Button("Cancel");
     private TextField filterDistrictsField = new TextField();
     private Grid<RegionalAndDistrictEntity> districtsTable = new Grid<>(RegionalAndDistrictEntity.class);
     
    /*
     * CONSTRUCTOR
     */
    public RegionsAndDistricts() {
        add(horizontalPageLayout());
        
    }



    private HorizontalLayout horizontalPageLayout() {
        HorizontalLayout horizontalLayout = new HorizontalLayout(getDefaultHorizontalComponentAlignment());
        FormLayout formLayout = new FormLayout();

        horizontalLayout.setWidthFull();
        formLayout.setWidthFull();
        horizontalLayout.setClassName("content-area");
        formLayout.add(regionsLayout(), districtLayout());
        horizontalLayout.add(formLayout);
        return horizontalLayout;
    }

    private Component headerItems(H4 headerLabel) {
        Div headerDiv = new Div();
        headerDiv.addClassName("header-container-div");
        headerDiv.getStyle().setMargin("auto");

        headerLabel.addClassName("header-text");
        headerDiv.add(headerLabel);
        return headerDiv;
    }

    // VERTICAL LAYOUT THAT HOLDS ITEMS IN THE REGIONS LAYOUT...
    private VerticalLayout regionsLayout() {
        VerticalLayout verticalLayout = new VerticalLayout(getDefaultHorizontalComponentAlignment());
        
        H4 headerLabel = new H4("REGIONS & CAPITAL");
        filterRegionsField.setPlaceholder("Filter regions by name...");

        verticalLayout.add(
           headerItems(headerLabel),
            filterRegionsField,
             setRegionsGrid()
            );

        verticalLayout.addClassName("section-container");
        return verticalLayout;
    }

    // VERTICAL LAYOUAT THAT HOLDS ITEMS IN THE DISTRICTS LAYOUT...
    private VerticalLayout districtLayout() {
        VerticalLayout verticalLayout = new VerticalLayout(getDefaultHorizontalComponentAlignment());
        H4 headerLabel = new H4("DISTRICTS");
        filterDistrictsField.setPlaceholder("Filter districts by name...");
        updateButton.addClassName("save-button");
        cancelButton.addClassName("cancel-button");
        cancelButton.getStyle().set("margin-left", "10px");
        cancelButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        updateButton.addThemeVariants(ButtonVariant.LUMO_SMALL);

        districtField.setPlaceholder("District Name");
        sizeField.setPlaceholder("143");
        regionsSelector.setPlaceholder("Pick a region");
        

        //CREATE A SECTION TO HOLD THE BUTTONS...
        Section sectionContainer = new Section();
        sectionContainer.add(updateButton, cancelButton);
        sectionContainer.addClassName("buttons-container");
        



        //SET REQUIRED FIELDS...
        districtField.setRequired(true);
        sizeField.setRequired(true);
        regionsSelector.setRequired(true);


        //CREATE A NEW FORM LAYOUT TO CONTAIN THE MINI FORM...
        FormLayout formLayout = new FormLayout();
        formLayout.add(districtField, sizeField, regionsSelector);
        formLayout.setColspan(regionsSelector, 2);



        verticalLayout.addClassName("section-container");
        verticalLayout.add(
            headerItems(headerLabel),
            formLayout,
            sectionContainer,
            new Hr(),
            filterDistrictsField,
            setDistrictGrid()
            );
        return verticalLayout;
    }



    //REGIONAL GRID CONFIGURATION 
    private Grid<RegionalAndDistrictEntity> setRegionsGrid() {
        regionsTable.setColumns("regionId", "regionName", "capital");


        regionsTable.setMaxHeight("500px");   
        return regionsTable;
    }

    private Grid<RegionalAndDistrictEntity> setDistrictGrid() {
        // districtsTable.addColumn(RegionalAndDistrictEntity::getDistrictId).setHeader("Id");
        districtsTable.setColumns("districtId", "districtName", "size");
        districtsTable.getColumns().forEach(item -> item.setAutoWidth(true));


        districtsTable.setMaxHeight("400px");
        return districtsTable;
    }



}//end of class...
