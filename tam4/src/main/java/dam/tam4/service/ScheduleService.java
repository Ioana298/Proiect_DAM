package dam.tam4.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Schedule;
import dam.tam4.repository.ScheduleRepository;

@Service
@Transactional
public class ScheduleService {
	
	static Logger log = Logger.getLogger(ScheduleService.class.getName());
	
	private final ScheduleRepository sRepository;
	
	public ScheduleService(ScheduleRepository sRepository) {
		this.sRepository = sRepository;
	}
	
	public void addSchedule(HttpServletRequest request, Schedule s) {
		Schedule newSchedule=new Schedule();
		newSchedule.setScheduleId(null);
		newSchedule.setDate(s.getDate());
		newSchedule.setTasks(s.getTasks());
		
		sRepository.save(newSchedule);
		log.info("Schedule" + newSchedule.toString() + " was added by "+ request.getUserPrincipal().getName());
	}
	
	public void deleteSchedule(HttpServletRequest request, Long id) {
		log.info("Schedule " + sRepository.findById(id).get().toString() + " was deleted by "+ request.getUserPrincipal().getName());
		
		sRepository.delete(sRepository.findById(id).get());
	}
}
	
