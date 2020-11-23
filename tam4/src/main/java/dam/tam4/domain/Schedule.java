package dam.tam4.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table ( name = "schedules")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;
	private LocalDate Date;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Task> tasks;



	public Long getScheduleId() {
		return scheduleId;
	}


	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}


	public LocalDate getDate() {
		return Date;
	}


	public void setDate(LocalDate date) {
		Date = date;
	}


	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", Date=" + Date + ", tasks=" + tasks + "]";
	}




	


}