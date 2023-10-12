package app.wslocator.views.inbox;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Section;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import app.wslocator.views.MainLayout;
import app.wslocator.views.includes.HeaderAndFooter;
import jakarta.annotation.security.PermitAll;

@PageTitle("Inbox")
@Route(value = "/inbox", layout = MainLayout.class)
@PermitAll
public class InboxView extends Composite<VerticalLayout> implements HeaderAndFooter{

    private HorizontalLayout pageBodyLayout = new HorizontalLayout(); 
    private HorizontalLayout pageHeaderLayout;
     private H3 headerText = new H3();
     private Paragraph footerText = new Paragraph();
    
    public InboxView() {
        addClassName("inbox-main-layout");
        getContent().add(pageHeaderLayout(), generatePageBody(), pageFooterLayout());

    }

    
    //IMPLEMENT HEADER
    @Override
    public HorizontalLayout pageHeaderLayout() {
        pageHeaderLayout = new HorizontalLayout();
        pageHeaderLayout.addClassName(Gap.MEDIUM);
        pageHeaderLayout.setWidthFull();
        pageHeaderLayout.addClassName(Padding.SMALL);
        headerText.setText("MESSAGES SENT FROM YOUR FRONT PAGE");
        headerText.setClassName("header-text", true);
        pageHeaderLayout.add(headerText);

        return pageHeaderLayout;
    }


    //CREATE A BODY CONTENT TO HOLD ALL PAGE CONENTS...
    private HorizontalLayout generatePageBody() {
        pageBodyLayout.addClassName("content-area");
        pageBodyLayout.setWidthFull();


        //GENERATE MESSAGES TABLE...
        Section mainPageSection = new Section();
        mainPageSection.addClassName("page-section");
        

        Div displayMessagesDiv = new Div();
        Div readMessageDiv = new Div();
        displayMessagesDiv.addClassName("messages-container");
        readMessageDiv.addClassName("read-messages-container");
        displayMessagesDiv.setWidthFull();
        readMessageDiv.setWidthFull();


        //MESSAGE CONTAINER CONETNT.
        H4 messageHeaderLabel = new H4("INBOX MESSAGES");
        H4 messageContentLabel = new H4("VIEW CONTENT");
        messageHeaderLabel.getStyle().set("padding", "10px");
        messageContentLabel.getStyle().set("padding", "10px");
        


        //ADD COMPONENTS TO ITEM...
        displayMessagesDiv.add(messageHeaderLabel);
        readMessageDiv.add(messageContentLabel);
        mainPageSection.add(displayMessagesDiv, readMessageDiv);
        pageBodyLayout.add(mainPageSection);
        return pageBodyLayout;
    }




    //IMPLEMNT FOOTER METHOD;
    @Override 
    public HorizontalLayout pageFooterLayout() { 
        pageHeaderLayout = new HorizontalLayout();
        pageHeaderLayout.addClassName(Gap.MEDIUM);
        footerText.setText("Powered By MCs Republic | 2023");
        footerText.setClassName("footer-text");
        footerText.getStyle().set("font-size", "var(--lumo-font-size-s)");
        pageHeaderLayout.add(footerText);


        return pageHeaderLayout;
    
    }
    
}//end of class
