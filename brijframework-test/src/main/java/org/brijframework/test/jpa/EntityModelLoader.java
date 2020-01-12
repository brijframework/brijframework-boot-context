package org.brijframework.test.jpa;

import org.brijframework.jpa.context.EntityContext;
import org.brijframework.jpa.processor.EntityProcessor;
import org.brijframework.jpa.util.EntityConstants;

public class EntityModelLoader {
	
	public static void main(String[] args) {
		String filePath=""; //environment.getProperty(EntityConstants.IMPORT_FILES)
		EntityProcessor processor=new EntityProcessorImpl();
		//if(environment.containsProperty(EntityConstants.IMPORT_FILES)) {
			
		//}else {
			System.err.println("EntityModelBuilder does not config 'jpa.properties.import_files'");
		//}
			EntityContext context=new EntityContext();
			context.setProperty(EntityConstants.IMPORT_FILES, filePath);
			context.setObject(EntityConstants.IMPORT_ADPTER_OBJECT, processor);
			context.start();
	}
	
}
