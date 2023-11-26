package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import webapp.film.model.Customer;
import webapp.film.model.Movie;
import webapp.film.model.MovieCustomer;
import webapp.film.service.CustomerDataService;
import webapp.film.service.FilmDataService;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class BuyFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDataService filmDataService = new FilmDataService();
	private CustomerDataService customerDataService = new CustomerDataService();
       
    public BuyFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("film", filmDataService.getFilmById(Integer.parseInt(request.getParameter("film"))));
			request.getRequestDispatcher("/WEB-INF/views/edit-buy-film-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String buyMovie=request.getParameter("buyMovie");
		String cancelMovie=request.getParameter("cancelMovie");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (buyMovie != null) {
			// получаю данные сессии
			HttpSession session = request.getSession();
			// получаю Id пользователя из сессии
			int custId = Integer.parseInt(session.getAttribute("customerId").toString());
			// получаю данные по пользователю
			try {
				Customer customer = customerDataService.getCustomerById(custId);
				Float price = Float.parseFloat(request.getParameter("price"));
				Float finalPrice = price - ((price/100) * customer.getDiscount());

				// сохраняю строку из таблицы movie через сервис
				/*Movie film = new Movie(Integer.parseInt(request.getParameter("movie_id")), request.getParameter("title"), request.getParameter("description"), 
					   			   	   Integer.parseInt(request.getParameter("release_year")), Integer.parseInt(request.getParameter("duration")), 
					   			   	   Float.parseFloat(request.getParameter("price")) , request.getParameter("special_features"), 
					   			   	   Float.parseFloat(request.getParameter("average_rating")));
				*/
				MovieCustomer movieCustomer = new MovieCustomer(customer.getCustomerId(), Integer.parseInt(request.getParameter("movie_id")),
																finalPrice, LocalDate.now().toString());

				filmDataService.insertCustomerFilm(movieCustomer);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		response.sendRedirect("ListFilmServlet");
	}

}
