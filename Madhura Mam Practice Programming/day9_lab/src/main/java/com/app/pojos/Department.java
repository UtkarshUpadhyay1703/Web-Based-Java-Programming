package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="depts")
public class Department extends BaseEntity {
	@Column(name="dept_name",unique = true, length = 20)
	private String deptName;
	@Column(length = 200)
	private String location;
	public Department(String deptName, String location) {
		super();
		this.deptName = deptName;
		this.location = location;
	}
	public Department() {
		super();
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Department id= "+getId()+" [deptName=" + deptName + ", location=" + location + "]";
	}
	
}
