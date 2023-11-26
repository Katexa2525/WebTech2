package webapp.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginRequiredFilter implements Filter {

	@Override
	public void destroy() {	}

	@Override
	public void doFilter(ServletRequest servletRequest,	ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		if (request.getSession().getAttribute("name") != null) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			request.getRequestDispatcher("LoginServlet").forward(servletRequest,servletResponse);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}