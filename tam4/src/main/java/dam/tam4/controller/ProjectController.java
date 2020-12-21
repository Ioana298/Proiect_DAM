package dam.tam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Internship;
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
	public ModelAndView createProject(Project p){
		pService.addProject(p);
		return new ModelAndView ("redirect:/project/getAllProjects");
	}

	@GetMapping("/project/getAllProjects")
	public ModelAndView getAllProjects() {
		ModelAndView mv = new ModelAndView("project");
		//transfer obiect in forntend
		mv.addObject("projects", pService.getAllProjects());
		
		return mv;
	}

	@GetMapping("/project/getProject")
	public ModelAndView getProject(@RequestParam(name = "id") Long id){
		return null;
	}
	
	@PostMapping("/project/updateProject")
	public ModelAndView updateInternship(Project p) {
		pService.updateProject(p);
	
		return new ModelAndView ("redirect:/project/getAllProjects");
	}
	
	@GetMapping("/project/deleteProject")
	public ModelAndView deleteInternship(@RequestParam(name = "id") Long id) {
		pService.deleteProject(id);
	
		return new ModelAndView ("redirect:/project/getAllProjects");
	}
}
