package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.ApplicationException;

public class ReimbursementDaoImpl implements ReimbursementDao {

	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		// Reimbursement_id gets generated automatically
		
				try {
					Connection conn = DBUtil.makeConnection();
					Statement stmt = conn.createStatement();
					String query = "INSERT INTO reimbursement(employee_id, manager_id, status, ammount, reason) VALUES("+reimbursementPojo.getEmployeeId()+","
					+reimbursementPojo.getManagerId+",'pending',"+reimbursementPojo.getAmount()+",'"+reimbursementPojo.getReason()+"') returning reimbursement_id";
					ResultSet rs = stmt.executeQuery(query);
					rs.next();
					reimbursementPojo.setReimbursementId(rs.getInt(1));
				}catch (SQLException e) {
					throw new ApplicationException(e.getMessage());
				}
				return reimbursementPojo;;
	}

	public List<ReimbursementPojo> viewEmployeeRequests(int employeeId) throws ApplicationException {
		
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
		return employeeGetsRequests;
	}

	public List<ReimbursementPojo> managerViewEmployeeRequests(int employeeId) throws ApplicationException {
		
		List<ReimbursementPojo> managerGetsRequests = new ArrayList<ReimbursementPojo>();
		
		Statement stmt;
		try {
			Connection conn = DBUtil.makeConnection;
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
		return managerGetsRequests;
	}

	public List<ReimbursementPojo> viewAllRequests() throws ApplicationException {
		
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
		return allRequests;
	}

	public ReimbursementPojo changeRequestStatus(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		
		try {
			
			Connection conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE reimbursement SET status='"+reimbursementPojo.getStatus()+"' WHERE reimbursement_id="+reimbursementPojo.getReimbursementId();
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return reimbursementPojo;
	}



}
