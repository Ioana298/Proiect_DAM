package dam.tam4.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table ( name = "tasks")
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy = "tasks") 
	private List<Schedule> schedules;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", name=" + name + ", schedules=" + schedules + "]";
	}

	public void setDomain(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setUser(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setStartDate(LocalDate of) {
		// TODO Auto-generated method stub
		
	}

	public void setEndDate(LocalDate of) {
		// TODO Auto-generated method stub
		
	}
	

}
