package in.co.rays.Marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		// testAdd();
		// testUpdate();
		// testDelete();
		// searchByRoll();
		testSearch();
	}

	private static void testSearch() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		//bean.setName("r");
		//bean.setRollNo(102);
		List list = model.search(bean,2,5);
		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getRollNo());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());
		}
	}

	private static void testDelete() throws Exception {

		MarksheetModel.delete(13);

	}

	private static void searchByRoll() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = model.searchByRoll(101);

		if (bean == null) {

			System.out.println("not exist");

		} else {

			System.out.println(bean.getId());
			System.out.println(bean.getName());
			System.out.println(bean.getRollNo());
			System.out.println(bean.getPhysics());
			System.out.println(bean.getChemistry());
			System.out.println(bean.getMaths());

		}

	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(10);
		bean.setName("Shivan");
		bean.setRollNo(112);
		bean.setPhysics(67);
		bean.setChemistry(74);
		bean.setMaths(97);
		MarksheetModel m = new MarksheetModel();
		m.update(bean);

	}

	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(13);
		bean.setName("Mehul");
		bean.setRollNo(113);
		bean.setPhysics(65);
		bean.setChemistry(63);
		bean.setMaths(96);
		MarksheetModel model = new MarksheetModel();
		model.add(bean);

	}
}
