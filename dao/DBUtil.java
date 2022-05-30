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
		
		// this method is static so that we can call the method with 
		// the class name
		public static Connection makeConnection()throws SQLException {
			// implemented singleton pattern here
			if (conn == null) {
					conn = DriverManager.getConnection("psql --host=expense-reimbursement-system.cvjcx3y0oyxm.ca-central-1.rds.amazonaws.com --port=5432 --username=postgres");
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
