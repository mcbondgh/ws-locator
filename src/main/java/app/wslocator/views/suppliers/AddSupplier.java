package app.wslocator.views.suppliers;

import app.wslocator.prompts.UserDialogs;
import app.wslocator.specialMehods.SpecialMethods;
import app.wslocator.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.PermitAll;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.Objects;

import javax.swing.GroupLayout;


@PageTitle("Add Supplier")
@Route(value = "/add_supplier", layout = MainLayout.class)
@PermitAll

public class AddSupplier extends VerticalLayout {

    //PRIVATE LAYOUT COMPONENTS
    private HorizontalLayout headerLayout = new HorizontalLayout();
    private HorizontalLayout pageFooterLayout = new HorizontalLayout();
    private FormLayout formLayout = new FormLayout();
    private VerticalLayout pageLayout = new VerticalLayout();
    private FlexLayout flexLayout = new FlexLayout();

    //PRIVATE FIELDS
    private final Button viewSuppliersButton = new Button("View Suppliers");
    private TextField firstNameField = new TextField("First Name");
    private TextField lastNameField = new TextField("Last Name");
    private NumberField mobileNumberField = new NumberField("Mobile Number");
    private NumberField hotLineField = new NumberField("Hotline");
    private TextField digitalAddress = new TextField("Digital Address");
    private ComboBox<String> idSelector = new ComboBox<>("Id Type");
    private TextField idNumberField = new TextField("Id Number");
    private EmailField emailField = new EmailField("Business Email");
    private TextField businessNameField = new TextField("Business Name");
    private ComboBox<Integer> yearsOfOperationField = new ComboBox<>("Years Of Operation");
    private ComboBox<String> organizationalType = new ComboBox<>("Organization Type");
    private ComboBox<String> regionSelector = new ComboBox<>("Region");
    private ComboBox<String> districtSelector = new ComboBox<>("District");
    private ComboBox<String> waterSourceSelector = new ComboBox<>("Water Source");
    private ComboBox<String> sourceLocationSelector = new ComboBox<>("Source Location");
    private TextField supplyAreas = new TextField("Areas Of Supply");
    private DatePicker establishedDatePicker = new DatePicker("Established Date");
    private TextArea descriptionField = new TextArea("Business Description");
    private Upload uploadsButton = new Upload();
    private Image imageView = new Image();
    private Button saveButton = new Button("Save");
    private Button cancelButton = new Button("Cancel");

    private Paragraph footerText = new Paragraph();
    private String fileName = "";



    public AddSupplier() {
        add( generatePageHeader(), generatePageBody(), generateFooter());
        populateFields();
        actionEventMethods();
        imageContentUploaded();
    }

