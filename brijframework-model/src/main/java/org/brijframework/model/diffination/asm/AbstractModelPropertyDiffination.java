package org.brijframework.model.diffination.asm;

import java.lang.reflect.AccessibleObject;
import java.util.HashMap;
import java.util.Map;

import org.brijframework.model.diffination.ModelPropertyDiffination;
import org.brijframework.model.diffination.ModelTypeDeffination;

public abstract class AbstractModelPropertyDiffination extends AbstractModelDiffination<AccessibleObject> implements ModelPropertyDiffination {

	private AccessibleObject type;
	private ModelTypeDeffination owner;
	private Object value;
	public boolean required;
	private Map<String,String> mapper;
	
	@Override
	public ModelTypeDeffination getOwner() {
		return owner;
	}
	
	public void setOwner(ModelTypeDeffination owner) {
		this.owner = owner;
	}
	
	public void setValue(Object value) {
		this.value = value;
	}

	@Override
	public Object getValue() {
		return value;
	}
	
	public void setType(AccessibleObject type) {
		this.type = type;
	}
	
	@Override
	public AccessibleObject getType() {
		return type;
	}
	
	
	public boolean isRequired() {
		return required;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
		
	public void setMapper(Map<String, String> mapper) {
		this.mapper = mapper;
	}
	
	public Map<String, String> getMapper() {
		if(mapper==null) {
			mapper=new HashMap<String, String>();
		}
		return mapper;
	}

	@Override
	public String toString() {
		return "ModelPropertyDiffination ["
				+ "Id=" + getId() + ", "
				+ "name=" + getName()+ ", "
				+ "type=" + type + ", "
				+ "owner=" + owner.getId() + ", "
				+ "value=" + value+ ", "
				+ "required=" + required + ", "
				+ "mapper=" + mapper + ", "
				+ "access=" + getAccess() + "]";
	}

	
}
