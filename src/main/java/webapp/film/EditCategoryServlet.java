package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.service.CategoryDataService;

import java.io.IOException;
import java.sql.SQLException;
import webapp.film.model.Category;

public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDataService categoryDataService = new CategoryDataService();
       
    public EditCategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("category", categoryDataService.getCategoryById(Integer.parseInt(request.getParameter("category"))));
			request.getRequestDispatcher("/WEB-INF/views/edit-category-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String saveCategory=request.getParameter("saveCategory");
		String cancelCategory=request.getParameter("cancelCategory");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (saveCategory != null) {
			// 	сохраняю отредактированную строку из таблицы actor через сервис
			Category category = new Category(Integer.parseInt(request.getParameter("categoryId")), request.getParameter("name"));

			categoryDataService.updateCategory(category);
		}
     	response.sendRedirect("ListCategoryServlet");
	}

}
