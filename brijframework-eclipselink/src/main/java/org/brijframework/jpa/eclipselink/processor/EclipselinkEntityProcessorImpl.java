package org.brijframework.jpa.eclipselink.processor;

import java.lang.reflect.Field;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.brijframework.jpa.eclipselink.factories.EclipselinkFactory;
import org.brijframework.jpa.files.EntityData;
import org.brijframework.jpa.model.EntityModel;
import org.brijframework.jpa.processor.EntityProcessor;
import org.brijframework.util.accessor.PropertyAccessorUtil;
import org.brijframework.util.reflect.FieldUtil;
import org.brijframework.util.support.ReflectionAccess;

public class EclipselinkEntityProcessorImpl implements EntityProcessor{

	private EntityManager session;

	@Override
	public boolean constains(EntityData entityData,EntityModel entityModel, Object object) {
		if(entityData.getUnique()!=null && !entityData.getUnique().isEmpty()) {
			CriteriaBuilder criteria= session.getCriteriaBuilder();
			CriteriaQuery<Object> queryObj = criteria.createQuery();
	        Root<?> root = queryObj.from(object.getClass());
	       
			for(String key:entityData.getUnique().split(",")) {
				criteria.and(criteria.equal( root.get(key), PropertyAccessorUtil.getProperty(object, key,ReflectionAccess.PRIVATE)));
			}
		}
		return false;
	}
	
	@Override
	public boolean init() {
		session=EclipselinkFactory.getFactory().getSession();
		return true;
	}
	
	@Override
	public boolean persist(EntityData entityData,EntityModel entityModel, Object entity) {
		//System.out.println("PersistModel :"+PrintUtil.getObjectInfo(entity));
		EntityTransaction transaction =session.getTransaction();
		transaction.begin();
		session.persist(entity);
		transaction.commit();
		return false;
	}
	
	
	@Override
	public boolean update(EntityData entityData, EntityModel entityModel, Object entity) {
		//System.out.println("UpdateModel :"+PrintUtil.getObjectInfo(entity));
		EntityTransaction transaction =session.getTransaction();
		transaction.begin();
		//session.update(entity);
		transaction.commit();
		return false;
	}

	@Override
	public boolean delete(EntityData entityData, EntityModel entityModel, Object entity) {
		//System.out.println("DeleteModel :"+PrintUtil.getObjectInfo(entity));
		EntityTransaction transaction =session.getTransaction();
		transaction.begin();
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
	
}
