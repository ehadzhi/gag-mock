package jdbc;

import java.sql.*;

public class ConnectionDispatcher {
	private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/" 
				+ "gagmock?autoReconnect=true&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "toor";
	private static Connection conn = null;
	
	private ConnectionDispatcher() {
	}
	
	public static Connection getConnection() {
		if (conn == null) {
			synchronized (Connection.class) {
				if (conn == null) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						return DriverManager.getConnection(DB_URL, USER, PASS);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return conn;
	}
}
