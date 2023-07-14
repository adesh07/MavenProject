package in.co.rays.ctrl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "FrontCtrl", urlPatterns = { "*.do" })
public class FrontCtrl implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// ---------------------------------------------------------------------------------//
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String uri = req.getRequestURI();

		if (session.getAttribute("fName") == null) {
			request.setAttribute("msg", "Session Expired...Login again !");
			req.setAttribute("uri", uri);

			RequestDispatcher rd = req.getRequestDispatcher("loginView.jsp");
			rd.forward(req, resp);
		} else {
			chain.doFilter(request, response);
		}
		// ----------------------------------------------------------------------------------//
	}

	@Override
	public void destroy() {

	}

}
