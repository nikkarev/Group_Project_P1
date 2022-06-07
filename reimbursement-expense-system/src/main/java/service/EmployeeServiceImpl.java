package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ApplicationException;
import model.EmployeePojo;
import model.ReimbursementPojo;

public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOG = LogManager.getLogger(EmployeeServiceImpl.class);

	EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
		this.employeeDao = new EmployeeDaoImpl();
	}

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
		List<EmployeePojo> allEmployees = this.employeeDao.getAllEmployees();
		LOG.info("Exited getAllEmployees() in service.");
		return allEmployees;
	}

	@Override
	public EmployeePojo register(EmployeePojo employeePojo) throws ApplicationException {
		LOG.info("Entered register() in service.");
		EmployeePojo registerPojo = this.employeeDao.register(employeePojo);
		//ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.submitRequest(reimbursementPojo);
		LOG.info("Exited register() in service.");
		return registerPojo;
	}
<<<<<<< HEAD
	
	
=======

>>>>>>> 6ad9081 (pulling changes)

}
