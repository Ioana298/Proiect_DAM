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
		newTeam.setProjects(tm.getProjects());
		newTeam.setUsers(tm.getUsers());
	}
		public void updateTeam(Team tm) {
		tmRepository.update(tm);
	}
	
	public void deleteTeam(Team tm ) {
		tmRepository.delete(tm);
	}
}