package org.brijframework.jpa.builder;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;

import org.brijframework.jpa.group.EntityDataGroup;
import org.brijframework.util.accessor.PropertyAccessorUtil;
import org.brijframework.util.reflect.FieldUtil;
import org.brijframework.util.support.ReflectionAccess;

public class RelationComparator implements Comparator<EntityDataGroup>{

	@Override
	public int compare(EntityDataGroup o1, EntityDataGroup o2) {
		Object entity1=o1.getEntityObject();
		Object entity2=o2.getEntityObject();
		List<Field> fields1=FieldUtil.getAllField(entity1.getClass(),ReflectionAccess.PRIVATE);
		for(Field field1: fields1) {
			Object value=PropertyAccessorUtil.getProperty(entity1, field1, ReflectionAccess.PRIVATE);
			if(value!=null && entity2.equals(value)) {
				return 1;
			}
		}
		return -1;
	}
}