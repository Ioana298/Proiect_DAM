package dam.tam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Project;
import dam.tam4.service.ProjectService;

@Controller
public class ProjectController {
	
	private final ProjectService pService;

	public ProjectController(ProjectService pService) {
		this.pService = pService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/project/createProject") //terminatie URL
	public void createProject(Project p){
		pService.addProject(p);
	}

	@GetMapping("/project/getAllProjects")
	public ModelAndView getAllProjects() {
		ModelAndView mv = new ModelAndView("project");
		return mv;
	}

	@GetMapping("/project/getProject")
	public ModelAndView getProject(@RequestParam(name = "id") Long id){
		return null;
	}

}
