package dam.tam4.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Task;
import dam.tam4.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
	
	static Logger log = Logger.getLogger(TaskService.class.getName());
	
	private final TaskRepository tRepository;
	
	public TaskService(TaskRepository tRepository) {
		this.tRepository = tRepository;
	}
	
	public void addTask(HttpServletRequest request, Task t) {
		Task newTask=new Task();
		newTask.setTaskId(null);
		newTask.setName(t.getName());
		
		tRepository.save(newTask);
		log.info("Task " + newTask.toString() + " was added by "+ request.getUserPrincipal().getName());
	}
		public void updateTask(HttpServletRequest request, Task t) {
			
			
		tRepository.save(t);
		log.info("Task " + t.toString() + " was updated by "+ request.getUserPrincipal().getName());
	}
	
	public void deleteTask(HttpServletRequest request, Long id) {
		log.info("Task " + tRepository.findById(id).get().toString() + " was deleted by "+ request.getUserPrincipal().getName());
		tRepository.delete(tRepository.findById(id).get());
	}
}
