package in.co.rays.Ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		if (op != null) {
			HttpSession session = req.getSession(true);
			System.out.println("logout: "+session.getId());
			session.invalidate();
		}
		resp.sendRedirect("LoginView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		if (op.equals("signIn")) {
			String loginId = req.getParameter("loginId");
			String password = req.getParameter("password");
			UserModel model = new UserModel();
			try {
				UserBean bean = model.authenticate(loginId, password);
				if (bean != null) {
					HttpSession session = req.getSession(true);
					System.out.println(session.getId());
					session.setAttribute("user", bean);
					resp.sendRedirect("WelcomeCtl.do");
				} else {
					req.setAttribute("msg", "Login ID & Password is Invalid");
					RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
					rd.forward(req, resp);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (op.equals("signUp")) {
			resp.sendRedirect("UserRegistrationCtl");
		}

	}

}
