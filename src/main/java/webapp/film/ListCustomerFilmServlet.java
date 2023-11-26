package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webapp.film.service.CustomerDataService;

import java.io.IOException;
import java.sql.SQLException;

public class ListCustomerFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDataService customerDataService = new CustomerDataService();
       
    public ListCustomerFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// получаю данные сессии
			HttpSession session = request.getSession();
			// получаю Id пользователя из сессии
			int custId = Integer.parseInt(session.getAttribute("customerId").toString());
			request.setAttribute("movies", customerDataService.getAllCustomerMovies(custId));
			request.getRequestDispatcher("/WEB-INF/views/list-customer-movies-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
