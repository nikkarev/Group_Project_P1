package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import exception.ApplicationException;
import model.ReimbursementPojo;

public class ReimbursementServiceImpl implements ReimbursementService{

	private static final Logger LOG = LogManager.getLogger(ReimbursementServiceImpl.class);

	ReimbursementDao reimbursementDao;

	public ReimbursementServiceImpl() {
		this.reimbursementDao = new ReimbursementDaoImpl();
	}

	@Override
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		LOG.info("Entered submitRequest() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.submitRequest(reimbursementPojo);
		LOG.info("Exited submitRequest() in service.");
		return returnReimbursementPojo;
	}

	@Override
	public List<ReimbursementPojo> viewEmployeeRequests(int employeeId) throws ApplicationException {
		LOG.info("Entered viewEmployeeRequests() in service.");
		List<ReimbursementPojo> viewAllEmployee = this.reimbursementDao.viewEmployeeRequests(employeeId);
		LOG.info("Exited viewEmployeeRequests() in service.");
		return viewAllEmployee;
	}

	@Override
	public List<ReimbursementPojo> managerViewEmployeeRequests(int employeeId) throws ApplicationException {
		LOG.info("Entered managerViewEmployeeRequests() in service.");
		List<ReimbursementPojo> managerViewEmployee = this.reimbursementDao.managerViewEmployeeRequests(employeeId);
		LOG.info("Exited managerViewEmployeeRequests() in service.");
		return managerViewEmployee;
	}

	@Override
	public List<ReimbursementPojo> viewAllRequests() throws ApplicationException {
		LOG.info("Entered viewAllRequests() in service.");
		List<ReimbursementPojo> viewAllRequestsList = this.reimbursementDao.viewAllRequests();
		LOG.info("Exited viewAllRequests() in service.");
		return viewAllRequestsList;
	}

	@Override
	public ReimbursementPojo changeRequestStatus(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		LOG.info("Entered changeRequestStatus() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.changeRequestStatus(reimbursementPojo);
		LOG.info("Exited changeRequestStatus() in service.");
		return returnReimbursementPojo;
	}

	@Override
	public List<ReimbursementPojo> viewAllResolvedRequests() throws ApplicationException {
		LOG.info("Entered viewAllRequests() in service.");
		List<ReimbursementPojo> viewAllRequestsList = this.reimbursementDao.viewAllResolvedRequests();
		LOG.info("Exited viewAllRequests() in service.");
		return viewAllRequestsList;
	}



}
