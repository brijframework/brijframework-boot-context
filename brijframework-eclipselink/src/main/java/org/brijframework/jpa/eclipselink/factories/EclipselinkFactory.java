package org.brijframework.jpa.eclipselink.factories;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EclipselinkFactory {

	private static EclipselinkFactory factory;
	
	public static EclipselinkFactory getFactory() {
		if(factory==null) {
			factory=new EclipselinkFactory();
			factory.loadSessionFactory();
		}
		return factory;
	}

	private EntityManagerFactory entityManagerFactory;

	public void loadSessionFactory() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("PERSISTENCE");
	}

	public EntityManager getSession() throws RuntimeException {
		EntityManager retSession = null;
		try {
			retSession = entityManagerFactory.createEntityManager();
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
