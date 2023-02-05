package pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "courses_tbl")
public class Course extends BaseEntity {
	@Column(name = "title", unique = true, length = 100)
	private String courseTitle;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	private double fee;
	private int capacity;
	@OneToMany(mappedBy = "chosenCourse", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Admission> admissions = new ArrayList<>();

	public Course() {
		super();
	}

	public Course(String courseTitle, LocalDate startDate, LocalDate endDate, double fee, int capacity) {
		super();
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fee = fee;
		this.capacity = capacity;
	}

	public List<Admission> getAdmissions() {
		return admissions;
	}

	public void setAdmissions(List<Admission> admissions) {
		this.admissions = admissions;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Course id= " + getId() + " [courseTitle=" + courseTitle + ", startDate=" + startDate + ", endDate="
				+ endDate + ", fee=" + fee + ", capacity=" + capacity + "]";
	}

}
