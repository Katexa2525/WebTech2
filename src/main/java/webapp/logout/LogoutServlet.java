package webapp.logout;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		//request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
		// удаляю сессионные переменные при Logout
		request.getSession().removeAttribute("name");
		request.getSession().removeAttribute("isAdmin");
		request.getSession().removeAttribute("customerId");
		//
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}