package dam.tam4.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.Team;
import dam.tam4.repository.TeamRepository;

@Service
@Transactional
public class TeamService {

	private final TeamRepository tmRepository;
	

	public TeamService(TeamRepository tmRepository) {
		this.tmRepository = tmRepository;
	}

	public void addTeam(Team tm) {

		Team newTeam = new Team();
		newTeam.setTeamId(null);
		newTeam.setName(tm.getName());
		newTeam.setProject(tm.getProject());
		newTeam.setUsers(tm.getUsers());

		tmRepository.save(newTeam);
	}

	public void deleteTeam(Long id) {
		tmRepository.delete(tmRepository.findById(id).get());
	}

	public void updateTeam(Team tm) {
		Optional <Team> possibleTeam = tmRepository.findById(tm.getTeamId());
		Team existingTeam=possibleTeam.get();
		existingTeam.setName(tm.getName());
		existingTeam.setProject(tm.getProject());
		existingTeam.setUsers(tm.getUsers());

		tmRepository.save(existingTeam);
	}
	public List <Team> getAllTeams(){
		return tmRepository.findAll();
	}
}