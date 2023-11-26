package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.service.CategoryDataService;

import java.io.IOException;

public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDataService categoryDataService = new CategoryDataService();

    public DeleteCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// удаляю строку из таблицы category через сервис
		categoryDataService.deleteCategory(Integer.parseInt(request.getParameter("category")));
		response.sendRedirect("ListCategoryServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
