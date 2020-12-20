package dam.tam4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Candidate;
import dam.tam4.domain.User;
import dam.tam4.service.CandidateService;

@Controller
public class CandidateController {

	private final CandidateService cService;

	public CandidateController(CandidateService cService) {
		this.cService = cService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/candidate/createCandidate") //terminatie URL
	public ModelAndView createCandidate(Candidate c){
		cService.addCandidate(c);
		return new ModelAndView ("redirect:/candidate/getAllCandidates");
	}

	@GetMapping("/candidate/getAllCandidates")
	public ModelAndView getAllCandidates() {
		ModelAndView mv = new ModelAndView("candidate");
		mv.addObject("candidates", cService.getAllCandidates());
		
		return mv;
	}

	@GetMapping("/candidate/getCandidate")
	public ModelAndView getCandidate(@RequestParam(name = "id") Long id){
		return null;
	}
}
