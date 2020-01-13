package org.brijframework.jpa.hibernate.factories;


import java.lang.annotation.Annotation;

import org.brijframework.jpa.util.EntityConstants;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateFactory {

	private static SessionFactory sessionFactory;
	
	private static HibernateFactory factory;
	
	public static HibernateFactory getFactory() {
		if(factory==null) {
			factory=new HibernateFactory();
			factory.loadSessionFactory();
		}
		return factory;
	}

	public void loadSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		@SuppressWarnings("unchecked")
		Class<? extends Annotation> entity = (Class<? extends Annotation>) org.brijframework.util.reflect.ClassUtil.getClass(EntityConstants.JPA_ENTITY_ANNOTATION);
		org.brijframework.util.factories.ReflectionFactory.getFactory().getInternalClassList().forEach(cls->{
			if(cls.isAnnotationPresent(entity)){
				configuration.addAnnotatedClass(cls);
			}
		});
		ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(srvcReg);
	}

	public Session getSession() throws HibernateException {
		Session retSession = null;
		try {
			retSession = sessionFactory.openSession();
		} catch (Throwable t) {
			System.err.println("Exception while getting session.. ");
			t.printStackTrace();
		}
		if (retSession == null) {
			System.err.println("session is discovered null");
		}

		return retSession;
	}

}
