package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.ApplicationException;

public class EmployeeDaoImpl implements EmployeeDao{

	public EmployeePojo login(EmployeePojo employeePojo) throws ApplicationException {
		
		return null;
	}

	public EmployeePojo viewInfo(int employeeId) throws ApplicationException {
		
		Statement stmt;
		EmployeePojo employeePojo = null;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "SELECT * FROM employee WHERE employee_id="+employeeId;
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				employeePopjo = new EmployeePojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(6), rs.getString(7), rs.getBoolean(8));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return employeePojo;
	}

	public EmployeePojo updateInfo(EmployeePojo employeePojo) throws ApplicationException {
		
		try {
			Connection conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE employee SET (first_name, last_name, email, user_name, password)=(" + employeePojo.getFirstName() + "," + employeePojo.getLastName() 
			+ "," + employeePojo.getEmail() + "," + employeePojo.getUserName() + "," + employeePojo.getPassword() + ") WHERE employee_id=" + employeePojo.getEmployeeId();
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return employeePojo;
	}

	public List<EmployeePojo> getAllEmployees() throws ApplicationException {
		
		List<EmployeePojo> allEmployees = new ArrayList<EmployeePojo>();
		
		Statement stmt;
		try {
			Connection conn = DBUtil.makeConnection();
			stmt = conn.createStatement();
			String query = "SELECT * FROM employee WHERE manager_type=false";
			ResultSet rs = = stmt.executeQuery(query);
			
			while(rs.next()) {
				EmployeePojo employeePojo = new EmployeePojo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
				allEmployees.add(employeePojo);
			}
		}catch(SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		return allEmployees;
	}


}
