package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.model.Actor;
import webapp.film.service.ActorDataService;

import java.io.IOException;

public class AddActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActorDataService actorDataService = new ActorDataService();
       
    public AddActorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-actor-db.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String addActor=request.getParameter("addActor");
		String cancelActor=request.getParameter("cancelActor");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (addActor != null) {
			Actor actor = new Actor(request.getParameter("firstName"), request.getParameter("lastName"));
			actorDataService.insertActor(actor);
		}
		response.sendRedirect("ListActorServlet");
	}

}
