package in.co.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestRead {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		Statement st = conn.createStatement();
		ResultSet r = st.executeQuery("SELECT * FROM MARKSHEET");
		while (r.next()) {
			System.out.print("\t"+r.getInt(1));
			System.out.print("\t"+r.getString(2));
			System.out.print("\t"+r.getInt(3));
			System.out.print("\t"+r.getInt(4));
			System.out.print("\t"+r.getInt(5));
			System.out.println("\t"+r.getInt(5));
			
		}
		conn.close();
		st.close();
	}
}
