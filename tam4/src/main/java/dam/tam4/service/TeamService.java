package dam.tam4.service;

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
		Team newTeam=new Team();
		newTeam.setTeamId(null);
		newTeam.setName(tm.getName());
		newTeam.setProject(tm.getProject());
		newTeam.setUsers(tm.getUsers());
		newTeam.setSchedule(tm.getSchedule());
	}
	public void updateTeam(Team tm) {
		tmRepository.save(tm);
	}

	public void deleteTeam(Team tm ) {
		tmRepository.delete(tm);
	}
}