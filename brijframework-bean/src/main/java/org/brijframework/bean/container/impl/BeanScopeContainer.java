package org.brijframework.bean.container.impl;

import org.brijframework.bean.container.BeanContainer;
import org.brijframework.bean.factories.BeanScopeFactory;
import org.brijframework.bean.group.scope.BeanScopeGroup;
import org.brijframework.container.impl.module.AbstractModuleContainer;
import org.brijframework.group.Group;
import org.brijframework.support.factories.SingletonFactory;
import org.brijframework.support.ordering.DepandOn;
import org.brijframework.util.factories.ReflectionFactory;
import org.brijframework.util.reflect.InstanceUtil;

@DepandOn(depand=BeanDefinitionContainer.class)
public class BeanScopeContainer extends AbstractModuleContainer implements BeanContainer{

	private static BeanScopeContainer container;

	@SingletonFactory
	public static BeanScopeContainer getContainer() {
		if (container == null) {
			container = InstanceUtil.getSingletonInstance(BeanScopeContainer.class);
		}
		return container;
	}

	@Override
	public Group load(Object groupKey) {
		Group group = get(groupKey);
		if (group == null) {
			group = new BeanScopeGroup(groupKey);
			this.add(groupKey, group);
		}
		return group;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void init() {
		try {
			ReflectionFactory.getFactory().getExternalClassList().forEach(cls -> {
				if (BeanScopeFactory.class.isAssignableFrom(cls) && InstanceUtil.isAssignable(cls)) {
					register((Class<? extends BeanScopeFactory<?, ?>>) cls);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ReflectionFactory.getFactory().getInternalClassList().forEach(cls -> {
				if (BeanScopeFactory.class.isAssignableFrom(cls) && InstanceUtil.isAssignable(cls)) {
					register((Class<? extends BeanScopeFactory<?, ?>>) cls);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
