package dam.tam4.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;



@Entity
@Table ( name = "schedules")
public class Schedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;
	private Long teamId;
	private LocalDate Date;
	
	
@NotNull
private String name;


public Long getScheduleId() {
	return scheduleId;
}


public void setScheduleId(Long scheduleId) {
	this.scheduleId = scheduleId;
}


public Long getTeamId() {
	return teamId;
}


public void setTeamId(Long teamId) {
	this.teamId = teamId;
}


public LocalDate getDate() {
	return Date;
}


public void setDate(LocalDate date) {
	Date = date;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


@Override
public String toString() {
	return "Schedule [scheduleId=" + scheduleId + ", teamId=" + teamId + ", Date=" + Date + ", name=" + name + "]";
}

	
}