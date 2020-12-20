package dam.tam4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Project;
import dam.tam4.domain.Team;
import dam.tam4.service.ProjectService;
import dam.tam4.service.TeamService;

@Controller
public class TeamController {
	private final TeamService tmService;

	public TeamController(TeamService tmService) {
		this.tmService = tmService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/team/createTeam") //terminatie URL
	public void createTeam(Team tm){
		tmService.addTeam(tm);
	}

	@GetMapping("/team/getAllTeams")
	public ModelAndView getAllTeams() {
		ModelAndView mv = new ModelAndView("team");
		
		//creare lista pentru obiecte
		List<Team>teams= new ArrayList<>();
		
		//creare obiect pt lista
		Team myTeam= new Team();
		myTeam.setTeamId(1L);
		myTeam.setName("Echipa nr 1");
		myTeam.setInternships(null);
		
		Team myTeam2= new Team();
		myTeam.setTeamId(1L);
		myTeam.setName("Echipa nr 2");
		myTeam.setInternships(null);
		
		//adaugare obiect in lista
		teams.add(myTeam);
		teams.add(myTeam2);
		
		//transfer obiect in forntend
		mv.addObject("teams", teams);
		
		return mv;
	}

	@GetMapping("/team/getTeam")
	public ModelAndView getTeam(@RequestParam(name = "id") Long id){
		return null;
	}

}
