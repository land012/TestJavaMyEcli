package com.land.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Before;
import org.junit.Test;

import com.land.util.HibernateUtil;

public class ORMappingTest {
	private SessionFactory sf;
	
	@Before
	public void before() {
		sf = HibernateUtil.getSessionFactory();
	}
	
	@Test
	public void testOneToOne1() {
		new SchemaExport(new Configuration().configure()).create(true, true);
	}
}
