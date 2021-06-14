package com.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.da.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.model.UserModel;


//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	UserDAO userDAO = new UserDAOImpl();
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UserModel userModel = new UserModel();
		String username = request.getParameter("userName");
		String password = request.getParameter("pass");
		System.out.println(username + " " + password);
		
		userModel.setUsername(username);
		userModel.setPassword(password);
		System.out.println(userModel);
		Boolean loginUser = userDAO.login(userModel);
		if (loginUser == true) {
			response.getWriter().println("<h1> Login Successful </h1>");
			RequestDispatcher rd  = request.getRequestDispatcher("/registration.html");
			rd.forward(request, response);
		} else {
			response.getWriter().println("<h1> Username Password Incorrect </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/login.html");
			rd.include(request, response);
		}
		
	}

}
