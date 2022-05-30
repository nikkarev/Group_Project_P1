package dao;

import java.util.List;

import exception.ApplicationException;

public interface EmployeeDao {
	//employee or manager login
	EmployeePojo login(EmployeePojo employeePojo) throws ApplicationException;
	//logged in employee views their info
	EmployeePojo viewInfo(int employeeId) throws ApplicationException;
	//logged in employee updates their info
	EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException;
	//manager views all employee info
	List<EmployeePojo> getAllEmployees() throws ApplicationException;
	
}
