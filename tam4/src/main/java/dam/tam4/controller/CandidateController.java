package dam.tam4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Candidate;
import dam.tam4.service.CandidateService;
import dam.tam4.service.InternshipService;

@Controller
public class CandidateController {

	private final CandidateService cService;
	private final InternshipService iService;

	public CandidateController(CandidateService cService, InternshipService iService) {
		this.cService = cService;
		this.iService = iService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/candidate/createCandidate") //terminatie URL
	public ModelAndView createCandidate(HttpServletRequest request, Candidate c){
		System.out.println(c);
		cService.addCandidate(request, c);
		return new ModelAndView ("redirect:/candidate/getAllCandidates");
	}

	@GetMapping("/candidate/getAllCandidates")
	public ModelAndView getAllCandidates() {
		ModelAndView mv = new ModelAndView("candidate");
		mv.addObject("candidates", cService.getAllCandidates());
		mv.addObject("internships", iService.getAllInternships());
		
		return mv;
	}

	@GetMapping("/candidate/getCandidate")
	public ModelAndView getCandidate(@RequestParam(name = "id") Long id){
		return null;
	}
	
	@PostMapping("/candidate/updateCandidate")
	public ModelAndView updateCandidate(HttpServletRequest request, Candidate c) {
		cService.updateCandidate(request, c);
	
		return new ModelAndView ("redirect:/candidate/getAllCandidates");
	}
	
	@GetMapping("/candidate/deleteCandidate")
	public ModelAndView deleteCandidate(HttpServletRequest request, @RequestParam(name = "id") Long id) {
		cService.deleteCandidate(request, id);
	
		return new ModelAndView ("redirect:/candidate/getAllCandidates");
	}
}
