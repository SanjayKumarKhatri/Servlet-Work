package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String name=request.getParameter("user_name");
		
		response.getWriter().println("<h1>Your name is : "+name+"</h1>");
		response.getWriter().println(""
		+"<form action='Servlet2'>"
		+"<input type = 'hidden' name='user_name' value='"+name+"' />"
		+"<button>Go To Second Servlet</button>"
		+"</form>");
	}

}
