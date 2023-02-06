package com.app.pojos;

import javax.persistence.*;

@MappedSuperclass // for not creating the table
public class BaseEntity {
	@Id // for PK
	@GeneratedValue(strategy = GenerationType.IDENTITY) // For auto inc
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
