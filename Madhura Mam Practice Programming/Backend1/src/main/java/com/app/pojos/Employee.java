package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emp_table")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor
@ToString(exclude = "password")
public class Employee extends BaseEntity {
	// show BeanCreationError when not extended
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 20, unique = true)
	private String password;
	@Column(length = 20)
	private String email;
	@Column(length = 200)
	private String location;
	private LocalDate date;

	public Employee(String firstName, String lastName, String password, String email, String location, LocalDate date) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.location = location;
		this.date = date;
	}

}
