package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {
	public static void main(String[] args) throws Exception {
		//testAdd();
		//testUpdate();
		//testDelete();
		testSearch();
	}

	private static void testSearch() throws Exception {
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		List list = model.search(bean);
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
		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		bean.setName("Ronak");
		bean.setPhysics(87);
		bean.setChemistry(98);
		bean.setMaths(80);
		model.add(bean);
	}
}
