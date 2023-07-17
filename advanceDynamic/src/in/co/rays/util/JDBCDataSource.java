package in.co.rays.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCDataSource {

	// JDBC Datasource static object
	private static JDBCDataSource jds = null;

	// C3P0 database connection pool
	private ComboPooledDataSource ds = null;

	public JDBCDataSource() {
		try {

			ResourceBundle rs = ResourceBundle.getBundle("in.co.rays.bundle.JdbcConnection");
			// Create data source
			ds = new ComboPooledDataSource();
			// Set DS properties
			ds.setDriverClass(rs.getString("driver"));
			ds.setJdbcUrl(rs.getString("url"));
			ds.setUser(rs.getString("user"));
			ds.setPassword(rs.getString("password"));
			ds.setInitialPoolSize(Integer.parseInt(rs.getString("initial")));
			ds.setAcquireIncrement(Integer.parseInt(rs.getString("acquire")));
			ds.setMaxPoolSize(Integer.parseInt(rs.getString("maximum")));
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	// get singleton class instance
	public static JDBCDataSource getInstance() {
		if (jds == null) {
			jds = new JDBCDataSource();
		}
		return jds;
	}

	// get connection from DCP
	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}

	// Close connection
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Close connection
	public static void closeConnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}

	// Close connection
	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);
	}
}
