package in.co.rays.Ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.MarksheetModel;
import in.co.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		if (id != null) {
			UserModel model = new UserModel();
			try {
				UserBean bean = model.findByPk(Integer.parseInt(id));
				req.setAttribute("bean", bean);
				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {

				e.printStackTrace();
			}
		} else {

			resp.sendRedirect("UserRegistrationView.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String address = req.getParameter("address");
		String dob = req.getParameter("dob");
		String password = req.getParameter("password");
		UserBean bean = new UserBean();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLoginId(loginId);
		bean.setAddress(address);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setPassword(password);
		UserModel model = new UserModel();
		try {
			if (op.equals("register")) {
				model.add(bean);
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.print("Data Inserted.....");
				resp.sendRedirect("LoginView.jsp");
			}
			if (op.equals("update")) {
				HttpSession session = req.getSession();
				String id = req.getParameter("id");
				bean.setId(Integer.parseInt(id));
				model.update(bean);
				session.setAttribute("update", "Update SuccessFully");
				resp.sendRedirect("UserListCtl.do");
//				req.setAttribute("update", "Update SuccessFully");
//				RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
//				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//		if (op.equals("update")) {
//			UserModel model = new UserModel();
//			UserBean bean = new UserBean();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			String firstName = req.getParameter("firstName");
//			String lastName = req.getParameter("lastName");
//			String loginId = req.getParameter("loginId");
//			String address = req.getParameter("address");
//			String dob = req.getParameter("dob");
//			String password = req.getParameter("password");
//			String id = req.getParameter("id");
//			bean.setId(Integer.parseInt(id));
//			bean.setFirstName(firstName);
//			bean.setLastName(lastName);
//			bean.setLoginId(loginId);
//			bean.setAddress(address);
//			bean.setPassword(password);
//			bean.setPassword(password);
//			try {
//				bean.setDob(sdf.parse(dob));
//
//				model.update(bean);
//				req.setAttribute("update", "Update SuccessFully");
//				RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
//				rd.forward(req, resp);
//
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

}
