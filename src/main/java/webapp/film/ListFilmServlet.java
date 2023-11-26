package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import webapp.film.service.FilmDataService;

import java.io.IOException;
import java.sql.SQLException;

public class ListFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDataService filmDataService = new FilmDataService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("movies", filmDataService.getAllFilms("SELECT * FROM movie"));
			request.getRequestDispatcher("/WEB-INF/views/list-movies-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}