package org.brijframework.jpa.hibernate.test;

import org.brijframework.jpa.context.EntityContext;
import org.brijframework.jpa.hibernate.processor.HibernateEntityProcessorImpl;
import org.brijframework.jpa.processor.EntityProcessor;
import org.brijframework.jpa.util.EntityConstants;

public class EntityModelLoader {
	
	public static void main(String[] args) {
		String filePath="\\jpa"; //environment.getProperty(EntityConstants.IMPORT_FILES)
		EntityProcessor processor=new HibernateEntityProcessorImpl();
		EntityContext context=new EntityContext();
		context.setProperty(EntityConstants.IMPORT_FILES, filePath);
		context.setObject(EntityConstants.IMPORT_ADPTER_OBJECT, processor);
		context.start();
	}
	
}
