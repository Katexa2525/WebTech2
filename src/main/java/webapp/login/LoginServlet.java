package webapp.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.model.Customer;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService userValidationService = new LoginService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean isUserValid = userValidationService.isUserValid(name, password);

		if (isUserValid) {
			// если авторизация пройдена, то записываю в куки и атрибуты сессии
			//Cookie cookie = new Cookie("name", name);
	        //response.addCookie(cookie);
	        
			Customer customer = userValidationService.GetUserValid(name, password);
			
			// записываю в сессию пользователя данные по пользователю, чтобы можно было получить их
			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("isAdmin", customer.getIsAdmin());
			request.getSession().setAttribute("customerId", customer.getCustomerId());
			
			response.sendRedirect("ListFilmServlet");
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials!");
			//request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}