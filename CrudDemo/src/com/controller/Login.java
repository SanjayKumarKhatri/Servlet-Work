package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("uemail");
		String upass = request.getParameter("upass");
		response.setContentType("text/html");
		
		Connection con = DBConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement("Select * from registraction where email=? and password=? ");
			pst.setString(1, uemail);
			pst.setString(2, upass);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				response.sendRedirect("Welcom.html");
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				response.getWriter().println("Invalid User email and password");
				rd.include(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
