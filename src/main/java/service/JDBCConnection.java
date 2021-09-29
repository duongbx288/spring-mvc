package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getJDBCConnection() {
		final String url = "jdbc:mysql://localhost:3306/websellwatch";
		final String user = "BOOK_SHOP";
		final String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
					
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Connection cnt = getJDBCConnection();
		if(cnt != null) {
			System.out.println("kết nối thành công ");
		}
		else {
			System.out.println("kết nối thất bại");
		}
	}
}