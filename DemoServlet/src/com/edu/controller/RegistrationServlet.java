package com.edu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.da.EmployeeDAO;
import com.dao.impl.EmployeeDAOImpl;
import com.model.EmployeeModel;



//@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	EmployeeDAO  employeeDAO = new EmployeeDAOImpl();
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeModel employeeModel = new EmployeeModel();
		employeeModel.setFirstName(request.getParameter("firstName"));
		employeeModel.setLastName(request.getParameter("lastName"));
		employeeModel.setGender(request.getParameter("gender"));
		Integer row = employeeDAO.addEmployee(employeeModel);
		if (row > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("SecondServlet");
			rd.forward(request, response);
			
      } else {
			RequestDispatcher rd = request.getRequestDispatcher("ThirdServlet");
			rd.forward(request, response);

		}
		
		
		//String firstName = request.getParameter("firstName");
		//String lastName = request.getParameter("lastName");
		//String gender = request.getParameter("gender");
		
		//System.out.println("First : "+firstName);
		//System.out.println("Last : "+lastName);
		//System.out.println("Gender :"+gender);
	
		

		
	}
	
	

}
