package webapp.film.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webapp.film.model.Movie;
import webapp.film.model.MovieCustomer;
import webapp.film.model.VMovieReview;
import webapp.sqlite.Database;

public class FilmDataService {

	private static final String INSERT_FILM_QUERY = "INSERT INTO movie(title, description, release_year, duration, price, special_features, average_rating) "
												  + "VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String INSERT_CUSTOMER_FILM_QUERY = "INSERT INTO movie_customer(customer_id, movie_id, price, date_buy)  VALUES(?, ?, ?, ?)";

	private static final String DELETE_FILM_QUERY = "DELETE FROM movie WHERE movie_id=?";
	// строка удаления подчиненных записей актеров фильма
	private static final String DELETE_FILM_ACTOR_QUERY = "DELETE FROM movie_actor WHERE movie_id=?";
	// строка удаления подчиненных записей категорий фильма
	private static final String DELETE_FILM_CATEGORY_QUERY = "DELETE FROM movie_category WHERE movie_id=?";
	// строка удаления подчиненных записей отзывов фильма
	private static final String DELETE_FILM_REVIEW_QUERY = "DELETE FROM review WHERE movie_id=?";

	private static final String UPDATE_FILM_QUERY = "UPDATE movie SET title=?, description=?, release_year=?, duration=?, "
												  + "price=?, special_features=?, average_rating=?"
												  + " WHERE movie_id=?";
	
	private static final String SELECT_FILM_QUERY = "SELECT * FROM movie WHERE movie_id=?";

	private static final String SELECT_REVIEW_QUERY = "SELECT movie_id, review FROM v_movies_review WHERE movie_id=?";
	
	private PrintResult printResult = new PrintResult();

	Database db = new Database();
    
    /* выборка всех данных таблицы movie */
	public List<Movie> getAllFilms(String expression) throws SQLException {
		// Statement используется для того, чтобы выполнить sql-запрос
		try (Statement st = db.conn.createStatement()) {
        	ResultSet rs = st.executeQuery(expression);
        	// добавляю в коллекцию результат чтения данных из таблицы
        	List<Movie> listMovies = new ArrayList<Movie>();
        	while (rs.next()) {
        		listMovies.add(new Movie(rs.getInt("movie_id"), rs.getString("title"), rs.getString("description"), 
        								 rs.getInt("release_year"), rs.getInt("duration"), rs.getFloat("price"), 
        								 rs.getString("special_features"), rs.getFloat("average_rating")));
        		System.out.println(rs.getInt(1) + " | "  + rs.getString(2) + " | "  + rs.getString(3));
        	}
        	printResult.printResultSet(rs);
        	return listMovies;
        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return new ArrayList<Movie>(); 
        }
	}
	
	public void insertMovies(List<Movie> movies) {
		for (Movie film : movies) {
			insertFilm(film);
		}
	}

