package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.Userbean;
import in.co.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			UserModel model = new UserModel();
			try {
				Userbean bean = model.findByPk(Integer.parseInt(id));
				// Update User jsp
				req.setAttribute("updatedata", bean);
				RequestDispatcher rd = req.getRequestDispatcher("UpdateUser.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String loginId = req.getParameter("loginId");
		String password = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Userbean bean = new Userbean();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setAddress(address);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		bean.setPassword(password);
		bean.setLoginId(loginId);
		UserModel model = new UserModel();
		try {
			if (op.equals("add")) {
				model.add(bean);
				resp.sendRedirect("LoginCtl");
			}
			if (op.equals("update")) {
				String id = req.getParameter("id");
				bean.setId(Integer.parseInt(id));
				model.update(bean);
				resp.sendRedirect("UserListCtl.do");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
