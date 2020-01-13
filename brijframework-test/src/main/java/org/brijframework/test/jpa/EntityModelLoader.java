package org.brijframework.test.jpa;

import org.brijframework.jpa.context.EntityContext;
import org.brijframework.jpa.hibernate.processor.HibernateEntityProcessorImpl;
import org.brijframework.jpa.processor.EntityProcessor;
import org.brijframework.jpa.util.EntityConstants;

public class EntityModelLoader {
	
	public static void main(String[] args) {
		String filePath="E:\\git_hub\\brijframework\\brijframework-boot-context\\brijframework-test\\src\\main\\resources\\jpa"; //environment.getProperty(EntityConstants.IMPORT_FILES)
		EntityProcessor processor=new HibernateEntityProcessorImpl();
		EntityContext context=new EntityContext();
		context.setProperty(EntityConstants.IMPORT_FILES, filePath);
		context.setObject(EntityConstants.IMPORT_ADPTER_OBJECT, processor);
		context.start();
	}
}
