package in.jabezraja.captain.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {
	// this method will be use when ever we connect with database.
	public static Connection getConnection() {
		Connection connection = null;
		String url = null;
		String userName = null;
		String password = null;
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection(url, userName, password);

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://aws.connect.psdb.cloud/jacksparrow?sslMode=VERIFY_IDENTITY", "nwy6stb9ddlzxeqdytpe",
					"pscale_pw_Uh1vz4CracLulP4cVZAF0JQfmyC9fRJGIwmaSSliSzE");

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return connection;
	}

	public static void close(Connection connection, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection connection, PreparedStatement ps, ResultSet rs) {
		try {
			// the order of close is important.
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}