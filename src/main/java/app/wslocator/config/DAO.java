package app.wslocator.config;

import com.helger.commons.io.file.IFileFilter;
import com.mysql.cj.protocol.Resultset;

import app.wslocator.models.MainModel;

import java.sql.*;

public class DAO extends Variables {

    protected Resultset resultset;
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
