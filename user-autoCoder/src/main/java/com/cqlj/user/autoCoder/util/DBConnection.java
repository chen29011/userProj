package com.cqlj.user.autoCoder.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static ResultSet getResultSet(String sql) throws ClassNotFoundException, SQLException{
		Class.forName(Constants.DRIVER);
		Connection con = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);// 创建连接对象
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		return rs;
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql = "show tables";
		Class.forName(Constants.DRIVER);
		Connection con = DriverManager.getConnection(Constants.URL, Constants.USERNAME, Constants.PASSWORD);// 创建连接对象
		Statement st = con.createStatement();// 创建sql执行对象
		ResultSet rs = st.executeQuery(sql);// 执行sql语句并返回结果集
		while (rs.next())// 对结果集进行遍历输出
		{
			System.out.println("tableName: " + rs.getString("Tables_in_mytest"));// 通过列的标号来获得数据
		}

	}
}
