package proiect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LogService {
	public static void addLog(String message){
		Statement st;
		Connection connection = Service.getConnection();

		String query = String.format("insert into log(Text) values('%s')", message);

		try {
			st = connection.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			
		}
		
	}
}
