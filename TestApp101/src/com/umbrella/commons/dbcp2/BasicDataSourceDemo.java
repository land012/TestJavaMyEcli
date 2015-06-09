package com.umbrella.commons.dbcp2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class BasicDataSourceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BasicDataSource ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/test");
			ds.setUsername("root");
			ds.setPassword("123456");
			
			Connection conn = ds.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from user t order by t.id desc");
			while(rs.next()) {
				System.out.format("%s-%s%n", rs.getString("id"), rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
