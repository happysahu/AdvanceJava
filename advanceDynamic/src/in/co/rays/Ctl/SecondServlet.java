package in.co.rays.Ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;

@WebServlet(urlPatterns = { "*.ctl", "/harsh", "/rajat", "/monil", "/SecondServlet" })
public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h1>Helloooo.....!!!!!</h1>");
		req.setAttribute("name", "Harsh");

		RequestDispatcher rd = req.getRequestDispatcher("FirstServlet");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("Redirect");
		req.setAttribute("name", "Harsh");

		RequestDispatcher rd = req.getRequestDispatcher("FirstServlet");
		rd.forward(req, resp);

	}
}
