package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		//response.setContentType("text/html");
		
		response.getWriter().println("<h1>Hello , "+name+" welcome to my website...</h1>");
		response.getWriter().println("<h1><a href = 'Servlet2'>Go To Servlet 2</a></h1>");
		
		
		
		// Create Cookie
		Cookie c = new Cookie("User_name", name);
		response.addCookie(c);
	}
	
	
	
	

}
