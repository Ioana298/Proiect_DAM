package dam.tam4.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Team;
import dam.tam4.domain.User;
import dam.tam4.repository.TeamRepository;
import dam.tam4.repository.UserRepository;

@Service
@Transactional
public class TeamService {

	static Logger log = Logger.getLogger(TeamService.class.getName());
	
	private final TeamRepository tmRepository;
	private final UserRepository uRepository;

	public TeamService(TeamRepository tmRepository, UserRepository uRepository) {
		this.tmRepository = tmRepository;
		this.uRepository = uRepository;
	}

	public void addTeam(HttpServletRequest request, Team tm) {
		for (User u : tm.getUsers()) {
			User existentU = uRepository.findById(u.getUserId()).get();

			existentU.setTeam(saveTeam(request, tm));
			log.info("User's team " + tm.toString() + " was added by "+ request.getUserPrincipal().getName());
		}
	}

	public Team saveTeam(HttpServletRequest request, Team tm) {
		Team newTeam = new Team();
		newTeam.setTeamId(null);
		newTeam.setName(tm.getName());
		newTeam.setProject(tm.getProject());
		
		tmRepository.save(newTeam);
		log.info("Team " + newTeam.toString() + " was added by "+ request.getUserPrincipal().getName());
		
		return newTeam;
	}

	public void deleteTeam(HttpServletRequest request, Long id) {
		log.info("Team " + tmRepository.findById(id).get().toString() + " was deleted by "+ request.getUserPrincipal().getName());
		
		tmRepository.delete(tmRepository.findById(id).get());
	}

	public void updateTeam(HttpServletRequest request, Team tm) {
		Optional<Team> possibleTeam = tmRepository.findById(tm.getTeamId());
		Team existingTeam = possibleTeam.get();
		existingTeam.setName(tm.getName());
		existingTeam.setProject(tm.getProject());

		tmRepository.save(existingTeam);
		log.info("Team " + existingTeam.toString() + " was updated by "+ request.getUserPrincipal().getName());
	}

	public List<Team> getAllTeams() {
		return tmRepository.findAll();
	}
}