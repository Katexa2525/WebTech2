package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.service.ActorDataService;

import java.io.IOException;

public class DeleteActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ActorDataService actorDataService = new ActorDataService();
       
    public DeleteActorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// удаляю строку из таблицы actor через сервис
		actorDataService.deleteActor(Integer.parseInt(request.getParameter("actor")));
		response.sendRedirect("ListActorServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
