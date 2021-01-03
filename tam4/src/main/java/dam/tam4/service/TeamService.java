package dam.tam4.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.Team;
import dam.tam4.domain.User;
import dam.tam4.repository.TeamRepository;
import dam.tam4.repository.UserRepository;

@Service
@Transactional
public class TeamService {

	private final TeamRepository tmRepository;
	private final UserRepository uRepository;

	public TeamService(TeamRepository tmRepository, UserRepository uRepository) {
		this.tmRepository = tmRepository;
		this.uRepository = uRepository;
	}

	public void addTeam(Team tm) {
		for (User u : tm.getUsers()) {
			User existentU = uRepository.findById(u.getUserId()).get();

			existentU.setTeam(saveTeam(tm));
		}
	}

	public Team saveTeam(Team tm) {
		Team newTeam = new Team();
		newTeam.setTeamId(null);
		newTeam.setName(tm.getName());
		newTeam.setProject(tm.getProject());
		tmRepository.save(newTeam);

		return newTeam;
	}

	public void deleteTeam(Long id) {
		tmRepository.delete(tmRepository.findById(id).get());
	}

	public void updateTeam(Team tm) {
		Optional<Team> possibleTeam = tmRepository.findById(tm.getTeamId());
		Team existingTeam = possibleTeam.get();
		existingTeam.setName(tm.getName());
		existingTeam.setProject(tm.getProject());

		tmRepository.save(existingTeam);
	}

	public List<Team> getAllTeams() {
		return tmRepository.findAll();
	}
}