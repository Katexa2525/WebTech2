package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.service.ActorDataService;

import java.io.IOException;
import java.sql.SQLException;

/** Servlet implementation class ListActorServlet */
public class ListActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ActorDataService actorDataService = new ActorDataService();
       
    public ListActorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("actors", actorDataService.getAllActors("SELECT * FROM actor"));
			request.getRequestDispatcher("/WEB-INF/views/list-actor-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
