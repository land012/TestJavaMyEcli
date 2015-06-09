package com.umbrella.commons.dbcp2.poolingds;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class DBPool {
	
	private DataSource ds;
	
	public DBPool(String dbUrl, String user, String password) {
		/*
		 * �������ӵĹ���
		 */
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(dbUrl, user, password);
		
		/*
		 * ���ӹ��� implements org.apache.commons.pool2.PooledObjectFactory
		 * �������Էŵ����е�����
		 */
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
		
		// ��
		GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<PoolableConnection>(poolableConnectionFactory);
		connectionPool.setMaxTotal(3);
		connectionPool.setMaxIdle(2);
		connectionPool.setMinIdle(0);
		
		poolableConnectionFactory.setPool(connectionPool);
		
		ds = new PoolingDataSource<PoolableConnection>(connectionPool);
	}
	
	public DataSource getDs() {
		return this.ds;
	}
}
