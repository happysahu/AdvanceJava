package in.co.rays.Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	public void add(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		PreparedStatement ps = conn.prepareStatement("INSERT INTO MARKSHEET VALUES(?,?,?,?,?,?)");
		ps.setInt(1, bean.getId());
		ps.setString(2, bean.getName());
		ps.setInt(3, bean.getRollNo());
		ps.setInt(4, bean.getPhysics());
		ps.setInt(5, bean.getChemistry());
		ps.setInt(6, bean.getMaths());
		int i = ps.executeUpdate();
		System.out.println("Inserted " + i);
	}

	public void update(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		PreparedStatement ps = conn
				.prepareStatement("UPDATE MARKSHEET SET NAME=?,ROLL_NO=?,PHYSICS=?,CHEMISTRY=?,MATHS=? WHERE ID=?");
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getRollNo());
		ps.setInt(3, bean.getPhysics());
		ps.setInt(4, bean.getChemistry());
		ps.setInt(5, bean.getMaths());
		ps.setInt(6, bean.getId());
		int i = ps.executeUpdate();
		System.out.println("Updated " + i);
	}

	public static void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		PreparedStatement ps = conn.prepareStatement("DELETE FROM MARKSHEET WHERE ID=?");
		ps.setInt(1, id);
		int i = ps.executeUpdate();
		System.out.println("Deleted " + i);
	}

	public MarksheetBean searchByRoll(int roll) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM MARKSHEET WHERE ROLL_NO=?");
		ps.setInt(1, roll);
		ResultSet rs = ps.executeQuery();

		MarksheetBean bean = null;
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

		}
		return bean;
	}

	public List search(MarksheetBean bean, int pageNumber,int pageSize) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/harsh", "root", "root");
		StringBuffer sb = new StringBuffer("SELECT * FROM MARKSHEET where 1=1");
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {

				sb.append(" and name like '" + bean.getName() + "%'");

			}
			if (bean.getRollNo() > 0) {

				sb.append(" and Roll_No = '" + bean.getRollNo() + "'");

			}
		}
		if (pageSize > 0) {
			pageNumber = (pageNumber - 1) * pageSize;
			sb.append(" limit "+pageNumber+","+pageSize);
		}
		System.out.println(sb);
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		ResultSet rs = ps.executeQuery();
		ArrayList list = new ArrayList();
		while (rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);

		}

		return list;

	}
}
