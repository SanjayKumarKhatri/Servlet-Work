package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.DBConnection;


/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		String uemail=request.getParameter("uemail");
		String uphone=request.getParameter("uphone");
		
		Connection connection=DBConnection.getConnection();
		try {
			PreparedStatement pst = connection.prepareStatement("insert into registraction values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, upass);
			pst.setString(3, uemail);
			pst.setString(4, uphone);
			int i=pst.executeUpdate();
			if (i>0)
				response.getWriter().println(" data inserted");
			else 
				response.getWriter().println("data not inserted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
