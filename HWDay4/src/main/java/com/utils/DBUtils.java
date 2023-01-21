package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static Connection con;
	
	public static void openConnction() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver found");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "sah_utk");
		System.out.println("Connection done");
	}

	public static Connection getCon() {
		return con;
	}
	public static void closeConnection() throws SQLException {
		if(con!=null) con.close();
	}
}
