package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection conn = null;

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection makeConnection()throws SQLException {
		if (conn == null) {
			conn = DriverManager.getConnection("jdbc:postgresql://expense-reimbursement-system.cvjcx3y0oyxm.ca-central-1.rds.amazonaws.com:5432/ers", "postgres", "postgres");
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
}
