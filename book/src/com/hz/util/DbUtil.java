package com.hz.util;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


public class DbUtil {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		Properties pp = new Properties();
		
		Reader reader;
		try {
			
			reader = new FileReader(new File("C:\\Users\\Administrator\\Workspaces\\MyEclipse CI\\book\\db.properties"));
			pp.load(reader);
			driver = pp.getProperty("db_driver");
			url = pp.getProperty("db_url");
			username = pp.getProperty("db_username");
			password = pp.getProperty("db_password");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * 获取链接
	 */
	public static Connection getConn(){
		
		Connection conn = null;
		
		//1. 加载驱动
		try {
			Class.forName(driver);
			conn = 	DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	/*
	 * 增删改操�?
	 */
	public static void update(Connection conn, String sql, List list){
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(list != null){
				
				for(int i=0; i<list.size(); i++){
					ps.setObject(i+1, list.get(i));
				}
			}
			
			int i = ps.executeUpdate();
			System.out.println(i);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * 查询操作
	 */
	public static ResultSet query(Connection conn, String sql, List list){
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			if(list != null){
				
				for(int i=0; i<list.size(); i++){
					ps.setObject(i+1, list.get(i));
				}
			}
			
			rs = ps.executeQuery();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
		
	}
	
	/*
	 * 关闭资源
	 */
	public static void close(Connection conn, ResultSet rs){
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
