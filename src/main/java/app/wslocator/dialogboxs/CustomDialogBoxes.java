package app.wslocator.dialogboxs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H4;

public class CustomDialogBoxes extends Dialog {
    
    private String title;
    private Component component;
    private Button closeButton = new Button("Close", (e) -> close());

    public CustomDialogBoxes(String title, Component component) {
        this.title = title;
        this.component = component;
        setCloseOnEsc(true);
        setCloseOnOutsideClick(true);
        addClassName("dialog-box");
        setHeaderTitle(title.toString());
        setDraggable(true);
        closeButton.addThemeVariants(ButtonVariant.LUMO_SMALL);
        closeButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        getFooter().add(closeButton);
        add(component);
    }


    public void showInformationDialog() {
        setHeaderTitle(title);
        getFooter().add(closeButton);
        add(component);
    }
    
}
