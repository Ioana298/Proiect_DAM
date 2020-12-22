package dam.tam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Task;
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
		return mv;
	}

	@GetMapping("/tTask/getTask")
	public ModelAndView getTask(@RequestParam(name = "id") Long id){
		return null;
	}

}
