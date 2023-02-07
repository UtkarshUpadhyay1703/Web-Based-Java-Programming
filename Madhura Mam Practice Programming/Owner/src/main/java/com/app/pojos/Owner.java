package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner extends BaseEntity {
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String email;
	@Column(length=20)
	private String password;
	@Column(length=10)
	private String phoneNo;
	@OneToMany(mappedBy = "propOwner",fetch = FetchType.EAGER)
	List<Properties> properties=new ArrayList<>();
			
	public Owner(String name, String email, String password, String phoneNo) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}

	public Owner() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
