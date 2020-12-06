package dam.tam4.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.Task;
import dam.tam4.repository.TaskRepository;

@Service
@Transactional
public class TaskService {
	
private final TaskRepository tRepository;
	
	public TaskService(TaskRepository tRepository) {
		this.tRepository = tRepository;
	}
	
	public void addTask(Task t) {
		Task newTask=new Task();
		newTask.setTaskId(null);
		newTask.setName(t.getName());
	}
		public void updateTask(Task t) {
			
			
		tRepository.save(t);
	}
	
	public void deleteTask(Task t ) {
		tRepository.delete(t);
	}
}
