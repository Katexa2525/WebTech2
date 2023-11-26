package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.service.FilmDataService;

import java.io.IOException;
import java.sql.SQLException;

public class ListReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDataService filmDataService = new FilmDataService();
       
    public ListReviewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("reviews", filmDataService.getReviewByFilm(Integer.parseInt(request.getParameter("film"))));
			request.getRequestDispatcher("/WEB-INF/views/list-review-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
