package in.co.rays.ctrl;

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

//Maven 
@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		if (op != null && op.equalsIgnoreCase("Logout")) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		RequestDispatcher rd = req.getRequestDispatcher("loginView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String op = req.getParameter("operation");
		String uri = req.getParameter("uri");

		if (op.equalsIgnoreCase("Login")) {
			try {
				UserModel model = new UserModel();
				UserBean bean = model.authenticate(login, pass);

				if (bean != null) {
					HttpSession session = req.getSession();
					session.setAttribute("fName", bean.getFirstName());
					// --------------------------------------------------//
					if (uri.equalsIgnoreCase("null")) {
						RequestDispatcher rd = req.getRequestDispatcher("Welcome.jsp");
						rd.forward(req, resp);
					} else {
						resp.sendRedirect(uri);
					}
				} else {
					System.out.println("invalid details");
					req.setAttribute("msg", "Invalid Login-Id or Password");
					RequestDispatcher rd = req.getRequestDispatcher("loginView.jsp");
					rd.forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (op.equalsIgnoreCase("Sign-up")) {
			resp.sendRedirect("Registration.jsp");
		}
	}
}