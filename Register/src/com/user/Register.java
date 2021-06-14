package com.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.connection.DBConnection;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")

@MultipartConfig
public class Register extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name=request.getParameter("user_name");
		String password=request.getParameter("user_password");
		String email=request.getParameter("user_email");
		Part part=request.getPart("image");
		String filename = part.getSubmittedFileName();
		//response.getWriter().println(filename);
		
		
		Connection con = DBConnection.getConnection();
		try {
			Thread.sleep(3000);
			String sql = "insert into register(name,password,email,imageName) values(?,?,?,?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, password);
			pst.setString(3, email);
			pst.setString(4, filename);
			
			pst.executeUpdate();
			
			//upload.......
			
			InputStream is = part.getInputStream();
			byte []data=new byte[is.available()];
			is.read(data);
			
			String path = request.getRealPath("/")+"images"+File.separator+filename;
			//response.getWriter().println(path);
			
			FileOutputStream fos=new FileOutputStream(path);
			
			fos.write(data);
			fos.close();
			
			response.getWriter().println("done");
			
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("error....");
		}
	}
	
	

}
