package app.wslocator.specialMehods;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.combobox.ComboBox;

import java.util.ArrayList;
import java.util.List;

public class SpecialMethods extends Component {

    public static void setIdTypes(ComboBox<String> comboBox) {
        String[] values = {"Driving License", "National Id", "Passport", "Voters Id"};
        for (String item : values) {
            comboBox.getListDataView().addItem(item);
        }
    }

    public static void setGender(ComboBox<String > comboBox) {
        comboBox.setItems("Female", "Male");
    }

    public static void setOrganizationalType(ComboBox<String> comboBox) {
        String[] values = {"Private Entity", "NGO", "Government Sponsored"};
        comboBox.setItems(values);
    }

    public static void setRegions(ComboBox<String> comboBox) {
        String[] values = {"Greater Accra", "Northern Region", "Eastern Region", "Volta Region"};
        comboBox.setItems(values);
    }

    public static void setDistricts(ComboBox<String> comboBox) {
        String[] values = {"Greater Accra", "Northern Region", "Eastern Region", "Volta Region"};
       comboBox.setItems(values);
    }

    public static void setWaterSource(ComboBox<String> comboBox) {
        String[] values = {"Borehole", "Treated Water", "Underground Water", "Rain Water"};
       comboBox.setItems(values);
    }

    public static void setWaterSourceLocation(ComboBox<String> comboBox) {
        String[] values = {"Greater Accra", "Northern Region", "Underground Water", "Rain Water"};
        comboBox.setItems(values);
    }




}//end of lass
