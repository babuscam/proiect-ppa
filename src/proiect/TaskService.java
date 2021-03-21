package proiect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskService {
	public static int getNrTasks(){
		Statement st;
		ResultSet rs;
		int count = 0;

		Connection connection = Service.getConnection();

		String query = "SELECT count(*) FROM  tasks";

		try {
			st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(query);

			if (!rs.next()) {
				return 0;
			}

			count = rs.getInt(1);

		} catch (SQLException e) {

		}

		return count;
	}
	
	public static Task getTaskById(int id) {
		Statement st;
		ResultSet rs;
		Task task = null;

		Connection connection = Service.getConnection();

		String query = "SELECT * FROM  tasks where Id = '" + id + "'";

		try {
			st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(query);

			if (!rs.next()) {
				return null;
			}

			task = new Task(rs.getString("Name"), rs.getInt("UserId"));
			task.setId(rs.getInt("Id"));

		} catch (SQLException e) {

		}

		return task;
	}
	
	public static void addTask(Task task) {
		Statement st;
		Connection connection = Service.getConnection();

		String query = String.format("insert into tasks(Name,UserId) values('%s','%d')",
				task.getName(), task.getUserId());

		try {
			st = connection.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {

		}
	}
	
	public static void deleteTask(int id) {
		Statement st;
		Connection connection = Service.getConnection();

		String query = String.format("delete from tasks where Id = %d", id);

		try {
			st = connection.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {

		}
	}
}
