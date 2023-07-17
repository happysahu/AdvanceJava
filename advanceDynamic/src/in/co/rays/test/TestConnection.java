package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import in.co.rays.util.JDBCDataSource;

public class TestConnection {
	public static void main(String[] args) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM MARKSHEET");
		ResultSet r = ps.executeQuery();
		while (r.next()) {
			System.out.print("\t" + r.getInt(1));
			System.out.print("\t" + r.getString(2));
			System.out.print("\t" + r.getInt(3));
			System.out.print("\t" + r.getInt(4));
			System.out.print("\t" + r.getInt(5));
			System.out.println("\t" + r.getInt(5));

		}

		// Test ResourcsBundle
//		ResourceBundle rs=ResourceBundle.getBundle("in.co.rays.bundle.JdbcConnection");
//		System.out.println(rs.getString("driver"));
	}
}
