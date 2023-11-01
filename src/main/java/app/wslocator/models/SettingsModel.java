package app.wslocator.models;

import java.sql.Date;
import java.sql.SQLException;

import app.wslocator.config.DAO;
import app.wslocator.data.entity.EmployeesEntity;

public class SettingsModel extends DAO{

    public int saveEmployee(EmployeesEntity entity) {
        int status = 0;
        try {
            String query = "INSERT INTO employees(firstname, lastname, gender, mobile, email, digital_add, date_employed, username, passwword, role_name)" + 
                            " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            prepare = getConnection().prepareStatement(query);
            prepare.setString(1, entity.getFirstname());
            prepare.setString(2, entity.getLastname());
            prepare.setString(3, entity.getGender());
            prepare.setString(4, entity.getMobile());
            prepare.setString(5, entity.getEmail());
            prepare.setString(6, entity.getDigital_add());
            prepare.setDate(7, Date.valueOf(entity.getDate_employed()));
            prepare.setString(8, entity.getUsername());
            prepare.setString(9,entity.getPasswword());
            prepare.setString(10, entity.getRole_name());
            status = prepare.executeUpdate();
            commitTransaction();
            prepare.close();
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
            rollbackTransaction();
            // TODO: handle exception
        }

        return status;
    }


    
}
