package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.service.FilmDataService;

import java.io.IOException;

public class DeleteFilmServlet extends HttpServlet {

	private FilmDataService filmDataService = new FilmDataService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// удаляю строку из таблицы movie через сервис
		filmDataService.deleteFilm(Integer.parseInt(request.getParameter("film")));
		response.sendRedirect("ListFilmServlet");
	}
}