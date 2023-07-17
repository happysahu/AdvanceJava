package in.co.rays.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class ProcedureIN {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		CallableStatement callstmt = conn.prepareCall("{CALL empIN(?)}");
		callstmt.setInt(1, 3);
		callstmt.execute();
		ResultSet rs = callstmt.getResultSet();
		while (rs.next()) {
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getInt(3));
		}
	}
}
