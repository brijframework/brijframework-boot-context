package org.brijframework.jpa.hibernate.factories;


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
		configuration.configure("/hibernate.cfg.xml");
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
