package pojos;

import java.time.LocalDate;
import javax.persistence.*;

//Employee : id (auto_increment : PK) , first name ,last name , department 
//(enum : RND,FINANCE,MARKETING,HR,BILLING), salary, dob(LocalDate) ,isPermanent(boolean)
@Entity
@Table(name="emps",uniqueConstraints = @UniqueConstraint(columnNames = {"first_name","last_name"}))
public class Employee {
	@Id//PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)//=>auto_incremented ids 
	@Column(name="emp_id")
	private Long id;// why Long because it is serializable
	@Column(name="first_name",length=30)
	private String firstName;
	@Column(name="last_name",length=30)
	private String lastName;
	@Enumerated(EnumType.STRING)//col type: varchar,enum character
	@Column(length=25)
	private Departmanet dept;
	private double salary;
	private LocalDate dob;
	@Column(name="is_permanent")
	private boolean isPermanent;

	public Employee() {
		super();
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Employee(String firstName, String lastName, Departmanet dept, LocalDate dob, boolean isPermanent, double salary ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
		this.dob = dob;
		this.isPermanent = isPermanent;
		this.salary=salary;
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

	public Departmanet getDept() {
		return dept;
	}

	public void setDept(Departmanet dept) {
		this.dept = dept;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isPermanent() {
		return isPermanent;
	}

	public void setPermanent(boolean isPermanent) {
		this.isPermanent = isPermanent;
	}

}
