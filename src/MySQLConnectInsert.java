import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLConnectInsert {

	public static void main(String[] args) {
		// To connect database
		Connection con = null;
		PreparedStatement ps = null;

		try {
			// Register JDBC driver (instance)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connect to database. user is the name of database
			String url = "jdbc:mysql://localhost/user";
			String user = "root";
			String password = "";
			con = DriverManager.getConnection(url, user, password);

			// Get statement object
			String sql = "INSERT INTO user_list(name, age) VALUE ('Java', 33)";
			ps = con.prepareStatement(sql);

			// SQL
			int count = ps.executeUpdate();
			System.out.println(count + " added.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// End database connection
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
