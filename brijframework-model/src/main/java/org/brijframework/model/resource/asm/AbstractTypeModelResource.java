package org.brijframework.model.resource.asm;

import java.util.HashMap;
import java.util.Map;

import org.brijframework.model.resource.TypeModelResource;
import org.brijframework.model.resource.ConstructorModelResource;
import org.brijframework.model.resource.PropertyModelResource;

public abstract class AbstractTypeModelResource extends AbstractModelResource<String> implements TypeModelResource{

	private String type;
	private String extend;

	private Map<String, PropertyModelResource<?>> properties;
		
	private ConstructorModelResource<?> constructor;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void setExtend(String extend) {
		this.extend = extend;
	}
	
	public String getExtend() {
		return extend;
	}
	
	public ConstructorModelResource<?> getConstructor() {
		return constructor;
	}
	
	public void setConstructor(ConstructorModelResource<?> constructor) {
		this.constructor = constructor;
	}

	public Map<String, PropertyModelResource<?>> getProperties() {
		if(properties==null) {
			properties=new HashMap<>();
		}
		return properties;
	}

	public void setProperties(Map<String, PropertyModelResource<?>> properties) {
		this.properties = properties;
	}

}
