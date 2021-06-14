package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Posts;
import com.tech.blog.entities.User;
import com.tech.blog.helper.Helper;
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		String pTitle = request.getParameter("Ptitle");
		String pContent = request.getParameter("Pcontent");
		String pCode = request.getParameter("Pcode");
		Part part = request.getPart("pic");
		
		//getting current userid
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentuser");
		Posts posts = new Posts(pTitle,pContent,pCode,part.getSubmittedFileName(),null,cid,user.getId());
		PostDao pd = new PostDao();
		if(pd.savePost(posts)) {
			String path = request.getServletContext().getRealPath("/")+"blogpic"+File.separator + part.getSubmittedFileName();
			Helper.saveFile(part.getInputStream(), path);
			response.getWriter().println("done");
			
		}else {
			response.getWriter().println("Error");
			
		}
	
		
	}

}
