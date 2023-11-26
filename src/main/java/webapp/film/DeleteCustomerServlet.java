package webapp.film;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webapp.film.service.CustomerDataService;

import java.io.IOException;

public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDataService customerDataService = new CustomerDataService();
       
    public DeleteCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// удаляю строку из таблицы customer через сервис
		customerDataService.deleteCustomer(Integer.parseInt(request.getParameter("customer")));
		response.sendRedirect("ListCustomerServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
