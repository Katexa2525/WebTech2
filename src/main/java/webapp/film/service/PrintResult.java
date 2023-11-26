package webapp.film.service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintResult {

	public PrintResult() {
		// TODO Auto-generated constructor stub
	}
	
	public void printResultSet(ResultSet rs) throws SQLException {
		int colmax = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			for (int i = 0; i < colmax; ++i) {
				Object o = rs.getObject(i + 1);
				//logger.info(o.toString() + " ");
				System.out.println(o.toString() + " ");
			}
			//logger.info(" ");
			System.out.println(" ");
		}
	}

}
