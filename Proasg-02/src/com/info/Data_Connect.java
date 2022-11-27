package com.info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data_Connect {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        
    	Connection conn;
        try 
        {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asignment2", "root", "root");
            return conn;
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
            return null;
        }
    }
}