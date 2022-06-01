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
<<<<<<< HEAD
			conn = DriverManager.getConnection("jdbc:postgresql://expense-reimbursement-system.cvjcx3y0oyxm.ca-central-1.rds.amazonaws.com:5432/ers", "postgres", "postgres");
=======
<<<<<<< Updated upstream
			conn = DriverManager.getConnection("jdbc:postgresql://expense-reimbursement-system.cvjcx3y0oyxm.ca-central-1.rds.amazonaws.com/ers", "postgres", "postgres");
=======
			String connectionUrl = "jdbc:postgresql://localhost:5433/ers";
			String userName = "postgres";
			String password = "coffee";
//			conn = DriverManager.getConnection("psql --host=expense-reimbursement-system.cvjcx3y0oyxm.ca-central-1.rds.amazonaws.com --port=5432 --username=postgres");
			
			if(conn==null) {
				conn = DriverManager.getConnection(connectionUrl, userName, password);
			}
>>>>>>> Stashed changes
>>>>>>> bca6858 (a)
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
