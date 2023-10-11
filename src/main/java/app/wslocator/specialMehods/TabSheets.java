package app.wslocator.specialMehods;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;

public class TabSheets {
    private HorizontalLayout layoutRow = new HorizontalLayout();

    private H3 h3 = new H3();

    private VerticalLayout layoutColumn2 = new VerticalLayout();

    private TabSheet tabSheet = new TabSheet();

    private HorizontalLayout layoutRow2 = new HorizontalLayout();

    private Paragraph textMedium = new Paragraph();
    private void setTabSheetSampleData(TabSheet tabSheet) {
        tabSheet.add("Dashboard", new Div(new Text("This is the Dashboard tab content")));
        tabSheet.add("Payment", new Div(new Text("This is the Payment tab content")));
        tabSheet.add("Shipping", new Div(new Text("This is the Shipping tab content")));

         Text bodyContnt = new Text(null);
         bodyContnt.setText("This is the content of my customed Tab and this makes it" +
         "sinmpler for me to tell what I am doing...");

         FormLayout layout = new FormLayout(bodyContnt);

        tabSheet.add("Visitors", layout);
    }
    
}
