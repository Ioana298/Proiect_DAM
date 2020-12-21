package dam.tam4.domain;

import java.util.List;

import javax.persistence.*;
import com.sun.istack.NotNull;

@Entity
@Table(name = "candidates")
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateId;

	@NotNull
	private String name;
	private String email;
	private Long phoneNumber;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "candidates_internships", 
			joinColumns = @JoinColumn(name = "candidateId"), 
			inverseJoinColumns = @JoinColumn(name = "internshipId"))
	private List<Internship> internships;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
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

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Internship> getInternships() {
		return internships;
	}

	public void setInternships(List<Internship> internships) {
		this.internships = internships;
	}

	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", name=" + name + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", internships=" + internships + "]";
	}
	
}

	