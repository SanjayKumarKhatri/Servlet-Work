package com.androjavatech4u;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class MyFirstServletApp
 */
public class MyFirstServletApp extends HttpServlet {

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().println("Hello Servlet");
		PrintWriter out = response.getWriter();
		out.println("Hello Servlet from Http");
	}

}
