package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.model.Actor;
import webapp.film.model.Movie;
import webapp.film.service.ActorDataService;

import java.io.IOException;
import java.sql.SQLException;

public class EditActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActorDataService actorDataService = new ActorDataService();
       
    public EditActorServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("actor", actorDataService.getActorById(Integer.parseInt(request.getParameter("actor"))));
			request.getRequestDispatcher("/WEB-INF/views/edit-actor-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saveActor=request.getParameter("saveActor");
		String cancelActor=request.getParameter("cancelActor");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (saveActor != null) {
		// сохраняю отредактированную строку из таблицы actor через сервис
			Actor actor = new Actor(Integer.parseInt(request.getParameter("actorId")), 
								request.getParameter("firstName"), request.getParameter("lastName"));

			actorDataService.updateActor(actor);
		}
		response.sendRedirect("ListActorServlet");
	}

}
