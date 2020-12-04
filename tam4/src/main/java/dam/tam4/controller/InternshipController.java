package dam.tam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Internship;
import dam.tam4.service.InternshipService;

@Controller
public class InternshipController {

	private final InternshipService iService;

	public InternshipController(InternshipService iService) {
		this.iService = iService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/internship/createInternship") //terminatie URL
	public void createInternship(Internship i){
		iService.addInternship(i);
	}

	@GetMapping("/internship/getAllInternships")
	public ModelAndView getAllInternships() {
		ModelAndView mv = new ModelAndView("internship");
		return mv;
	}

	@GetMapping("/iInternship/getInternship")
	public ModelAndView getInternship(@RequestParam(name = "id") Long id){
		return null;
	}
}
