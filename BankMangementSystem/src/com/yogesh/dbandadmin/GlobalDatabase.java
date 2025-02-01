/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.yogesh.dbandadmin;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yogesh
 */
public class GlobalDatabase {
    
    
    static Connection connection;
    static Driver driver ;
    static Statement statement;
    //static PreparedStatement preparedStatement;
    
    public static void createConnection()  {
        try {
            driver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","2345");
            statement = connection.createStatement();
            
        } catch (SQLException e) {
            System.out.println("Problem to get Connection .... !!! ");
            throw new RuntimeException(e);
        }
    }

    public static ResultSet selectQuery(String query)
    {
        try {
            ResultSet resultSet = statement.executeQuery(query);
            return  resultSet ;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void nonSelectQuery(String firstName, String middleName, String lastName, String dateOfBirth, String gender, String mobileNo, String email,  String address, String city, String division ,String district, String pinCode, String state, String aadharNumber, String accountNumber, String balance, String formatedDate) {
    
        try {
            statement = connection.createStatement();
            statement.executeUpdate("insert into account values('"+ firstName + 
                                                           "','" + middleName +
                                                           "','" + lastName +
                                                           "','" + dateOfBirth + 
                                                           "','" + gender +
                                                           "','" + mobileNo + 
                                                           "','" + email + 
                                                           "','" + address +
                                                           "','" + city +
                                                           "','" + division +
                                                           "','" + district +
                                                           "','" + pinCode +
                                                           "','" + state + 
                                                           "','" + aadharNumber + 
                                                           "','" + accountNumber +
                                                           "','" + balance +
                                                           "','" + formatedDate +
                                                            "')");
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public static void nonSelectQuery(String query)
    {
        try {
            statement = connection.createStatement();
            statement.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(GlobalDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Problem to close connection ... !!!");
            throw new RuntimeException(e);
        }
    } 
}
