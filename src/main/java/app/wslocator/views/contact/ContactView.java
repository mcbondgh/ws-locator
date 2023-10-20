package app.wslocator.views.contact;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import app.wslocator.views.layouts.HeaderFooterLayouts;
import org.jetbrains.annotations.NotNull;


@Route(value = "/contact", layout = HeaderFooterLayouts.class)
@RouteAlias(value = "contact", layout = HeaderFooterLayouts.class)
@PageTitle("Contact Us")
@AnonymousAllowed
public class ContactView extends VerticalLayout {

/***********************************************************************************************************************
******************************************* PRIVATE FIELDS....
************************************************************************************************************************/
    private TextField subjectField = new TextField("Subject");
    private TextField contactField = new TextField("Mobile Number");
    private EmailField emailField = new EmailField("Email Address");
    private TextArea contentField = new TextArea("Your Message");
    private Button sendButton = new Button("Send Message");



    //CONSTRUCTOR
    public ContactView() {

        add(
           heroDisplayArea(), pageContent()
        );
        //<theme-editor-local-classname>
        addClassName("contact-view-vertical-layout-1");
    }

/***********************************************************************************************************************
******************************************* PAGE CONTENT....
 ***********************************************************************************************************************/
    private Component heroDisplayArea() {
        VerticalLayout layout = new VerticalLayout();
        H1 heroText = new H1("Get In Touch With Us");
        Paragraph contentText = new Paragraph("Want to know more about our operations or our agenda? We'd love to chat.");
        Div heroDiv = new Div();

        heroDiv.addClassName("hero-div");
        heroText.addClassName("hero-text");
        contentText.addClassName("content-text");
        layout.addClassName("header-layout-container");

        heroDiv.add(heroText, contentText);
        layout.add(heroDiv);
        return layout;
    }

    //Contact page container
    private Component pageContent() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();
        layout.addClassName("page-content-container");
        layout.add(contactFormDesign(), contactInformationDesign());
        return layout;
    }

    private Component contactInformationDesign() {
        VerticalLayout layout = new VerticalLayout();
        layout.addClassName("contact-information-layout");

        Div numbersContainer = new Div();
        numbersContainer.setClassName("numbers-container");

        H2 infoHeader = new H2("Lets Get Interactive On Our Socials");
        infoHeader.getStyle().set("color", "#33383a").set("font-size", "24px").set("margin-top", "15px");
        Image phoneImage = new Image("/icons/mobilePhone.png", "");
        phoneImage.addClassName("phone-image");

        //MOBILE NUMBERS CONTAINER...
        H5 numbersHeader = new H5(" Call Or WhatsApp Us");
        Paragraph number1 = new Paragraph("+233 2000000001");
        Paragraph number2 = new Paragraph("+233 2400000003");
        number1.setClassName("number-text");
        number2.setClassName("number-text");
        numbersContainer.add(phoneImage, numbersHeader, number1, number2);
        numbersContainer.addClassName("numbers-container");

        //EMAIL CONTAINER
        Div emailContainer = new Div();
        H5 emailHeader = new H5("Email");
        Image emailImage = new Image("/icons/email.png", "");
        emailImage.getStyle().set("height", "50px");
        emailContainer.setClassName("email-container");
        Paragraph emailAddress = new Paragraph("example@wslocator.com");
        emailAddress.addClassName("number-text");
        emailContainer.add(emailImage, emailHeader, emailAddress);

        //SOCIAL MEDIA HANDLES.
        Div socialMediaContainer = getDiv();

        layout.add(infoHeader, numbersContainer, emailContainer, socialMediaContainer);
        return layout;
    }

    @NotNull
    private static Div getDiv() {
        Div mediaContainer = new Div();
        H5 mediaHeader = new H5("Follow Us On Our Handles.");
        Div facebookDiv = new Div();
        facebookDiv.addClassName("div-containers");
        Image facebookIcon = new Image("/icons/facebook-icon.png", "facebook");
        facebookIcon.setClassName("social-media-icons");
        Anchor facebookText = new Anchor("https://facebook.com/ws_locator", "facebook");
        facebookDiv.add(facebookIcon, facebookText);

        Div instagramDiv = new Div();
        Image instagramImage = new Image("/icons/instagram.png", "Instagram");
        instagramImage.setClassName("social-media-icons");
        Anchor instagramText = new Anchor("https://instagram.com/wslocator_official", "instagram");
        instagramDiv.add(instagramImage, instagramText);
        instagramDiv.addClassName("div-containers");

        Div twitterDiv = new Div();
        Image twitterImage = new Image("/icons/twitter.png", "Instagram");
        twitterImage.setClassName("social-media-icons");
        Anchor twitterText = new Anchor("https://x.com/wslocator_gh", "twitter");
        twitterDiv.add(twitterImage, twitterText);
        twitterDiv.addClassName("div-containers");

        Div socialMediaContainer = new Div();
        socialMediaContainer.add(facebookDiv, instagramDiv, twitterDiv);
        return socialMediaContainer;
    }

    private Component contactFormDesign() {
        FormLayout formLayout = new FormLayout();
        formLayout.setSizeFull();
        sendButton.addClassName("save-button");
        formLayout.addClassName("contact-form-layout");

        contentField.addClassName("content-field");
        contentField.setRequiredIndicatorVisible(true);
        contentField.setInvalid(true);

        H3 heading3 = new H3("Reach Out On Our Socials.");
        H4 numbersTitle = new H4("Call or WhatsApp Us On");
        Paragraph number1 = new Paragraph("+233 020000001");
        Paragraph number2 = new Paragraph("+233 039000001");

        H4 emailTitle = new H4("Send Us An Email On");
        Paragraph emailAddress = new Paragraph("youremail@yahoo.com");


        formLayout.add(subjectField, contactField, emailField, contentField, sendButton);
        return formLayout;
    }
    
}//end of class
