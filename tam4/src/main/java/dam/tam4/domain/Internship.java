package dam.tam4.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

@Entity
@Table(name = "internships")
public class Internship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long internshipId;
	
	@NotNull
	private String name;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate endDate;
	
	private Boolean isPaid;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="projectID", nullable=false)
	private Project project;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "candidates_internships", joinColumns = @JoinColumn(name = "internshipId"), inverseJoinColumns = @JoinColumn(name = "candidateId"))
	private List<Candidate> candidates;

	public Long getInternshipId() {
		return internshipId;
	}

	public void setInternshipId(Long internshipId) {
		this.internshipId = internshipId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(Boolean isPaid) {
		this.isPaid = isPaid;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	@Override
	public String toString() {
		return "Internship [internshipId=" + internshipId + ", name=" + name + ", startDate=" + startDate + ", endDate="
				+ endDate + ", isPaid=" + isPaid + ", project=" + project + ", candidates=" + candidates + "]";
	}

}
