package service;

import java.util.List;

import exception.ApplicationException;
import model.EmployeePojo;

public interface EmployeeService {

	EmployeePojo login(EmployeePojo employeePojo) throws ApplicationException;

	EmployeePojo viewInfo(int employeeId) throws ApplicationException;

	EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException;

	List<EmployeePojo> getAllEmployees() throws ApplicationException;
	
	EmployeePojo register(EmployeePojo employeePojo) throws ApplicationException;

	EmployeePojo register(EmployeePojo employeePojo) throws ApplicationException;

}
