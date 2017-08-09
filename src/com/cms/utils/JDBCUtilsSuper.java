package com.cms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsSuper {
	private static String DRIVERNAME;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	static{
		InputStream inputStream = JDBCUtilsSuper.class.getResourceAsStream("/com/cms/config/db.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputStream);
			DRIVERNAME = properties.getProperty("jdbc.driver");
			URL = properties.getProperty("jdbc.url");
			USER = properties.getProperty("jdbc.username");
			PASSWORD = properties.getProperty("jdbc.password");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection connection = null;
		try {
			Class.forName(DRIVERNAME);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	public static void close(Connection con,Statement stat){
		if(stat!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection con,Statement stat,ResultSet res){
		if(res!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
}
