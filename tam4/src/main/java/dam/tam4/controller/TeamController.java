package dam.tam4.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Team;
import dam.tam4.service.ProjectService;
import dam.tam4.service.TeamService;
import dam.tam4.service.UserService;

@Controller
public class TeamController {
	private final TeamService tmService;
	private final UserService uService;
	private final ProjectService pService;

	public TeamController(TeamService tmService, UserService uService, ProjectService pService) {
		this.tmService = tmService;
		this.uService = uService;
		this.pService = pService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/team/createTeam") //terminatie URL
	public ModelAndView createTeam(HttpServletRequest request, Team tm){
		System.out.println(tm);
		tmService.addTeam(request, tm);
		return new ModelAndView ("redirect:/team/getAllTeams");
	}

	@GetMapping("/team/getAllTeams")
	public ModelAndView getAllTeams() {
		ModelAndView mv = new ModelAndView("team");
		mv.addObject("teams", tmService.getAllTeams());
		mv.addObject("users", uService.getAllUsers());
		mv.addObject("projects", pService.getAllProjects());
		
		return mv;
	}
	@GetMapping("/team/getTeam")
	public ModelAndView getTeam(@RequestParam(name = "id") Long id){
		return null;
	}
	
	@PostMapping("/team/updateTeam")
	public ModelAndView updateTeam(HttpServletRequest request, Team tm) {
		tmService.updateTeam(request, tm);
	
		return new ModelAndView ("redirect:/team/getAllTeams");
	}
	
	@GetMapping("/team/deleteTeam")
	public ModelAndView deleteTeam(HttpServletRequest request, @RequestParam(name = "id") Long id) {
		tmService.deleteTeam(request, id);
	
		return new ModelAndView ("redirect:/team/getAllTeams");
	}
}