package in.co.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestTransactionHandling {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		try{
			conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO EMP VALUES(?,?,?)");
		ps.setInt(1, 9);
		ps.setString(2, "Rahu");
		ps.setInt(3, 9033);
		PreparedStatement ps1 = conn.prepareStatement("INSERT INTO EMP VALUES(?,?,?)");
		ps.setInt(1, 9);
		ps.setString(2, "Rahul");
		ps.setInt(3, 9033);
		conn.commit();
		int i = ps.executeUpdate();
		int i1 = ps.executeUpdate();
		System.out.println("data inserted" + i);
		System.out.println("data inserted" + i1);
		}catch (Exception e) {
			//conn.rollback();
			System.out.println("Data Not Inserted");
		}
	}
}
