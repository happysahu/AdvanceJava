package in.co.rays.bundle;

import java.sql.Connection;
import java.util.ResourceBundle;

import in.co.rays.util.JDBCDataSource;

public class TestBundel {
	public static void main(String[] args) {
		
		ResourceBundle rs = ResourceBundle.getBundle("in.co.rays.bundle.JdbcConnection");
		System.out.println(rs.getString("driver"));
		ResourceBundle rs1=ResourceBundle.getBundle("in.co.rays.bundle.app_hi");
		System.out.println(rs1.getString("greetings"));
	}
}
