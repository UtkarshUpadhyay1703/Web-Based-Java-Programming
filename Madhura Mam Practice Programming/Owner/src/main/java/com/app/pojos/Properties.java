package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "property")
public class Properties extends BaseEntity {
	private String property;
	private PropertyFor prop;
	@OneToOne
	@JoinColumn(name = "owner_fk")
	private Owner propOwner;
	public Properties(String property, PropertyFor prop) {
		super();
		this.property = property;
		this.prop = prop;
	}

	public Properties() {
		super();
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public PropertyFor getProp() {
		return prop;
	}

	public void setProp(PropertyFor prop) {
		this.prop = prop;
	}

}
