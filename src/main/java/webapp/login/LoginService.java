package webapp.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import webapp.film.model.Customer;
import webapp.film.service.PrintResult;
import webapp.sqlite.Database;

public class LoginService {
	// переменная с запросом для поиска записи по логину и паролю
	private static final String SELECT_CUSTOMER_QUERY = "SELECT * FROM customer WHERE first_name=? AND password=?";

	private PrintResult printResult = new PrintResult();

	Database db = new Database();

	public boolean isUserValid(String user, String password) {
		/*
		if (user.equals("Katya") && password.equals("www"))
			return true;
		return false;
		*/

		try {
			PreparedStatement st = db.conn.prepareStatement(SELECT_CUSTOMER_QUERY);
			st.setString(1, user);
			st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
            	// если найдена запись, значит введены верные данные на форме авторизации
            	printResult.printResultSet(rs);
            	return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
	}
	
	public Customer GetUserValid(String user, String password) {
		Customer customer = null;
		try {
			PreparedStatement st = db.conn.prepareStatement(SELECT_CUSTOMER_QUERY);
			st.setString(1, user);
			st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
            	// если найдена запись, значит введены верные данные на форме авторизации
            	customer = new Customer();
            	customer.setFirstName(rs.getString("first_name"));
            	customer.setIsAdmin(rs.getInt("is_admin"));
            	customer.setCustomerId(rs.getInt("customer_id"));
            	printResult.printResultSet(rs);
            	return customer;
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return customer; 
        }
	}

}