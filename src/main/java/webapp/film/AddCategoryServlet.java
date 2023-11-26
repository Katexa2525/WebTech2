package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.model.Category;
import webapp.film.service.CategoryDataService;

import java.io.IOException;

public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDataService categoryDataService = new CategoryDataService();
       
    public AddCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-category-db.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String addCategory=request.getParameter("addCategory");
		String cancelCategory=request.getParameter("cancelCategory");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (addCategory != null) {
			Category category = new Category(request.getParameter("name"));
			categoryDataService.insertCategory(category);
		}
		response.sendRedirect("ListCategoryServlet");
	}

}
