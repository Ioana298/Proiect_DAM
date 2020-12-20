package dam.tam4.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Task;
import dam.tam4.domain.User;
import dam.tam4.service.TaskService;

@Controller
public class TaskController {
	private final TaskService tService;

	public TaskController(TaskService tService) {
		this.tService = tService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/task/createTask") //terminatie URL
	public void createTask(Task t){
		tService.addTask(t);
	}

	@GetMapping("/task/getAllTasks")
	public ModelAndView getAllTasks() {
		ModelAndView mv = new ModelAndView("task");
		
		//creare lista pentru obiecte
		List<Task> tasks = new ArrayList<>();
		
		
		Task myTask= new Task();
		myTask.setTaskId(1L);
		myTask.setDomain("IT");
		myTask.setStartDate(LocalDate.of(2021, 4, 1));
		myTask.setEndDate(LocalDate.of(2021, 5, 1));
		myTask.setUser(null);
		
		//adaugare obiect
		tasks.add(myTask);
		
		//transfer obiect in frontend
		mv.addObject("task", tasks);
		
		return mv;
	}

	@GetMapping("/tTask/getTask")
	public ModelAndView getTask(@RequestParam(name = "id") Long id){
		return null;
	}

}
