package webapp.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    // Константа, в которой хранится адрес подключения d:\SQLiteBD\
    private static final String CON_STR = "jdbc:sqlite:d:/SQLiteBD/OrderingFilms.db";
    //private static final String CON_STR = "jdbc:sqlite:webapp/WEB-INF/OrderingFilms.db";
    
	public Connection conn;

	public Database() {
		try {
			loadJdbcDriverForSqLiteDb();
			setupConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void setupConnection() throws SQLException {
		//conn = DriverManager.getConnection(CON_STR, "", "");
		conn = DriverManager.getConnection(CON_STR);
	}

	private void loadJdbcDriverForSqLiteDb() throws ClassNotFoundException {
		//Class.forName("org.sqlite.jdbcDriver");
		Class.forName("org.sqlite.JDBC");
	}

	private void shutdownSqLiteDatabase() throws SQLException {
		Statement st = conn.createStatement();
		st.execute("SHUTDOWN");
	}

	public void closeConnection() throws SQLException {
		shutdownSqLiteDatabase();
		conn.close(); // if there are no other open connection
	}
}