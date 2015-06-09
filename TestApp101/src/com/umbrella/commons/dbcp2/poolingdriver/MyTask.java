package com.umbrella.commons.dbcp2.poolingdriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.ObjectPool;
import org.apache.log4j.Logger;


public class MyTask implements Runnable {
	
	private static Logger log = Logger.getLogger(MyTask.class);
	
	private int i = 0;

	@Override
	public void run() {
		try {
			Connection conn = null;
			Statement stat = null;
			ResultSet rs = null;
			try {
				log.info("i=" + (i++));
				conn = DriverManager.getConnection(Constants.DRIVER_URL + Constants.POOL_TEST);
				stat = conn.createStatement();
				rs = stat.executeQuery("select * from user t where t.id>14 order by t.id desc");
				while(rs.next()) {
					log.info(rs.getString("id") + "-" + rs.getString("username"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					stat.close();
					if(conn!=null) {
						conn.close(); // 程序在这一步卡住
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			try {
				PoolingDriver poolingDriver = (PoolingDriver)DriverManager.getDriver(Constants.DRIVER_URL);
				ObjectPool<? extends Connection> connectionPool = poolingDriver.getConnectionPool(Constants.POOL_TEST);
				log.info("NumActive:" + connectionPool.getNumActive());
				log.info("NumIdle:" + connectionPool.getNumIdle());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			log.info("任务异常了", e);
		}
	}

}
