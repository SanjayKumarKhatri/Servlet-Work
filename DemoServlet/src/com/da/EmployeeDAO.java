package com.da;

import java.util.List;

import com.model.EmployeeModel;

public interface EmployeeDAO {
	
	List<EmployeeModel> getAllEmployees();
	Integer addEmployee(EmployeeModel employeeModel);

}
