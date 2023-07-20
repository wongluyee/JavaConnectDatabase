import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLConnectDelete {

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
			String sql = "DELETE FROM user_list WHERE id = ?";
			ps = con.prepareStatement(sql);
			// 1 = first question mark, 3 = id
			ps.setInt(1,  1);

			// SQL
			int count = ps.executeUpdate();
			System.out.println(count + " Deleted.");
			
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
