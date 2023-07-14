package in.co.rays.ctrl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/SignUpCtrl")
public class SignUpCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		String fName = req.getParameter("firstName");
		String lName = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob = req.getParameter("dob");

		UserBean bean = new UserBean();
		bean.setFirstName(fName);
		bean.setLastName(lName);
		bean.setLoginId(login);
		bean.setPassword(pass);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf.parse(dob);
			bean.setDob(d);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		if (op.equals("Register")) {
			try {
				UserModel model = new UserModel();
				model.add(bean);
				req.setAttribute("signup", "Sign-up Sucessful...Kindly Login !");
				RequestDispatcher rd = req.getRequestDispatcher("loginView.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
