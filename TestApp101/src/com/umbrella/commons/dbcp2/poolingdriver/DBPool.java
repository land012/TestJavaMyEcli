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
			// ע��jdbc����
			Class.forName("com.mysql.jdbc.Driver");
			// ����
			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(dbUrl, username, password);
			// ���ӹ���
			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
			// ��
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnectionFactory);
			connectionPool.setMaxTotal(3);
			connectionPool.setMaxIdle(1);
			connectionPool.setMinIdle(0);
			connectionPool.setTestWhileIdle(false);
			
			/*
			 * ��������䣬���� conn.close()ʱ�ͻ����쳣,_pool Ϊ Null ���쳣
			 */
			poolableConnectionFactory.setPool(connectionPool);
			
			// ע�������
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
