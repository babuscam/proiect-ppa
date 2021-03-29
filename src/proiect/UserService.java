package proiect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class UserService {
	public static boolean login(String username, char[] password) {
		char[] parolaCorecta = { '1', '2', '3', '4' };
		if (!username.equals("user") || !Arrays.equals(password, parolaCorecta)) {
			return false;
		}

		return true;
	}

	public static User getUser(String name) {
		ResourceSingleton resource = ResourceSingleton.getInstance();
		
		return resource.getUser(name);
	}
	
	public static User getDbUser(String name) {
		Statement st;
		ResultSet rs;
		User user = null;

		Connection connection = Service.getConnection();

		String query = "SELECT * FROM  users where Lastname = '" + name + "'";

		try {
			st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(query);

			if (!rs.next()) {
				return null;
			}

			user = new User(rs.getString("Lastname"), rs.getString("Firstname"), rs.getString("Email"),
					rs.getString("Phone"));
			user.setId(rs.getInt("Id"));
			
			ResourceSingleton resource = ResourceSingleton.getInstance();
			resource.addUser(user);

		} catch (SQLException e) {

		}

		return user;
	}

	public static int getNrUsers() {
		Statement st;
		ResultSet rs;
		int count = 0;

		Connection connection = Service.getConnection();

		String query = "SELECT count(*) FROM  users";

		try {
			st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(query);

			if (!rs.next()) {
				return 0;
			}

			count = rs.getInt(1);

		} catch (SQLException e) {
			System.out.println();
		}

		return count;
	}

	public static User getUserById(int id) {
		Statement st;
		ResultSet rs;
		User user = null;

		Connection connection = Service.getConnection();

		String query = "SELECT * FROM  users where Id = '" + id + "'";

		try {
			st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery(query);

			if (!rs.next()) {
				return null;
			}

			user = new User(rs.getString("Lastname"), rs.getString("Firstname"), rs.getString("Email"),
					rs.getString("Phone"));
			user.setId(rs.getInt("Id"));

		} catch (SQLException e) {

		}

		return user;
	}

	public static void addUser(User user) {
		Statement st;
		Connection connection = Service.getConnection();

		String query = String.format("insert into users(Lastname,Firstname,Email,Phone) values('%s','%s','%s','%s')",
				user.getLastname(), user.getFirstname(), user.getEmail(), user.getPhone());

		try {
			st = connection.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {

		}
	}

	public static void updateUser(User user) {
		Statement st;
		Connection connection = Service.getConnection();

		String query = String.format(
				"update users set Lastname = '%s',Firstname = '%s',Email = '%s',Phone = '%s' where Id = %d",
				user.getLastname(), user.getFirstname(), user.getEmail(), user.getPhone(), user.getId());

		try {
			st = connection.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {

		}
	}

	public static void deleteUser(int id) {
		Statement st;
		Connection connection = Service.getConnection();

		String query = String.format("delete from users where Id = %d", id);

		try {
			st = connection.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {

		}
	}
}
