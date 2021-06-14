package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.Userdao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class EditServlet
 */
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//fetch data
		String name = request.getParameter("inputname");
		String email = request.getParameter("inputemail");
		String password = request.getParameter("inputpass");
		String about = request.getParameter("abouttextarea");
		Part part = request.getPart("image");
		String imgname = part.getSubmittedFileName();
		
		//get data from session
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentuser");
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setAbout(about);
		String oldimg = user.getProfile();
		user.setProfile(imgname);
		
		Userdao ud = new Userdao();
		boolean result = ud.UpdateUser(user);
		if(result) {
			//response.getWriter().println("Updated db");
			
			String path = request.getServletContext().getRealPath("/")+"pics"+File.separator + user.getProfile();
			System.out.println(path);
			String oldimgpath = request.getServletContext().getRealPath("/")+"pics"+File.separator + oldimg;
			if(!oldimg.equals("default.png")) {
			Helper.deleteFile(oldimgpath);
			}
			if(Helper.saveFile(part.getInputStream(), path)) {
				
				Message msg = new Message("profile updated..","success","alert-success");				
				session.setAttribute("msg", msg);
			}else {
				Message msg = new Message("Something went wrong while profile updating..","error","alert-danger");				
				session.setAttribute("msg", msg);
			}
		}else {
			Message msg = new Message("Something went wrong while profile updating..","error","alert-danger");				
			session.setAttribute("msg", msg);

		}
		
		response.sendRedirect("profile.jsp");
	}

}
