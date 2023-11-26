package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.model.Movie;
import webapp.film.service.FilmDataService;

import java.io.IOException;

public class AddFilmServlet extends HttpServlet {
	
	private FilmDataService filmDataService = new FilmDataService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-film-db.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String addMovie=request.getParameter("addMovie");
		String cancelMovie=request.getParameter("cancelMovie");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (addMovie != null) {
			Movie film = new Movie(request.getParameter("title"), request.getParameter("description"), 
									Integer.parseInt(request.getParameter("release_year")), Integer.parseInt(request.getParameter("duration")), 
							   Float.parseFloat(request.getParameter("price")) , request.getParameter("special_features"), 
							   Float.parseFloat(request.getParameter("average_rating")));
		
			filmDataService.insertFilm(film);
		}
		response.sendRedirect("ListFilmServlet");
	}
}