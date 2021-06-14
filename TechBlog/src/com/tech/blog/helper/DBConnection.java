package com.tech.blog.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
static Connection con;
	private DBConnection() {
		
	}
	
public static Connection getmeconnect(){
        
        if(con == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/techblog","root","root");
                //System.out.println("Connection Created");
            } catch (ClassNotFoundException | SQLException ex) {
               ex.printStackTrace();
            }
        }
        return con;
    }

}
