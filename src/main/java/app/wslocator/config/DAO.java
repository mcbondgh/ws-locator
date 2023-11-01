package app.wslocator.config;

import com.helger.commons.io.file.IFileFilter;
import com.mysql.cj.protocol.Resultset;

import app.wslocator.data.entity.EmployeesEntity;
import app.wslocator.models.MainModel;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAO extends Variables {

    protected ResultSet resultset;
    private Connection connection;
    protected PreparedStatement prepare;
    protected Statement statement;

    protected Connection getConnection() {
        String URL = loadProperties().getProperty("db.path");
        String USERNAME = loadProperties().getProperty("db.username");
        String PASSWORD = loadProperties().getProperty("db.password");
        try{
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    protected void commitTransaction() throws SQLException {
        try {
            connection.setAutoCommit(false);
            connection.commit();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void rollbackTransaction() {
        try{
            connection.rollback();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<EmployeesEntity> getAllEmployees() {
         ArrayList<EmployeesEntity> data = new ArrayList<>();
        try {
           
            String query = "SELECT * FROM employees";
            statement = getConnection().createStatement();
            resultset = statement.executeQuery(query);
            while(resultset.next()) {
                int empId = resultset.getInt("emp_id");
                String fName = resultset.getString("firstname");
                String lName = resultset.getString("lastname");
                String gender = resultset.getString("gender");
                String mobile = resultset.getString("mobile");
                String email = resultset.getString("email");
                String address = resultset.getString("digital_add");
                LocalDate date = resultset.getDate("date_employed").toLocalDate();
                String username = resultset.getString("username");
                String pasword = resultset.getString("passwword");
                String role = resultset.getString("role_name");
                int userId = resultset.getInt("added_by");
                data.add(new EmployeesEntity(empId, fName, lName, gender, mobile, email, address, date, username, pasword, role, null, userId));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
        return data;
    }































    // public static void main(String[] args) {
    //     MainModel dao = new MainModel();
    //     try {
    //        if (dao.insertRecord()> 0) {
    //             System.out.println("Table successfully created");
    //        } else {
    //         System.out.println("failed to create table...");
    //        }

    //     }catch(Exception e) {
    //         e.printStackTrace();
    //     }
    // }

}//end of class..
