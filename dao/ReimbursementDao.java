package dao;

import java.util.List;

import exception.ApplicationException;

public interface ReimbursementDao {
	//employee submits a request
	ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	//employee views their pending, approved and denied requests/manager views a specific employees requests
	List<ReimbursementPojo> viewEmployeeRequests(int employeeId) throws ApplicationException;
	//manager views a specific employees requests
	List<ReimbursementPojo> managerViewEmployeeRequests(int employeeId) throws ApplicationException;
	//manager views all pending, denied, and resolved requests
	List<ReimbursementPojo> viewAllRequests() throws ApplicationException;
	//manager approves or denies a request
	ReimbursementPojo changeRequestStatus(ReimbursementPojo reimbursementPojo) throws ApplicationException;
	
}
