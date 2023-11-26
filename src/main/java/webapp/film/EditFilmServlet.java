package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.model.Movie;
import webapp.film.service.FilmDataService;

import java.io.IOException;
import java.sql.SQLException;

public class EditFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FilmDataService filmDataService = new FilmDataService();
       
    public EditFilmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("film", filmDataService.getFilmById(Integer.parseInt(request.getParameter("film"))));
			request.getRequestDispatcher("/WEB-INF/views/edit-film-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveMovie=request.getParameter("saveMovie");
		String cancelMovie=request.getParameter("cancelMovie");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (saveMovie != null) {
			// сохраняю строку из таблицы movie через сервис
			Movie film = new Movie(Integer.parseInt(request.getParameter("movie_id")), request.getParameter("title"), request.getParameter("description"), 
				   			   	   Integer.parseInt(request.getParameter("release_year")), Integer.parseInt(request.getParameter("duration")), 
				   			   	   Float.parseFloat(request.getParameter("price")) , request.getParameter("special_features"), 
				   			   	   Float.parseFloat(request.getParameter("average_rating")));

			filmDataService.updateFilm(film);
		}
		response.sendRedirect("ListFilmServlet");
	}

}
