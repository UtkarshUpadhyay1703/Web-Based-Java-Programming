package pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "students_tbl")
public class Student extends BaseEntity {
	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(length = 30, unique = true)
	private String email;
	@OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Admission> admissions = new ArrayList<>();
	
	@ManyToMany(mappedBy = "students",cascade = CascadeType.ALL)
	private Set<Project> projects=new HashSet<>();
	
	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}	
	
	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Admission> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(List<Admission> admissions) {
		this.admissions = admissions;
	}

	@Override
	public String toString() {
		return "Student id= " + getId() + " [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

}
