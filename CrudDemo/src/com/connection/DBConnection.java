package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
private static Connection con;
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            if (con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/usindh", "root", "root");
                System.out.println("Connection Established");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return con;
    }
}
