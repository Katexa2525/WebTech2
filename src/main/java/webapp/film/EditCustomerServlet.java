package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.model.Customer;
import webapp.film.service.CustomerDataService;

import java.io.IOException;
import java.sql.SQLException;

public class EditCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDataService customerDataService = new CustomerDataService();
       
    public EditCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("customer", customerDataService.getCustomerById(Integer.parseInt(request.getParameter("customer"))));
			request.getRequestDispatcher("/WEB-INF/views/edit-customer-db.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String saveCustomer=request.getParameter("saveCustomer");
		String cancelCustomer=request.getParameter("cancelCustomer");
		
		// Проверяю какая кнопка была нажата, если Add, то добавляю, иначе перехожу на список
		if (saveCustomer != null) {
			// сохраняю отредактированную строку из таблицы Customer через сервис
			Customer customer = new Customer(); 
			customer.setCustomerId(Integer.parseInt(request.getParameter("customerId")));
			customer.setFirstName(request.getParameter("firstName"));
			customer.setLastName(request.getParameter("lastName"));
			customer.setEmail(request.getParameter("email"));
			customer.setAddress(request.getParameter("address")); 
			customer.setDiscount(Float.parseFloat(request.getParameter("discount"))); 
			customer.setBonus(request.getParameter("bonus"));
			customer.setIsAdmin(Integer.parseInt(request.getParameter("isAdmin")));
			customer.setActive(Integer.parseInt(request.getParameter("active")));
			customer.setPassword(request.getParameter("password"));

			customerDataService.updateCustomer(customer);
		}
		response.sendRedirect("ListCustomerServlet");
	}

}
