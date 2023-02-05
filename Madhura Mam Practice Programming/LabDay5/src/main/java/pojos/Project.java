package pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "projects_tbl")
public class Project extends BaseEntity {
	@Column(length = 50)
	private String title;
	@Column(name = "completion_date")
	private LocalDate completionDate;
	@ManyToMany
	@JoinTable(name = "project_students", joinColumns = @JoinColumn(name="project_id"),inverseJoinColumns = @JoinColumn(name="student_id"))
	private Set<Student> students = new HashSet<>();

	public Project() {
		super();
	}

	public Project(String title, LocalDate completionDate) {
		super();
		this.title = title;
		this.completionDate = completionDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
