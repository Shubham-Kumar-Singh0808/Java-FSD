package com.mphasis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	 public static Connection getConnection() throws SQLException {
	        String url = "jdbc:mysql://localhost:3306/ecommerce";
	        String username = "Shubham";
	        String password = "Laddu@8651";
	        return DriverManager.getConnection(url, username, password);
	    }
}
