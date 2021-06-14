package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tech.blog.entities.User;
import com.tech.blog.helper.DBConnection;

public class Userdao {

	
	private Connection con = DBConnection.getmeconnect();
	
	
	public boolean Saveuser(User user){
		boolean flag = false;
		try {
			
			String query = "insert into user (name,email,password,gender,about) values (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getAbout());
			pst.executeUpdate();
			flag = true;
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return flag;
		
		
	}
	
	public User getuserbyemailandpassword(String email, String password) {
		User user = null;
		try {
			
			String query = "select * from user where email = ? and password = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setAbout(rs.getString("about"));
				user.setDatetime(rs.getTimestamp("rdate"));
				user.setProfile(rs.getString("profile"));
				}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return user;
		
		
	}
	
	public boolean UpdateUser(User user) {
		
		boolean f = false;
		try {
			String query = "update user set name = ?, email = ?, password = ?, gender = ?, about = ?, profile = ? where id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getGender());
			pst.setString(5, user.getAbout());
			pst.setString(6, user.getProfile());
			pst.setInt(7, user.getId());
			pst.executeUpdate();
			f = true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return f;
		
	}
	
	public User getUserbyuserId(int userId) {
		User user = null;
		try {
			String query = "select * from user where id = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, userId);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setName(rs.getString("name"));
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setAbout(rs.getString("about"));
				user.setDatetime(rs.getTimestamp("rdate"));
				user.setProfile(rs.getString("profile"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
		
		
	}
}
