package com.umbrella.commons.dbcp2.poolingds;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class MyTask implements Runnable {
	
	private static Logger log = Logger.getLogger(MyTask.class);
	
	private static int i = 0;
	private DataSource ds;
	private String sql;
	
	public MyTask(DataSource ds, String sql) {
		this.ds = ds;
		this.sql = sql;
	}

	@Override
	public void run() {
		log.info(i++);
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = this.ds.getConnection();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()) {
				log.info(rs.getString(1) + "-" + rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
