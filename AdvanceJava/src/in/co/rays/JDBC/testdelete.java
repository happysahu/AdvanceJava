package in.co.rays.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class testdelete {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh ", "root", "root");
		Statement s = c.createStatement();
		int i = s.executeUpdate("delete from marksheet where id = 12");
		System.out.println("database updates"+i);
	}

}
