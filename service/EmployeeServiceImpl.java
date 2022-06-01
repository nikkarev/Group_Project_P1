package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ApplicationException;
import model.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService{
	
	private static final Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);

	EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		this.employeeDao = new EmployeeDaoImpl();
	}

	// NEED TO BE REVISE
	@Override
	public EmployeePojo login(EmployeePojo employeePojo) throws ApplicationException {
		LOG.info("Entered login() in service.");
		EmployeePojo returnEmployeePojo = this.employeeDao.login(employeePojo);
		LOG.info("Exited login() in service."); 
		return returnEmployeePojo;
	}

	@Override
	public EmployeePojo viewInfo(int employeeId) throws ApplicationException {
		LOG.info("Entered viewInfo() in service.");
		EmployeePojo returnEmployeePojo = this.employeeDao.viewInfo(employeeId);
		LOG.info("Exited viewInfo() in service.");
		return returnEmployeePojo;
	}

	@Override
	public EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException {
		LOG.info("Entered updateInfo() in service.");		
		EmployeePojo returnEmployeePojo = this.employeeDao.updateInfo(employeePojo);
		LOG.info("Exited updateInfo() in service.");
		return returnEmployeePojo;
	}

	@Override
	public List<EmployeePojo> getAllEmployees() throws ApplicationException {
		LOG.info("Entered getAllEmployees() in service.");	
		List<EmployeePojo> returnAllEmployee = this.employeeDao.getAllEmployees();
		LOG.info("Exited getAllEmployees() in service.");
		return null;
	}

}
