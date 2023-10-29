package app.wslocator.data.entity;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;



public class EmployeesEntity {

    private int emp_id;
    private String firstname, lastname, gender;
    private String mobile, email, digital_add;
    private LocalDate date_employed;
    private String username, passwword, role_name;
    private Timestamp date_added;
    private int added_by;
    private String fullName;

    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
    private String formattedDate;

    public EmployeesEntity(){}

    public EmployeesEntity(int emp_id, String firstname, String lastname, String gender, String mobile, String email,
            String digital_add, LocalDate date_employed, String username, String passwword, String role_name,
            Timestamp date_added, int added_by) {
        this.emp_id = emp_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.digital_add = digital_add;
        this.date_employed = date_employed;
        this.username = username;
        this.passwword = passwword;
        this.role_name = role_name;
        this.date_added = date_added;
        this.added_by = added_by;
        this.fullName = this.firstname.concat(" ").concat(lastname);
        formattedDate = this.date_employed.format(dateFormatter);
    }
    public int getEmp_id() {
        return emp_id;
    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDigital_add() {
        return digital_add;
    }
    public void setDigital_add(String digital_add) {
        this.digital_add = digital_add;
    }
    public LocalDate getDate_employed() {
        return date_employed;
    }
    public void setDate_employed(LocalDate date_employd) {
        this.date_employed = date_employd;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPasswword() {
        return passwword;
    }
    public void setPasswword(String passwword) {
        this.passwword = passwword;
    }
    public String getRole_name() {
        return role_name;
    }
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
    public Timestamp getDate_added() {
        return date_added;
    }
    public void setDate_added(Timestamp date_added) {
        this.date_added = date_added;
    }
    public int getAdded_by() {
        return added_by;
    }
    public void setAdded_by(int added_by) {
        this.added_by = added_by;
    }
    public String getFormattedDate() {
        return formattedDate;
    }
    public void setFormattedDate(String formattedDate) {
        this.formattedDate = formattedDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    

    
}
