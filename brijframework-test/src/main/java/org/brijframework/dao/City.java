package org.brijframework.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.brijframework.Access;
import org.brijframework.support.enums.Formula;
import org.brijframework.support.model.Model;
import org.brijframework.support.model.identifier.Identity;
import org.brijframework.support.model.identifier.Strategy;
import org.brijframework.support.model.properties.ModelProperty;

@Model(access = Access.AUTO)
@Entity
public class City {
	
	@ModelProperty
	@Identity(strategy = @Strategy(formula = Formula.Sequence, init = 10))
	@Id
	@GeneratedValue
	private Integer id;

	@ModelProperty
	public String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
