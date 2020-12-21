package dam.tam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Internship;
import dam.tam4.service.InternshipService;
import dam.tam4.service.ProjectService;

@Controller
public class InternshipController {

	private final InternshipService iService;
	private final ProjectService pService;


	public InternshipController(InternshipService iService, ProjectService pService) {
		this.iService = iService;
		this.pService = pService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/internship/createInternship") //terminatie URL
	public ModelAndView createInternship(Internship i){
		iService.addInternship(i);
		return new ModelAndView ("redirect:/internship/getAllInternships");
	}

	@GetMapping("/internship/getAllInternships")
	public ModelAndView getAllInternships() {
		ModelAndView mv = new ModelAndView("internship");
		mv.addObject("internships", iService.getAllInternships());
		mv.addObject("projects", pService.getAllProjects());

		return mv;
	}

	@GetMapping("/internship/getInternship")
	public ModelAndView getInternship(@RequestParam(name = "id") Long id){
		return null;
	}

	@PostMapping("/internship/updateInternship")
	public ModelAndView updateInternship(Internship i) {
		iService.updateInternship(i);
	
		return new ModelAndView ("redirect:/internship/getAllInternships");
	}
	
	@GetMapping("/internship/deleteInternship")
	public ModelAndView deleteInternship(@RequestParam(name = "id") Long id) {
		iService.deleteInternship(id);
	
		return new ModelAndView ("redirect:/internship/getAllInternships");
	}
}
