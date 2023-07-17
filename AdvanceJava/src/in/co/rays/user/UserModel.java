package in.co.rays.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserModel {

	public UserBean authenticate(String login, String pass) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM USER WHERE LOGIN_ID= ? AND PASSWORD =?");
		ps.setString(1, login);
		ps.setString(2, pass);
		System.out.println(ps);
		ResultSet rs = ps.executeQuery();
		UserBean bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(new java.sql.Date(rs.getDate(6).getTime()));
			bean.setAddress(rs.getString(7));
		}
		return bean;
	}

	public List search(UserBean bean, int pageNumber, int pageSize) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		StringBuffer sb = new StringBuffer("SELECT * FROM USER WHERE 1=1");
		if (pageSize > 0) {
			pageNumber = (pageNumber - 1) * pageSize;
			sb.append(" limit " + pageNumber + "," + pageSize);
		}
		System.out.println(sb);
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		bean = null;
		while (rs.next()) {
			bean = new UserBean();
			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setLoginId(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setDob(new java.sql.Date(rs.getDate(6).getTime()));
			bean.setAddress(rs.getString(7));
			list.add(bean);
		}
		return list;
	}

	public Integer nextPk() throws Exception {
		int pk = 0;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT MAX(ID) FROM USER");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;
	}

	public void add(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		PreparedStatement ps = conn.prepareStatement("INSERT INTO USER VALUES(?,?,?,?,?,?,?)");
		ps.setInt(1, nextPk());
		ps.setString(2, bean.getFirstName());
		ps.setString(3, bean.getLastName());
		ps.setString(4, bean.getLoginId());
		ps.setString(5, bean.getPassword());
		ps.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(7, bean.getFirstName());
		int i = ps.executeUpdate();
		System.out.println("Data Inserted" + i);
	}

	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE USER SET first_Name = ?,last_Name = ?,login_Id = ?,password = ?,dob = ?,address =? where id =?");
		ps.setString(1, bean.getFirstName());
		ps.setString(2, bean.getLastName());
		ps.setString(3, bean.getLoginId());
		ps.setString(4, bean.getPassword());
		ps.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		ps.setString(6, bean.getAddress());
		ps.setInt(7, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Data Updated " + i);
	}

}
