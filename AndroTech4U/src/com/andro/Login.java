package com.andro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.DBConnection;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uemail=request.getParameter("uemail");
	    String upass=request.getParameter("upass");
	    response.setContentType("text/html");
	    
	    Connection connection=DBConnection.getConnection();
	    try {
			PreparedStatement pst = connection.prepareStatement("select * from registraction where email=? and password=?");
			pst.setString(1, uemail);
			pst.setString(2, upass);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				
				response.sendRedirect("Welcome.html");
				//RequestDispatcher rd = request.getRequestDispatcher("Welcome.html");
				//response.getWriter().println("Invalid user name or pass");
				//rd.forward(request, response);
			}
				
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				response.getWriter().println("Invalid user name or pass");
				rd.include(request, response);
				
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
