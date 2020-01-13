package org.brijframework.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.brijframework.Access;
import org.brijframework.bean.BeanObject;
import org.brijframework.support.bean.Bean;
import org.brijframework.support.bean.BeanConstruct;
import org.brijframework.support.bean.BeanParam;
import org.brijframework.support.bean.properties.BeanProperty;
import org.brijframework.support.enums.Formula;
import org.brijframework.support.enums.Scope;
import org.brijframework.support.model.Model;
import org.brijframework.support.model.ModelConstruct;
import org.brijframework.support.model.ModelParam;
import org.brijframework.support.model.identifier.Identity;
import org.brijframework.support.model.identifier.Strategy;
import org.brijframework.support.model.logics.Logic;
import org.brijframework.support.model.mapper.ModelMapper;
import org.brijframework.support.model.properties.ModelProperty;
import org.brijframework.support.model.properties.ModelRelation;

@Model(
	id = "Address_001", 
	access = Access.AUTO, 
	constructor = @ModelConstruct(
		params = {
			  @ModelParam(type = String.class, index = 0), 
			  @ModelParam(type = String.class, index = 1) 
			}
		)
	, 
	properties = {
		@ModelProperty(name = "line"), 
		@ModelProperty(name = "landMark") 
	}
)
@Bean(
	id = "Address_001", 
	scope=Scope.PROTOTYPE, 
	model = "Address_001", 
	constructor = @BeanConstruct(
		params = {
			@BeanParam(index = 0, value="J603"),
			@BeanParam(index = 1, value="Global School")
		}
	)
)
@Model
@Bean(scope=Scope.SESSION)
@ModelMapper(source = "")
@Entity
public class Address implements BeanObject {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public Address() {
	}

	public Address(String line, String landMark) {
		this.line = line;
		this.landMark = landMark;
		System.out.println(line+" = = "+landMark);
	}
	
	@ModelProperty
	@Identity(strategy = @Strategy(formula = Formula.Sequence, init = 10))
	@Id
	@GeneratedValue
	private Integer id;

	@ModelProperty(access=Access.READ_ONLY)
	@BeanProperty("Sector 71")
	public String line;

	@ModelMapper(source = "LANDMARK", destination="landMark")
	@ModelProperty
	@BeanProperty
	private String landMark;
	
	@ModelRelation
	@ManyToOne
	private Employee employee;

	@ModelRelation(mappedBy = "City")
	@ManyToOne
	private City city;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Logic
	public void logicInfo() {
	}

	@Logic
	public void logicInfo(int i) {

	}

	@Logic
	public void logicInfo(String i) {

	}

	@Logic
	public void logicInfo(String i, int j) {

	}

	@Override
	public <T> T setProperty(String _keyPath, T _value) {
		System.out.println("Address ppt call");
		return BeanObject.super.setProperty(_keyPath, _value);
	}

	@Override
	public String toString() {
		return super.toString()+"[line=" + line + ", city=" + city + ", landMark=" + landMark + "]";
	}
	
	
}
