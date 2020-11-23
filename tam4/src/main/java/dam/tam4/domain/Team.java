package dam.tam4.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "teams")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;

	@NotNull
	private String name;
	
	@OneToMany(mappedBy="team")
	private List<User> users;

	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="scheduleId", nullable=false)
	private List<Schedule> schedules;

	@OneToOne(cascade = CascadeType.ALL)
	private Project projects;

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Project getProjects() {
		return projects;
	}

	public void setProjects(Project projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", name=" + name + ", users=" + users + ", schedules=" + schedules
				+ ", projects=" + projects + "]";
	}

	
}