	public void insertFilm(Movie film) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(INSERT_FILM_QUERY);
			st.setString(1, film.getTitle());
			st.setString(2, film.getDescription());
			st.setInt(3, film.getRelease_year());
			st.setInt(4, film.getDuration());
			st.setFloat(5, film.getPrice());
			st.setString(6, film.getSpecial_features());
			st.setFloat(7, film.getAverage_rating());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + INSERT_FILM_QUERY, e);
			System.out.println("Query Failed : " + INSERT_FILM_QUERY);
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

	public void deleteFilm(int id) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(DELETE_FILM_QUERY);
			st.setInt(1, id);
			st.execute();
			// удаляю подчиненные данные по актерам фильма
			st = db.conn.prepareStatement(DELETE_FILM_ACTOR_QUERY);
			st.setInt(1, id);
			st.execute();
			// удаляю подчиненные данные по категориям фильма
			st = db.conn.prepareStatement(DELETE_FILM_CATEGORY_QUERY);
			st.setInt(1, id);
			st.execute();
			// удаляю подчиненные данные по отзывам фильма
			st = db.conn.prepareStatement(DELETE_FILM_REVIEW_QUERY);
			st.setInt(1, id);
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + DELETE_FILM_QUERY, e);
			System.out.println("Query Failed : " + DELETE_FILM_QUERY);
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
	
	public void updateFilm(Movie film) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(UPDATE_FILM_QUERY);
			st.setString(1, film.getTitle());
			st.setString(2, film.getDescription());
			st.setInt(3, film.getRelease_year());
			st.setInt(4, film.getDuration());
			st.setFloat(5, film.getPrice());
			st.setString(6, film.getSpecial_features());
			st.setFloat(7, film.getAverage_rating());
			st.setInt(8, film.getMovie_id());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + UPDATE_FILM_QUERY, e);
			System.out.println("Query Failed : " + UPDATE_FILM_QUERY);
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
	
	/* выборка конкретного фильма по sql - выражению */
	public Movie getFilm(String expression) throws SQLException {
		// Statement используется для того, чтобы выполнить sql-запрос
		try (Statement st = db.conn.createStatement()) {
        	ResultSet rs = st.executeQuery(expression);
        	// добавляю в коллекцию результат чтения данных из таблицы
        	Movie movie  = new Movie(rs.getInt("movie_id"), rs.getString("title"), rs.getString("description"), 
					 			     rs.getInt("release_year"), rs.getInt("duration"), rs.getFloat("price"), 
					 			     rs.getString("special_features"), rs.getFloat("average_rating"));
       		
      		System.out.println(rs.getInt(1) + " | "  + rs.getString(2) + " | "  + rs.getString(3));
        	printResult.printResultSet(rs);
        	return movie;
        } catch (SQLException e) {
            e.printStackTrace();
            return new Movie(); 
        }
	}
	
	/* выборка конкретного фильма по Id*/
	public Movie getFilmById(int id) throws SQLException {
		PreparedStatement st = null;
		Movie movie = null; 
		try {
			st = db.conn.prepareStatement(SELECT_FILM_QUERY);
			st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
            	// добавляю в результат чтения данных из таблицы по записи в модель
            	movie  = new Movie(rs.getInt("movie_id"), rs.getString("title"), rs.getString("description"), 
    			   			       rs.getInt("release_year"), rs.getInt("duration"), rs.getFloat("price"), 
    					 		   rs.getString("special_features"), rs.getFloat("average_rating"));
            	printResult.printResultSet(rs);
            }
            return movie;
        } catch (SQLException e) {
            e.printStackTrace();
            return new Movie(); 
        }
	}

	public void listAllRows(String expression) throws SQLException {
		Statement st = db.conn.createStatement();
		ResultSet rs = st.executeQuery(expression);
		printResult.printResultSet(rs);
		st.close();
	}
	
	/* выборка всех данных представления v_movie_review */
	public List<VMovieReview> getReviewByFilm(int id) throws SQLException {
		// Statement используется для того, чтобы выполнить sql-запрос
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(SELECT_REVIEW_QUERY);
			st.setInt(1, id);
            ResultSet rs = st.executeQuery();
        	// добавляю в коллекцию результат чтения данных из таблицы
        	List<VMovieReview> listVMovieReview = new ArrayList<VMovieReview>();
        	while (rs.next()) {
        		listVMovieReview.add(new VMovieReview(rs.getInt("movie_id"), rs.getString("review")));
        		System.out.println(rs.getInt(1) + " | "  + rs.getString(2));
        	}
        	printResult.printResultSet(rs);
        	return listVMovieReview;
        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return new ArrayList<VMovieReview>();
        }
	}
	
	public void insertCustomerFilm(MovieCustomer movieCustomer) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(INSERT_CUSTOMER_FILM_QUERY);
			st.setInt(1, movieCustomer.getCustomerId());
			st.setInt(2, movieCustomer.getMovieId());
			st.setFloat(3, movieCustomer.getPrice());
			st.setString(4, movieCustomer.getDateBuy());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + INSERT_FILM_QUERY, e);
			System.out.println("Query Failed : " + INSERT_CUSTOMER_FILM_QUERY);
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
}
