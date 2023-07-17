package in.co.rays.JDBC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcedureOUT {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		CallableStatement callstmt = conn.prepareCall("{CALL empOUT(?)}");
		callstmt.registerOutParameter(1, Types.INTEGER);
		callstmt.execute();

		System.out.println(callstmt.getInt(1));
	}
}
