package dam.tam4.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.Internship;
import dam.tam4.domain.Schedule;
import dam.tam4.repository.InternshipRepository;
import dam.tam4.repository.ScheduleRepository;

@Service
@Transactional
public class ScheduleService {
private final ScheduleRepository sRepository;
	
	public ScheduleService(ScheduleRepository sRepository) {
		this.sRepository = sRepository;
	}
	
	public void addSchedule(Schedule s) {
		Schedule newSchedule=new Schedule();
		newSchedule.setScheduleId(null);
		newSchedule.setTeamId(null);
		newSchedule.setDate(s.getDate());
		newSchedule.setTask(s.gettasks());
		
		sRepository.save(newSchedule);
	}
	
	public void deleteSchedule(Schedule s) {
		sRepository.delete(s);
	}
}
	
