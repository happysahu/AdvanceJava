package in.co.rays.Ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * System.out.println("Hello"); String firstName =
		 * req.getParameter("firstName"); String lastName =
		 * req.getParameter("lastName"); String loginId = req.getParameter("loginId");
		 * String[] address = req.getParameterValues("address"); String password =
		 * req.getParameter("password"); System.out.println(firstName);
		 * System.out.println(lastName); System.out.println(loginId);
		 * System.out.println(address); System.out.println(password);
		 * 
		 * resp.setContentType("text/html");
		 * 
		 * PrintWriter out = resp.getWriter();
		 * 
		 * out.print(firstName + " " + lastName + " " + loginId + " " + password + " " +
		 * address[0] + " " + address[1]);
		 */

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		Object obj = req.getAttribute("name");
		out.print("First Do Get");
		out.print(obj);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		Object obj = req.getAttribute("name");
		
		PrintWriter out = resp.getWriter();
		out.println(obj);

		out.print("First Do Post");
	}

}
