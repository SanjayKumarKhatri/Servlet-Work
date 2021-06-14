package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.da.UserDAO;
import com.dao.connection.DBConnection;
import com.model.UserModel;

public class UserDAOImpl implements UserDAO{
	private static Connection con = DBConnection.getConnection();
	private static PreparedStatement pst;

	@Override
	public Boolean login(UserModel userModel) {
		Boolean loginUser = false;
		try {
			pst = con.prepareStatement("select * from user where username = ? and password = ?");
			pst.setString(1, userModel.getUsername());
			pst.setString(2, userModel.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				loginUser = true;	
			}else {
				loginUser = false;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginUser;
	
	}

}
