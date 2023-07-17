package in.co.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class testupdate {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		Statement st = c.createStatement();
		int i = st.executeUpdate("insert into marksheet values (12,'raam', 112,87,87,66)");
		System.out.println("database updated=" + i);
	}

}
