package dam.tam4.controller;

import java.util.ArrayList;
import java.util.List;

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
		
		//creare lista pentru obiecte
		List<Project>projects= new ArrayList<>();
		
		//creare obiect pt lista
		Project myProject= new Project();
		myProject.setProjectId(1L);
		myProject.setName("Proiectul nr 1");
		myProject.setInternships(null);
		
		Project myProject2= new Project();
		myProject2.setProjectId(2L);
		myProject2.setName("Proiectul nr 2");
		myProject2.setInternships(null);
		
		//adaugare obiect in lista
		projects.add(myProject);
		projects.add(myProject2);
		
		//transfer obiect in forntend
		mv.addObject("projects", projects);
		
		
		return mv;
	}

	@GetMapping("/project/getProject")
	public ModelAndView getProject(@RequestParam(name = "id") Long id){
		return null;
	}

}
