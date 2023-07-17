package in.co.rays.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TestUser {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testSearch();
		testAuthenticate();
	}

	private static void testAuthenticate() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = model.authenticate("sahu123", "1234");
		if (bean == null) {

			System.out.println("not exist");

		} else {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());
		}

	}

	private static void testSearch() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		List list = model.search(bean, 1, 5);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			bean = (UserBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		}

	}

	private static void testUpdate() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		bean.setFirstName("Aditi");
		bean.setLastName("Bajpai");
		bean.setLoginId("aditi1234");
		bean.setPassword("1234");
		bean.setAddress("sawer");
		bean.setDob(sdf.parse("12/12/2000"));
		bean.setId(3);
		model.update(bean);
	}

	private static void testAdd() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		bean.setId(3);
		bean.setFirstName("Aditi");
		bean.setLastName("Bajpai");
		bean.setLoginId("aditi123");
		bean.setPassword("1234");
		bean.setDob(sdf.parse("15/05/2003"));
		bean.setAddress("sawer");
		model.add(bean);

	}
}
