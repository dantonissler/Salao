package main.java.connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Connection;

public class ConnectionFactory {

	/**
	 * @author Danton Issler
	 */

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/Salao?&useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return (Connection) DriverManager.getConnection(URL, USER, PASS);

		} catch (SQLException e) {
			throw new RuntimeException("Erro na conex�o:", e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Erro na conex�o:", e);
		} catch (Exception e) {
			throw new RuntimeException("Erro na conex�o:", e);
		}
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con,
			java.sql.PreparedStatement stmt) {
		closeConnection(con);
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con,
			java.sql.PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con, ResultSet rs) {
		closeConnection(con);
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con, ResultSet rs,
			Statement st) {
		closeConnection(con, rs);
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}

	public static void closeConnection(Connection con,
			java.sql.PreparedStatement stmt, ResultSet rs, Statement st) {
		closeConnection(con, stmt, rs);
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException ex) {
			Logger.getLogger(ConnectionFactory.class.getName()).log(
					Level.SEVERE, null, ex);
		}
	}
}
