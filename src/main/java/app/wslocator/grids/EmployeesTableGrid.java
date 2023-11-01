package app.wslocator.grids;

import java.util.LinkedList;

import org.hibernate.mapping.List;

import com.vaadin.flow.data.provider.ListDataProvider;

import app.wslocator.config.DAO;
import app.wslocator.data.entity.EmployeesEntity;

public class EmployeesTableGrid extends DAO{

    public ListDataProvider<EmployeesEntity> populateGrid() {
        LinkedList<EmployeesEntity> list = new LinkedList<>();
        list.addAll(getAllEmployees());
        ListDataProvider<EmployeesEntity> provider = new ListDataProvider<>(list);
        return provider;
    }
    
}//end of class...
