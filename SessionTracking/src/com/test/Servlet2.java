package com.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting all Cookies
		
		Cookie[] cookies = request.getCookies();
		
		String  name= "";
		boolean f = false;
		if (cookies == null) {
			response.getWriter().println("<h1>You are new user go to home page and submit your name</h1>");
			return;
			
		} else {
			for(Cookie c : cookies) {
				
				String tname = c.getName();
				if (tname.equals("User_name")) {
					f = true;
					
					name = c.getValue();
				}
			}
		}
		
		if(f) {
			response.getWriter().println("<h1>Hello , "+name+" welcome to my website...</h1>");
			response.getWriter().println("<h1><a href = 'Servlet2'>Go To Servlet 2</a></h1>");
			response.getWriter().println("<h1>Thank You</h1>");
	    }
		else {
			
			response.getWriter().println("<h1>You are new user go to home page and submit your name</h1>");
			
		}

	}
}
