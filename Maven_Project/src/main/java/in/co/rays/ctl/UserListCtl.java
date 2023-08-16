package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.Userbean;
import in.co.rays.model.UserModel;

@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserModel model = new UserModel();
		Userbean bean = null;
		int pageNumber = 1;
		int pageSize = 5;
		try {
			List list = model.search(bean, pageNumber, pageSize);
			List newlist = model.search(bean, pageNumber + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("newList", newlist.size());
			// send to jsp pageNo=1
			req.setAttribute("pageNumber", pageNumber);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int pageNumber;
		int pageSize = 5;
		pageNumber = Integer.parseInt(req.getParameter("pageNo"));
		String op = req.getParameter("operation");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Userbean bean = new Userbean();
		UserModel model = new UserModel();
		if (op.equals("delete")) {
			String id=req.getParameter("id");
			try {
				model.delete(Integer.parseInt(id));
//				resp.sendRedirect("UserListCtl");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (op.equals("next")) {
			pageNumber++;
		}
		if (op.equals("previous")) {
			pageNumber--;
		}
		if (op.equals("search")) {

			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String dob = req.getParameter("dob");

			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			if (!(dob.equals(""))) {

				try {
					bean.setDob(sdf.parse(dob));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		try {
			List list = model.search(bean, pageNumber, pageSize);
			List newlist = model.search(bean, pageNumber + 1, pageSize);
			req.setAttribute("list", list);
			req.setAttribute("newList", newlist.size());
			// send to jsp pageNumber++
			req.setAttribute("pageNumber", pageNumber);
			RequestDispatcher rd = req.getRequestDispatcher("UserListView.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