    /*******************************************************************************************************************
     ***************************************** UI VIEWS IMPLEMENTATION *************************************
     ******************************************************************************************************************/
    private Component generatePageHeader() {
        viewSuppliersButton.addClassName("view-supplier-button");
        headerLayout.addClassName("header-layout");
        headerLayout.setWidthFull();

        headerLayout.add(viewSuppliersButton);
        return headerLayout;
    }
    private Component generatePageBody() {
        formLayout.addClassName("form-layout");
        formLayout.getStyle().setPadding("10px");
        formLayout.setWidthFull();
        formLayout.setResponsiveSteps(
                new FormLayout.ResponsiveStep("0", 1),
                new FormLayout.ResponsiveStep("500px", 4)
        );

        //Set all required fields to true.
        firstNameField.setPlaceholder("Kofi");
        firstNameField.setRequired(true);
        lastNameField.setPlaceholder("Adzololo");
        lastNameField.setRequired(true);
        mobileNumberField.setPlaceholder("0200000001");
        mobileNumberField.setRequired(true);
        hotLineField.setPlaceholder("0200000001");
        hotLineField.setRequired(true);
        digitalAddress.setPlaceholder("KE-9393-223");
        digitalAddress.setRequired(true);
        idSelector.setPlaceholder("Eastern Region");
        idSelector.setRequired(true);
        idNumberField.setRequired(true);
        idNumberField.setPlaceholder("GHA-9993330330-3");
        emailField.setPlaceholder("business@example.com");
        emailField.setRequired(true);
        businessNameField.setPlaceholder("KOFI MENSAH WATER HUB");
        businessNameField.setRequired(true);
        yearsOfOperationField.setPlaceholder("10");
        yearsOfOperationField.setRequired(true);
        organizationalType.setPlaceholder("NGO");
        organizationalType.setRequired(true);
        regionSelector.setPlaceholder("Eastern Region");
        regionSelector.setRequired(true);
        districtSelector.setPlaceholder("New Guabeng");
        districtSelector.setRequired(true);
        waterSourceSelector.setRequired(true);
        waterSourceSelector.setPlaceholder("Treated Water");
        sourceLocationSelector.setPlaceholder("Edzesu");
        sourceLocationSelector.setRequired(true);
        establishedDatePicker.setPlaceholder("10/10/2010");
        establishedDatePicker.setRequired(true);
        descriptionField.setRequired(true);
        descriptionField.setPlaceholder("Tell us about your business...");

        //HORIZONTAL LAYOUT TO HOLD THE ACTION BUTTONS...
        HorizontalLayout buttonLayoutContainer = new HorizontalLayout();
        HorizontalLayout formTitleLayout = new HorizontalLayout();
        H3 formTitleLabel = new H3("Add New Supplier To Database");
        formTitleLayout.addClassName("form-title-container");
        buttonLayoutContainer.addClassName("buttons-layout-container");
        buttonLayoutContainer.setWidthFull();
        formTitleLayout.setWidthFull();

        formTitleLayout.add(formTitleLabel);

        saveButton.addClassName("save-button"); cancelButton.addClassName("cancel-button");
        saveButton.addThemeVariants(ButtonVariant.LUMO_SMALL); cancelButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        buttonLayoutContainer.add(saveButton, cancelButton);

        //ADD COMPONENTS TO THE FORM LAYOUT...
        formLayout.add(
                formTitleLayout,
                firstNameField, lastNameField, mobileNumberField, hotLineField, digitalAddress, idSelector,
                idNumberField, emailField, businessNameField, yearsOfOperationField, organizationalType,
                regionSelector, districtSelector, waterSourceSelector, sourceLocationSelector, supplyAreas,
                establishedDatePicker, uploadsButton, imageView, descriptionField,
                buttonLayoutContainer
        );

        //SET COLUMN SPAN FOR THE description field to full
        formLayout.setColspan(descriptionField, 4);
        formLayout.setColspan(buttonLayoutContainer, 4);
        formLayout.setColspan(formTitleLayout, 4);
        formLayout.setColspan(businessNameField, 2);


        pageLayout.add(formLayout);
        pageLayout.setClassName("page-body-layout");
        return pageLayout;
    }


    //FOOTER COMPONENT IMPLEMENTATION
    public Component generateFooter() {
        pageFooterLayout.setWidthFull();
        pageFooterLayout.addClassName(LumoUtility.Gap.MEDIUM);
        footerText.setClassName("footer-text");
        footerText.setText("Powered By MCs Republic | 2023");
        footerText.getStyle().set("font-size", "var(--lumo-font-size-s)");
        pageFooterLayout.add(footerText);
        return pageFooterLayout;
    }



    /*******************************************************************************************************************
     ***************************************** TRUE OR FALSE STATEMENTS *************************************
     ******************************************************************************************************************/



    /*******************************************************************************************************************
     ***************************************** IMPLEMENTATION OF OTHER METHODS ****************************************
     ******************************************************************************************************************/
    void populateFields() {
        SpecialMethods.setIdTypes(idSelector);
        SpecialMethods.setOrganizationalType(organizationalType);
        for (int x=1; x<=100; ++x) {
            yearsOfOperationField.getListDataView().addItem(x);
        }
        SpecialMethods.setDistricts(districtSelector);
        SpecialMethods.setRegions(regionSelector);
        SpecialMethods.setWaterSource(waterSourceSelector);
        SpecialMethods.setWaterSourceLocation(sourceLocationSelector);
    }//end of method...

