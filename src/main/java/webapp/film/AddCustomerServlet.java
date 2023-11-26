package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.model.Customer;
import webapp.film.service.CustomerDataService;

import java.io.IOException;

public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDataService customerDataService = new CustomerDataService();
       
    public AddCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-customer-db.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addCustomer=request.getParameter("addCustomer");
		String cancelCustomer=request.getParameter("cancelCustomer");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (addCustomer != null) {
			// сохраняю отредактированную строку из таблицы Customer через сервис
			Customer customer = new Customer(request.getParameter("firstName"),	 request.getParameter("lastName"),
											 request.getParameter("email"),request.getParameter("address"), 
											 Integer.parseInt(request.getParameter("active")), Float.parseFloat(request.getParameter("discount")), 
											 request.getParameter("bonus"), Integer.parseInt(request.getParameter("isAdmin")),
											 request.getParameter("password") );

			customerDataService.insertCustomer(customer);
		}
		response.sendRedirect("ListCustomerServlet");
	}

}
