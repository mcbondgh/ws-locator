package app.wslocator.views.contact;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import app.wslocator.views.layouts.HeaderFooterLayouts;


@AnonymousAllowed
@Route(value = "/contact", layout = HeaderFooterLayouts.class)
@RouteAlias(value = "/contact", layout = HeaderFooterLayouts.class)
@PageTitle("Contact Us")
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
        addClassName("contact-page-view");

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

    private Component pageContent() {
        HorizontalLayout layout = new HorizontalLayout();
        FormLayout formLayout = new FormLayout();
        VerticalLayout contact = new VerticalLayout();

        sendButton.addClassName("save-button");
        formLayout.addClassName("contact-form-layout");
        contact.addClassName("contact-layout");
        formLayout.add(subjectField, contactField, emailField, contentField, sendButton);

        contentField.addClassName("content-field");
        contentField.setRequiredIndicatorVisible(true);

        H3 heading3 = new H3("Reach Out On Our Socials.");
        H4 numbersTitle = new H4("Call or WhatsApp Us On");
        Paragraph number1 = new Paragraph("+233 020000001");
        Paragraph number2 = new Paragraph("+233 039000001");

        H4 emailTitle = new H4("Send Us An Email On");
        Paragraph emailAddress = new Paragraph("youremail@yahoo.com");

        layout.setSizeFull();
        layout.addClassName("page-content-container");
        layout.add(formLayout, contact);
        return layout;
    }

    
}//end of class
