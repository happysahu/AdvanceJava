package in.co.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		Statement st = conn.createStatement();
		int i=st.executeUpdate("INSERT INTO MARKSHEET VALUES(11,'URVASHI',111,67,87,98)");
		if (i==1) {
			System.out.println("Data Inserted");
		} else {
			System.out.println("Not Insert");
		}
	}
}
