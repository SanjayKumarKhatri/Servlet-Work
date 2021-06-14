package com.tech.blog.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.Userdao;
import com.tech.blog.entities.User;


@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String check = request.getParameter("check");
		if(check == null) {
			response.getWriter().println("please accept term and condition");
			
		}else {
			String name = request.getParameter("name");
			String email = request.getParameter("emailaddress");
			String password = request.getParameter("pass");
			String gender = request.getParameter("gender");
			String about = request.getParameter("about");
			
			User user = new User(name,email,password,gender,about);
			
			Userdao ud = new Userdao();
			if(ud.Saveuser(user)){
			response.getWriter().println("done");
			}else {

				response.getWriter().println("Email Already Register try with another");
			}
			}
	}

}
