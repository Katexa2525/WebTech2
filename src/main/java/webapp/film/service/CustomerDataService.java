package webapp.film.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webapp.film.model.Customer;
import webapp.film.model.VMovieCustomer;
import webapp.sqlite.Database;

public class CustomerDataService {

	private static final String INSERT_CUSTOMER_QUERY = "INSERT INTO customer(first_name, last_name, email, address, active, discount, bonus, is_admin, password) "
			  										  + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String DELETE_CUSTOMER_QUERY = "DELETE FROM customer WHERE customer_id=?";
	private static final String UPDATE_CUSTOMER_QUERY = "UPDATE customer SET first_name=?, last_name=?, email=?, address=?, active=?, discount=?, bonus=?,"
													  + " is_admin=?, password=?"
													  + " WHERE customer_id=?";
	private static final String SELECT_CUSTOMER_QUERY = "SELECT * FROM customer WHERE customer_id=?";
	private static final String SELECT_CUSTOMER_MOVIES_QUERY = "SELECT * FROM v_movie_customer WHERE customer_id=?";

	private PrintResult printResult = new PrintResult();

	Database db = new Database();
	
	/* выборка всех данных таблицы movie */
	public List<Customer> getAllCustomers(String expression) throws SQLException {
		// Statement используется для того, чтобы выполнить sql-запрос
		try (Statement st = db.conn.createStatement()) {
        	ResultSet rs = st.executeQuery(expression);
        	// добавляю в коллекцию результат чтения данных из таблицы
        	List<Customer> listCustomers = new ArrayList<Customer>();
        	while (rs.next()) {
        		listCustomers.add(new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), 
        								 	   rs.getString("email"), rs.getString("address"),
        								 	   rs.getInt("active"), rs.getFloat("discount"), rs.getString("bonus"),
        								       rs.getInt("is_admin"), rs.getString("password") ));
        		System.out.println(rs.getInt(1) + " | "  + rs.getString(2) + " | "  + rs.getString(3) + " | "  + rs.getString(4) + " | "  + rs.getString(5));
        	}
        	printResult.printResultSet(rs);
        	return listCustomers;
        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return new ArrayList<Customer>();
        }
	}
	
	public void insertCustomer(Customer customer) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(INSERT_CUSTOMER_QUERY);
			st.setString(1, customer.getFirstName());
			st.setString(2, customer.getLastName());
			st.setString(3, customer.getEmail());
			st.setString(4, customer.getAddress());
			st.setInt(5, customer.getActive());
			st.setFloat(6, customer.getDiscount());
			st.setString(7, customer.getBonus());
			st.setInt(8, customer.getIsAdmin());
			st.setString(9, customer.getPassword());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + INSERT_FILM_QUERY, e);
			System.out.println("Query Failed : " + INSERT_CUSTOMER_QUERY);
			System.out.println("Query Failed : " + e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("PreparedStatement Close Failed : " + e);
				}
			}
		}
	}
	
	public void deleteCustomer(int id) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(DELETE_CUSTOMER_QUERY);
			st.setInt(1, id);
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + DELETE_FILM_QUERY, e);
			System.out.println("Query Failed : " + DELETE_CUSTOMER_QUERY);
			System.out.println("Query Failed : " + e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("PreparedStatement Close Failed : " + e);
				}
			}
		}
	}

	public void updateCustomer(Customer customer) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(UPDATE_CUSTOMER_QUERY);
			st.setString(1, customer.getFirstName());
			st.setString(2, customer.getLastName());
			st.setString(3, customer.getEmail());
			st.setString(4, customer.getAddress());
			st.setInt(5, customer.getActive());
			st.setFloat(6, customer.getDiscount());
			st.setString(7, customer.getBonus());
			st.setInt(8, customer.getIsAdmin());
			st.setString(9, customer.getPassword());
			st.setInt(10, customer.getCustomerId());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + UPDATE_FILM_QUERY, e);
			System.out.println("Query Failed : " + UPDATE_CUSTOMER_QUERY);
			System.out.println("Query Failed : " + e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("PreparedStatement Close Failed : " + e);
				}
			}
		}
	}
	
	/* выборка конкретного пользователя по Id*/
	public Customer getCustomerById(int id) throws SQLException {
		PreparedStatement st = null;
		Customer customer = null; 
		try {
			st = db.conn.prepareStatement(SELECT_CUSTOMER_QUERY);
			st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
            	// добавляю в результат чтения данных из таблицы по записи в модель
            	customer = new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), 
					 	   				 rs.getString("email"), rs.getString("address"), rs.getInt("active"), 
					 	   				 rs.getFloat("discount"), rs.getString("bonus"), 
					 	   				 rs.getInt("is_admin"), rs.getString("password"));
            	printResult.printResultSet(rs);
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return new Customer(); 
        }
	}
	
	/* выборка всех данных таблицы movie_customer */
	public List<VMovieCustomer> getAllCustomerMovies(int customerId) throws SQLException {
		// Statement используется для того, чтобы выполнить sql-запрос
		PreparedStatement st = null;
		VMovieCustomer vMovieCustomer = null; 
		try {
			st = db.conn.prepareStatement(SELECT_CUSTOMER_MOVIES_QUERY);
			st.setInt(1, customerId);
            ResultSet rs = st.executeQuery();
        	// добавляю в коллекцию результат чтения данных из таблицы
        	List<VMovieCustomer> listVMovieCustomer = new ArrayList<VMovieCustomer>();
        	while (rs.next()) {
        		listVMovieCustomer.add(new VMovieCustomer(rs.getInt("customer_id"), rs.getInt("movie_id"), 
        												  rs.getString("title"), rs.getString("description"), 
        												  rs.getFloat("price"), rs.getString("date_buy")));
        		System.out.println(rs.getInt(1) + " | "  + rs.getString(2) + " | "  + rs.getString(3) + " | "  + rs.getString(4) + " | "  + rs.getString(5));
        	}
        	printResult.printResultSet(rs);
        	return listVMovieCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return new ArrayList<VMovieCustomer>();
        }
	}

}
