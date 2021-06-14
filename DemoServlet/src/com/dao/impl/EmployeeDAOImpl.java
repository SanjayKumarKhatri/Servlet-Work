package com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.da.EmployeeDAO;
import com.dao.connection.DBConnection;
import com.model.EmployeeModel;


public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static Connection con = DBConnection.getConnection();
	private static PreparedStatement pst;

	@Override
	public List<EmployeeModel> getAllEmployees() {
		List<EmployeeModel> employeeModels = new ArrayList<>();
		try {
			
			pst = con.prepareStatement("select * from employee");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
			EmployeeModel employeeModel = new EmployeeModel();
			employeeModel.setFirstName(rs.getString("first_name"));
			employeeModel.setLastName(rs.getString("last_name"));
			employeeModel.setGender(rs.getNString("gender"));
			employeeModels.add(employeeModel);
			
			
		  }
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return employeeModels;
	}

	@Override
	public Integer addEmployee(EmployeeModel employeeModel) {
	Integer row = 0;
		
	try {
		pst = con.prepareStatement("insert into employee(first_name,last_name,gender) values(?,?,?)");
		pst.setString(1, employeeModel.getFirstName());
		pst.setString(2, employeeModel.getLastName());
		pst.setString(3, employeeModel.getGender());
	    row =  pst.executeUpdate();
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		return row;
	}

}
