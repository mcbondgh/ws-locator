package app.wslocator.data.entity;

import java.sql.Timestamp;
import java.util.LinkedList;

import org.springframework.format.annotation.DateTimeFormat;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.ListDataProvider;

public class EmployeesEntity   {
    private int id;
    private String firstname;
    private String lastname;
    private String fullname;
    private String mobileNumber;
    private String email;
    private String digitalAddress;
    private String formattedDate;
    private DateTimeFormat formatter;
    private Timestamp emplymentDate;
    private String password;
    private String username;
    private String userRole;
    public EmployeesEntity(int id, String firstname, String lastname, String mobileNumber, String email,
            String digitalAddress, DateTimeFormat formatter, Timestamp emplymentDate, String password, String username,
            String userRole) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = firstname.concat(" " + lastname);
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.digitalAddress = digitalAddress;
        this.formatter = formatter;
        this.emplymentDate = emplymentDate;
        this.password = password;
        this.username = username;
        this.userRole = userRole;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public String getEmail() {
        return email;
    }
    
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDigitalAddress() {
        return digitalAddress;
    }
    public void setDigitalAddress(String digitalAddress) {
        this.digitalAddress = digitalAddress;
    }
    public String getFormattedDate() {
        return formattedDate;
    }
    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }
    public DateTimeFormat getFormatter() {
        return formatter;
    }
    public void setFormatter(DateTimeFormat formatter) {
        this.formatter = formatter;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserRole() {
        return userRole;
    }
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    
    //generate grid for settings UI;
    private Grid<EmployeesEntity> employess = new Grid<EmployeesEntity>(); 

    public ListDataProvider<EmployeesEntity> populateEmployeesTable() {

        LinkedList<EmployeesEntity> listItems = new LinkedList<EmployeesEntity>();

        //load dataProvider with data from database...

        //

        ListDataProvider<EmployeesEntity> dataProvider = new ListDataProvider<>(listItems);

        return dataProvider;
    }
    
    
}
