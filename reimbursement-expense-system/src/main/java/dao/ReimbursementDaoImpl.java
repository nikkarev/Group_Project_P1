package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import model.ReimbursementPojo;
import service.ReimbursementServiceImpl;

public class ReimbursementDaoImpl implements ReimbursementDao {
	
	private static final Logger LOG = LogManager.getLogger(ReimbursementServiceImpl.class);

	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		// Reimbursement_id gets generated automatically

		LOG.info("Entered submitRequest() in Dao.");
		try {
			Connection conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO reimbursement(employee_id, manager_id, status, amount, reason) VALUES("+reimbursementPojo.getEmployeeId()+","
					+reimbursementPojo.getManagerId()+",'pending',"+reimbursementPojo.getAmount()+",'"+reimbursementPojo.getReason()+"') returning reimbursement_id";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			reimbursementPojo.setReimbursementId(rs.getInt(1));
		}catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("Exited submitRequest() in Dao.");
		return reimbursementPojo;
	}

	public List<ReimbursementPojo> viewEmployeeRequests(int employeeId) throws ApplicationException {

		LOG.info("Entered viewEmployeeRequests() in Dao.");
		
		List<ReimbursementPojo> employeeGetsRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "SELECT * FROM reimbursement WHERE employee_id="+employeeId;
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6));

				employeeGetsRequests.add(reimbursementPojo);
			}
		}catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("Exited viewEmployeeRequests() in Dao.");
		return employeeGetsRequests;
	}

	public List<ReimbursementPojo> managerViewEmployeeRequests(int employeeId) throws ApplicationException {

		LOG.info("Entered managerViewEmployeeRequests() in Dao.");
		
		List<ReimbursementPojo> managerGetsRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "SELECT * FROM reimbursement WHERE employee_id="+employeeId;
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6));

				managerGetsRequests.add(reimbursementPojo);
			}
		}catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("Exited managerViewEmployeeRequests() in Dao.");
		return managerGetsRequests;
	}

	public List<ReimbursementPojo> viewAllRequests() throws ApplicationException {

		LOG.info("Entered viewAllRequests() in Dao.");
		
		List<ReimbursementPojo> allRequests = new ArrayList<ReimbursementPojo>();

		Statement stmt;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "SELECT * FROM reimbursement";
			ResultSet rs = stmt.executeQuery(query);

			while(rs.next()) {
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getDouble(5), rs.getString(6));

				allRequests.add(reimbursementPojo);
			}
		}catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("Exited viewAllRequests() in Dao.");
		return allRequests;
	}

	public ReimbursementPojo changeRequestStatus(ReimbursementPojo reimbursementPojo) throws ApplicationException {

		LOG.info("Entered changeRequestStatus() in Dao.");
		
		try {

			Connection conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE reimbursement SET status='"+reimbursementPojo.getStatus()+"' WHERE reimbursement_id="+reimbursementPojo.getReimbursementId();
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("Exited changeRequestStatus() in Dao.");
		return reimbursementPojo;
	}


}
