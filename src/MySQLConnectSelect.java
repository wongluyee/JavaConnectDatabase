import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnectSelect {

	public static void main(String[] args) {
		// To connect database
		Connection con = null;
		// To analysis SQL statement
		PreparedStatement ps = null;
		// To keep the results from SELECT
		ResultSet rs = null;

		try {
			// Register JDBC driver (instance)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connect to database. user is the name of database
			String url = "jdbc:mysql://localhost/user";
			String user = "root";
			String password = "";
			con = DriverManager.getConnection(url, user, password);

			// Get statement object
			String sql = "SELECT * FROM user_list";
			ps = con.prepareStatement(sql);

			// SQL
			rs = ps.executeQuery();
			
			// Get result
			while(rs.next()) {
				System.out.print("id:" + rs.getInt("id") + " ");
				System.out.print("name:" + rs.getString("name") + " ");
				System.out.println("age:" + rs.getInt("age"));
			}
			
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
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
