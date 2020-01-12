package org.brijframework.test.jpa;

import java.lang.reflect.Field;

import org.brijframework.jpa.files.EntityData;
import org.brijframework.jpa.model.EntityModel;
import org.brijframework.jpa.processor.EntityProcessor;
import org.brijframework.util.accessor.PropertyAccessorUtil;
import org.brijframework.util.reflect.FieldUtil;
import org.brijframework.util.support.ReflectionAccess;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

public class EntityProcessorImpl implements EntityProcessor{

	private static SessionFactory sessionFactory;
	private Session session;

	@SuppressWarnings("deprecation")
	@Override
	public boolean constains(EntityData entityData,EntityModel entityModel, Object object) {
		if(entityData.getUnique()!=null && !entityData.getUnique().isEmpty()) {
			Criteria criteria= session.createCriteria(object.getClass());
			for(String key:entityData.getUnique().split(",")) {
				criteria.add(Restrictions.eq(key, PropertyAccessorUtil.getProperty(object, key,ReflectionAccess.PRIVATE)));
			}
			Object unique= criteria.uniqueResult();
			if(unique !=null) {
				mergeObject(unique,object);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean init() {
		loadSessionFactory();
		if(sessionFactory!=null) {
			session=getSession();
		}
		return true;
	}
	
	@Override
	public boolean persist(EntityData entityData,EntityModel entityModel, Object entity) {
		//System.out.println("PersistModel :"+PrintUtil.getObjectInfo(entity));
		Transaction transaction =session.getTransaction();
		transaction.begin();
		session.save(entity);
		transaction.commit();
		return false;
	}
	
	
	@Override
	public boolean update(EntityData entityData, EntityModel entityModel, Object entity) {
		//System.out.println("UpdateModel :"+PrintUtil.getObjectInfo(entity));
		Transaction transaction =session.getTransaction();
		transaction.begin();
		//session.update(entity);
		transaction.commit();
		return false;
	}

	@Override
	public boolean delete(EntityData entityData, EntityModel entityModel, Object entity) {
		//System.out.println("DeleteModel :"+PrintUtil.getObjectInfo(entity));
		Transaction transaction =session.getTransaction();
		transaction.begin();
		session.delete(entity);
		transaction.commit();
		return false;
	}
	
	private void mergeObject(Object persist,Object entity) {
		for(Field field:FieldUtil.getAllField(persist.getClass(),ReflectionAccess.PRIVATE)){
			if(field.toString().contains("final") || field.toString().contains("static")) {
				continue;
			}
			PropertyAccessorUtil.setProperty(entity,field, ReflectionAccess.PRIVATE, PropertyAccessorUtil.getProperty(persist, field,ReflectionAccess.PRIVATE));
		}
	}

	@Override
	public boolean finish() {
		if(session!=null)
			session.close();
		return false;
	}

	public static void loadSessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("/hibernate.cfg.xml");
		ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				.build();
		sessionFactory = configuration.buildSessionFactory(srvcReg);
	}

	public static Session getSession() throws HibernateException {
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
