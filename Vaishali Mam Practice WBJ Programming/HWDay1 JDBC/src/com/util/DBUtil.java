package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection con;
	
	public static void openConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver is loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/AdvanceJava", "root", "sah_utk");
		System.out.println("Connected To DB");
	}

	public static Connection getCon() {
		return con;
	}
	public static void closeConnection() throws SQLException {
		if(con!=null) {
			con.close();
		}
	}
}
