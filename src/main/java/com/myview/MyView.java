package com.myview;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;

/**
 * A Designer generated component for the my-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("my-view")
@JsModule("./themes/ws-locator/components/my-view.ts")
public class MyView extends LitTemplate {

    @Id("vaadinDialog")
    private Dialog vaadinDialog;

    /**
     * Creates a new MyView.
     */
    public MyView() {
        // You can initialise any data required for the connected UI components here.
    }

}
