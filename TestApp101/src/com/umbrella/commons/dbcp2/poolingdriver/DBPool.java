package com.umbrella.commons.dbcp2.poolingdriver;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.log4j.Logger;


public class DBPool {
	
	private static Logger log = Logger.getLogger(DBPool.class);
	
	public void init() {
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "123456";
		try {
			// 注册jdbc驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 连接
			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(dbUrl, username, password);
			// 连接工厂
			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
			// 池
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnectionFactory);
			connectionPool.setMaxTotal(3);
			connectionPool.setMaxIdle(1);
			connectionPool.setMinIdle(0);
			connectionPool.setTestWhileIdle(false);
			
			/*
			 * 必须有这句，否则 conn.close()时就会抛异常,_pool 为 Null 的异常
			 */
			poolableConnectionFactory.setPool(connectionPool);
			
			// 注册池驱动
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver poolingDriver = (PoolingDriver)DriverManager.getDriver(Constants.DRIVER_URL);
			poolingDriver.registerPool(Constants.POOL_TEST, connectionPool);
			log.info("DBPool " + Constants.POOL_TEST + " inited!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
