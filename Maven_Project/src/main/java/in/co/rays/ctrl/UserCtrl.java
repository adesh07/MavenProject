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

@WebServlet("/UserCtrl.do")
public class UserCtrl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		UserModel model = new UserModel();
		try {
			UserBean bean = model.findByPk(Integer.parseInt(id));
			req.setAttribute("bean", bean);
			RequestDispatcher rd = req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String op = req.getParameter("operation");
		String id = req.getParameter("id");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob = req.getParameter("dob");

		UserBean bean = new UserBean();
		bean.setFirstName(firstName);
		bean.setLastName(lastName);
		bean.setLoginId(login);
		bean.setPassword(pass);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = sdf.parse(dob);
			bean.setDob(d);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		UserModel model = new UserModel();

		if (op.equals("update")) {
			bean.setId(Integer.parseInt(id));
			try {
				model.update(bean);
				resp.sendRedirect("UserListCtrl.do");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
