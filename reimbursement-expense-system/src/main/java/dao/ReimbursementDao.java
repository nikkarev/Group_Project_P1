package dao;

import java.util.List;

import exception.ApplicationException;
import model.ReimbursementPojo;

public interface ReimbursementDao {

	// employee submits a request
	ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException;

	// employee views their pending, approved and denied requests/manager views a
	// specific employees requests
	List<ReimbursementPojo> viewEmployeeRequests(int employeeId) throws ApplicationException;

	// manager views a specific employees requests
	List<ReimbursementPojo> managerViewEmployeeRequests(int employeeId) throws ApplicationException;

	// manager views all pending requests
	List<ReimbursementPojo> viewAllRequests() throws ApplicationException;

	// manager approves or denies a request
	ReimbursementPojo changeRequestStatus(ReimbursementPojo reimbursementPojo) throws ApplicationException;

	// manager view resolved requests
	List<ReimbursementPojo> viewAllResolvedRequests() throws ApplicationException;

}
