package com.tech.blog.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.Userdao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String useremail = request.getParameter("email");
		String userpass = request.getParameter("password");
		
		Userdao ud = new Userdao();
		User user = ud.getuserbyemailandpassword(useremail, userpass);
		
		if(user == null) {
			Message msg = new Message("Invalid Details ! try with another","error","alert-danger");
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
			response.sendRedirect("login.jsp");
		}else {
			HttpSession s = request.getSession();
			s.setAttribute("currentuser",user);
			response.sendRedirect("profile.jsp");
			
		}
	}

}
