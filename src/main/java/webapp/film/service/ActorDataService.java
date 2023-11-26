package webapp.film.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import webapp.film.model.Actor;
import webapp.film.model.Movie;
import webapp.sqlite.Database;

public class ActorDataService {

	private static final String INSERT_ACTOR_QUERY = "INSERT INTO actor(first_name, last_name) VALUES(?, ?)";
	private static final String DELETE_ACTOR_QUERY = "DELETE FROM actor WHERE actor_id=?";
	private static final String UPDATE_ACTOR_QUERY = "UPDATE actor SET first_name=?, last_name=? WHERE actor_id=?";
	private static final String SELECT_ACTOR_QUERY = "SELECT * FROM actor WHERE actor_id=?";
	
	private PrintResult printResult = new PrintResult();

	Database db = new Database();
	
	public ActorDataService() {
		// TODO Auto-generated constructor stub
	}
	
	/* выборка всех данных таблицы actor */
	public List<Actor> getAllActors(String expression) throws SQLException {
		// Statement используется для того, чтобы выполнить sql-запрос
		try (Statement st = db.conn.createStatement()) {
        	ResultSet rs = st.executeQuery(expression);
        	// добавляю в коллекцию результат чтения данных из таблицы
        	List<Actor> listActors = new ArrayList<Actor>();
        	while (rs.next()) {
        		listActors.add(new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name")));
        		System.out.println(rs.getInt(1) + " | "  + rs.getString(2) + " | "  + rs.getString(3));
        	}
        	printResult.printResultSet(rs);
        	return listActors;
        } catch (SQLException e) {
            e.printStackTrace();
            // Если произошла ошибка - возвращаем пустую коллекцию
            return new ArrayList<Actor>(); //Collections.emptyList();
        }
	}
	
	public void insertActors(List<Actor> actors) {
		for (Actor actor : actors) {
			insertActor(actor);
		}
	}

	public void insertActor(Actor actor) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(INSERT_ACTOR_QUERY);
			st.setString(1, actor.getFirstName());
			st.setString(2, actor.getLastName());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + INSERT_FILM_QUERY, e);
			System.out.println("Query Failed : " + INSERT_ACTOR_QUERY);
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

	public void deleteActor(int id) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(DELETE_ACTOR_QUERY);
			st.setInt(1, id);
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + DELETE_FILM_QUERY, e);
			System.out.println("Query Failed : " + DELETE_ACTOR_QUERY);
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
	
	public void updateActor(Actor actor) {
		PreparedStatement st = null;
		try {
			st = db.conn.prepareStatement(UPDATE_ACTOR_QUERY);
			st.setString(1, actor.getFirstName());
			st.setString(2, actor.getLastName());
			st.setInt(3, actor.getActorId());
			st.execute();
		} catch (SQLException e) {
			//logger.fatal("Query Failed : " + UPDATE_FILM_QUERY, e);
			System.out.println("Query Failed : " + UPDATE_ACTOR_QUERY);
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
	public Actor getActorById(int id) throws SQLException {
		PreparedStatement st = null;
		Actor actor = null; 
		try {
			st = db.conn.prepareStatement(SELECT_ACTOR_QUERY);
			st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
            	// добавляю в результат чтения данных из таблицы по записи в модель
            	actor  = new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
            	printResult.printResultSet(rs);
            }
            return actor;
        } catch (SQLException e) {
            e.printStackTrace();
            return new Actor(); 
        }
	}

}
