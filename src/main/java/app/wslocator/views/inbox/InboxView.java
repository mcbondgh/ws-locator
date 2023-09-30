package app.wslocator.views.inbox;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import app.wslocator.views.MainLayout;
import jakarta.annotation.security.PermitAll;

@PageTitle("Inbox")
@Route(value = "/inbox", layout = MainLayout.class)
@PermitAll
public class InboxView extends Composite<VerticalLayout> {
    
    public InboxView() {

    }
    
}//end of class
