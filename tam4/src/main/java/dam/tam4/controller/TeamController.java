package dam.tam4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Candidate;
import dam.tam4.domain.Team;
import dam.tam4.service.TeamService;
import dam.tam4.service.UserService;

@Controller
public class TeamController {
	private final TeamService tmService;
	private final UserService uService;

	public TeamController(TeamService tmService, UserService uService) {
		this.tmService = tmService;
		this.uService = uService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/team/createTeam") //terminatie URL
	public ModelAndView createTeam(Team tm){
		System.out.println(tm);
		tmService.addTeam(tm);
		return new ModelAndView ("redirect:/team/getAllTeams");
	}

	@GetMapping("/team/getAllTeams")
	public ModelAndView getAllTeams() {
		ModelAndView mv = new ModelAndView("team");
		mv.addObject("teams", tmService.getAllTeams());
		mv.addObject("users", uService.getAllUsers());
		
		return mv;
	}
	@GetMapping("/team/getTeam")
	public ModelAndView getTeam(@RequestParam(name = "id") Long id){
		return null;
	}
	
	@PostMapping("/team/updateTeam")
	public ModelAndView updateTeam(Team tm) {
		tmService.updateTeam(tm);
	
		return new ModelAndView ("redirect:/team/getAllTeams");
	}
	
	@GetMapping("/team/deleteTeam")
	public ModelAndView deleteTeam(@RequestParam(name = "id") Long id) {
		tmService.deleteTeam(id);
	
		return new ModelAndView ("redirect:/team/getAllTeams");
	}
}