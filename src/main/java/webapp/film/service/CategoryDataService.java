package webapp.film.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webapp.film.model.Category;
import webapp.sqlite.Database;

public class CategoryDataService {
	private static final String INSERT_CATEGORY_QUERY = "INSERT INTO category(name) VALUES(?)";
	private static final String DELETE_CATEGORY_QUERY = "DELETE FROM category WHERE category_id=?";
	private static final String UPDATE_CATEGORY_QUERY = "UPDATE category SET name=? WHERE category_id=?";
	private static final String SELECT_CATEGORY_QUERY = "SELECT * FROM category WHERE category_id=?";
	
	private PrintResult printResult = new PrintResult();

	Database db = new Database();
	
	public CategoryDataService() {
		// TODO Auto-generated constructor stub
	}
	
	/* выборка всех данных таблицы category */
	public List<Category> getAllcategoryes(String expression) throws SQLException {
		// Statement используется для того, чтобы выполнить sql-запрос
		try (Statement st = db.conn.createStatement()) {
        	ResultSet rs = st.executeQuery(expression);
        	// добавляю в коллекцию результат чтения данных из таблицы
        	List<Category> listCategoryes = new ArrayList<Category>();
        	while (rs.next()) {
        		listCategoryes.add(new Category(rs.getInt("category_id"), rs.getString("name")));
        		System.out.println(rs.getInt(1) + " | "  + rs.getString(2));
        	}
        	printResult.printResultSet(rs);
        	return listCategoryes;
        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return new ArrayList<Category>(); //Collections.emptyList();
        }
	}
	
	public void insertCategoryes(List<Category> categoryes) {
		for (Category category : categoryes) {
			insertCategory(category);
		}
	}

	public void insertCategory(Category category) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(INSERT_CATEGORY_QUERY);
			st.setString(1, category.getName());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + INSERT_FILM_QUERY, e);
			System.out.println("Query Failed : " + INSERT_CATEGORY_QUERY);
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

	public void deleteCategory(int id) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(DELETE_CATEGORY_QUERY);
			st.setInt(1, id);
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + DELETE_FILM_QUERY, e);
			System.out.println("Query Failed : " + DELETE_CATEGORY_QUERY);
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
	
	public void updateCategory(Category category) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(UPDATE_CATEGORY_QUERY);
			st.setString(1, category.getName());
			st.setInt(2, category.getCategoryId());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + UPDATE_FILM_QUERY, e);
			System.out.println("Query Failed : " + UPDATE_CATEGORY_QUERY);
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
	
	/* выборка конкретного актера по Id*/
	public Category getCategoryById(int id) throws SQLException {
		PreparedStatement st = null;
		Category category = null; 
		try {
			st = db.conn.prepareStatement(SELECT_CATEGORY_QUERY);
			st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
            	// добавляю в результат чтения данных из таблицы по записи в модель
            	category  = new Category(rs.getInt("category_id"), rs.getString("name"));
            	printResult.printResultSet(rs);
            }
            return category;
        } catch (SQLException e) {
            e.printStackTrace();
            return new Category(); 
        }
	}

}
