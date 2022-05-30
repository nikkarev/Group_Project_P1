package service;

import java.util.List;

import exception.ApplicationException;
import model.ReimbursementPojo;

public interface ReimbursementService {

	ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	
	List<ReimbursementPojo> viewEmployeeRequests(int employeeId) throws ApplicationException;
	
	List<ReimbursementPojo> managerViewEmployeeRequests(int employeeId) throws ApplicationException;
	
	List<ReimbursementPojo> viewAllRequests() throws ApplicationException;
	
	ReimbursementPojo changeRequestStatus(ReimbursementPojo reimbursementPojo) throws ApplicationException;
}