    void inputFieldsValidation() {
        firstNameField.setInvalid(firstNameField.getValue().isEmpty());
        lastNameField.setInvalid(lastNameField.getValue().isEmpty());
        mobileNumberField.setInvalid(mobileNumberField.isEmpty());
        hotLineField.setInvalid(hotLineField.isEmpty());
        digitalAddress.setInvalid(digitalAddress.getValue().isEmpty());
        idSelector.setInvalid(idSelector.getOptionalValue().isEmpty());
        idNumberField.setInvalid(idNumberField.getValue().isEmpty());
        emailField.setInvalid(emailField.getValue().isEmpty());
       businessNameField.setInvalid(businessNameField.getValue().isEmpty());
       yearsOfOperationField.setInvalid(yearsOfOperationField.getOptionalValue().isEmpty());
       organizationalType.setInvalid(organizationalType.getOptionalValue().isEmpty());
       regionSelector.setInvalid(regionSelector.getOptionalValue().isEmpty());
       districtSelector.setInvalid(districtSelector.getOptionalValue().isEmpty());
       waterSourceSelector.setInvalid(waterSourceSelector.getOptionalValue().isEmpty());
       sourceLocationSelector.setInvalid(sourceLocationSelector.getOptionalValue().isEmpty());
       establishedDatePicker.setInvalid(Objects.equals(establishedDatePicker.getValue(), null));
       descriptionField.setInvalid(descriptionField.getOptionalValue().isEmpty());
    }






    /*******************************************************************************************************************
     ***************************************** ACTION EVENT METHODS IMPLEMENTATION *************************************
     ******************************************************************************************************************/

     public void actionEventMethods() {

        // view suppliers button clicked will navigate to the UI where you see all suppliers...
        viewSuppliersButton.addClickListener(clickEvent -> {
           getUI().flatMap(ui -> ui.navigate(SupplersView.class));
        });

        //Save Button Clicked...
         saveButton.addClickListener(clickEvent -> {
             inputFieldsValidation();
             if (!(firstNameField.isInvalid() || lastNameField.isInvalid() || mobileNumberField.isInvalid() || digitalAddress.isInvalid() || hotLineField.isInvalid() ||
                     idSelector.isInvalid() || idNumberField.isInvalid() || emailField.isInvalid() || businessNameField.isInvalid() || yearsOfOperationField.isInvalid() ||
                     organizationalType.isInvalid() || waterSourceSelector.isInvalid() || regionSelector.isInvalid() || districtSelector.isInvalid() || sourceLocationSelector.isInvalid() ||
                     establishedDatePicker.isInvalid() || descriptionField.isInvalid())
             ) {
                String firstname = firstNameField.getValue();
                String lastname = lastNameField.getValue();
                String mobileNumber = String.valueOf(mobileNumberField.getValue());
                String hotLine = String.valueOf(hotLineField.getValue());
                String address = digitalAddress.getValue();
                String email = emailField.getValue();
                String idType = idSelector.getValue();
                String idNumber = idNumberField.getValue();
                String businessName = businessNameField.getValue();
                int yearsOfService = yearsOfOperationField.getValue();
                String organizationType = organizationalType.getValue();
                String region = regionSelector.getValue();
                String district = districtSelector.getValue();
                String source = waterSourceSelector.getValue();
                String locator = sourceLocationSelector.getValue();
                String areaOfSupply = supplyAreas.getValue();
                String description = descriptionField.getValue();
                LocalDate establishedDate = establishedDatePicker.getValue();
                
             }
         });

     }//end of actionEventMethod...

    void imageContentUploaded() {
         //Define file upload limit
        uploadsButton.setMaxFiles(3);
        MultiFileMemoryBuffer multiFile = new MultiFileMemoryBuffer();
        uploadsButton.setReceiver(multiFile);

         uploadsButton.addSucceededListener(successEvent -> {
            fileName = successEvent.getFileName();
            InputStream inputStream = multiFile.getInputStream(fileName);

             StreamResource streamSource = new StreamResource(fileName, () -> inputStream);
             imageView.setSrc(streamSource);
         });
    }











}//end of class...
