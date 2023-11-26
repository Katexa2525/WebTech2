package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.service.CategoryDataService;

import java.io.IOException;
import java.sql.SQLException;

public class ListCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDataService categoryDataService = new CategoryDataService();
       
    public ListCategoryServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("categoryes", categoryDataService.getAllcategoryes("SELECT * FROM category"));
			request.getRequestDispatcher("/WEB-INF/views/list-categoryes-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
