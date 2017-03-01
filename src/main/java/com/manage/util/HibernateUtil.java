package com.manage.util;

import org.hibernate.SessionFactory;  
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	static {
		Configuration cfg = new Configuration().configure();  
		ServiceRegistry serviceRegistry= new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();  
		sessionFactory = cfg.buildSessionFactory(serviceRegistry);
	}
	
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
