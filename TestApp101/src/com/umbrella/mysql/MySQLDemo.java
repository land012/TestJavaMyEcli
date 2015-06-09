package com.umbrella.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/test";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
//			new com.mysql.jdbc.Driver();
			conn = DriverManager.getConnection(url, "root", "123456");
//			if(!conn.isClosed())
//				System.out.println("数据库连接成功！");
			stat = conn.createStatement();
			String sql = "select * from user t order by t.id desc";
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("id") + " - " + rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
					rs = null;
				}
				
				stat.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
