package app.wslocator.grids;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.Format;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.LinkedList;

import org.springframework.format.annotation.DateTimeFormat;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;

import app.wslocator.data.entity.InboxEntity;

public class InboxGrid extends Component{
    
    private static Grid<InboxEntity> inboxGrid = new Grid<>(InboxEntity.class);


    public static Grid<InboxEntity> generateInboxGrid() {
        
        return inboxGrid;
    }

    public static ListDataProvider<InboxEntity> populateGrid() {

        LinkedList<InboxEntity> dataItems = new LinkedList<InboxEntity>();

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        LocalDateTime localDateTime = LocalDateTime.now();

        dataItems.add(new InboxEntity(1, "NEW DISCOVERY", "I have discovered water...", "email@exmail.com", "0443434", localDateTime));
        dataItems.add(new InboxEntity(2, "GOOD JOB", "In this example, a Grid component is created and a ListDataProvider", "teo@gmi.com", "904934034", localDateTime));
        dataItems.add(new InboxEntity(3, "PURE WATER", "Your water supply is really pure and replable. Thank you.", "iddi@gmail.cpm", "4348384",localDateTime));
        dataItems.add(new InboxEntity(4, "I NEED SUPPLY", "I reayy need some water at my location. How is for the borehole digging.?", "exampl.com", "08383838",localDateTime));
        dataItems.add(new InboxEntity(5, "CALL FOR SPONSORSHIP", "Your service is need at LOCATION for a paid contract.", "contract@gmail.com", "11110000", localDateTime));

        ListDataProvider<InboxEntity> dataProvider = new ListDataProvider<>(dataItems); 
        inboxGrid.setItems(dataProvider);
        return dataProvider;
    }

    public static void gridItemSelected(TextField title, TextField email, TextArea body, Grid<InboxEntity> indexGrid) {
        

    }
    
        
}// end of class...
