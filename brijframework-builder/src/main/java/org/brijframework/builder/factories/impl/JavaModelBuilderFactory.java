package org.brijframework.builder.factories.impl;

import java.io.File;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.brijframework.builder.asm.JavaModelBuilder;
import org.brijframework.builder.factories.BuilderFactory;
import org.brijframework.container.Container;

public class JavaModelBuilderFactory implements BuilderFactory {
	
	private static JavaModelBuilderFactory factory;
	private static Logger logger = Logger.getLogger(JavaModelBuilderFactory.class.getName());
	private Container container;
	private ConcurrentHashMap<Object, Object> cache = new ConcurrentHashMap<>();
	public JavaModelBuilderFactory() {
	}

	public static JavaModelBuilderFactory getFactory() {
		if (factory == null) {
			factory = new JavaModelBuilderFactory();
		}
		return factory;
	}
	
	public JavaModelBuilderFactory loadFactory(String path) {
		return loadFactory(new File(path));
	}

	public JavaModelBuilderFactory loadFactory(File path) {
		Objects.requireNonNull(path, "Path should not be null");
		if (path.isDirectory()) {
			for (File file : path.listFiles()) {
				load(file);
			}
		} else {
			load(path);
		}
		return this;
	}

	private void load(File path) {
		try {
			new JavaModelBuilder(path).build();
		} catch (Exception e) {
			logger.log(Level.ALL, e.getMessage(), e);
		}
	}

	@Override
	public JavaModelBuilderFactory loadFactory() {
		return this;
	}

	@Override
	public Container getContainer() {
		return container;
	}

	@Override
	public void setContainer(Container container) {
		this.container=container;
	}

	@Override
	public ConcurrentHashMap<Object, Object> getCache() {
		return cache;
	}

	@Override
	public JavaModelBuilderFactory clear() {
		getCache().clear();
		return this;
	}

	@Override
	public Object register(Object key, Object data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object find(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object dataSetup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadContainer(Object key, Object value) {
		// TODO Auto-generated method stub
		
	}
}
