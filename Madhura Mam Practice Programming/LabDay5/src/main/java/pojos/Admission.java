package pojos;

import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "adimissions_tbl", uniqueConstraints = @UniqueConstraint(columnNames = { "course_id", "student_id" }))
public class Admission extends BaseEntity {
	@Column(name = "application_date")
	@CreationTimestamp
	private LocalDate applicationDate;
	@Column(name = "result_date")
	private LocalDate resultDate;
	@Enumerated(EnumType.STRING)
	private AdmissionStatus status;
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course chosenCourse;
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student candidate;

	public Admission(LocalDate applicationDate, LocalDate resultDate, Course chosenCourse, Student candidate) {
		super();
		this.applicationDate = applicationDate;
		this.resultDate = resultDate;
		this.chosenCourse = chosenCourse;
		this.candidate = candidate;
	}

	public Admission() {
		super();
	}

	public LocalDate getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		this.applicationDate = applicationDate;
	}

	public LocalDate getResultDate() {
		return resultDate;
	}

	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}

	public Course getChosenCourse() {
		return chosenCourse;
	}

	public void setChosenCourse(Course chosenCourse) {
		this.chosenCourse = chosenCourse;
	}

	public Student getCandidate() {
		return candidate;
	}

	public void setCandidate(Student candidate) {
		this.candidate = candidate;
	}

	@Override
	public String toString() {
		return "Admission [applicationDate=" + applicationDate + ", resultDate=" + resultDate + ", chosenCourse="
				+ chosenCourse + ", candidate=" + candidate + "]";
	}

}
