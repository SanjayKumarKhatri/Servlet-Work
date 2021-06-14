package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.getWriter().println("<h1 style='color:blue;'>Welcome To Servlet 2</h1>");
		
		String name=request.getParameter("user_name");
		
		response.getWriter().println("<h1 style='color:red;'>Welcome back "+name+"</h1>");
	}

}
