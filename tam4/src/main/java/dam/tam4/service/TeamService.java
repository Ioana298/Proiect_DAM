package dam.tam4.service;

import java.util.ArrayList;
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

		Team newTeam = new Team();
		newTeam.setTeamId(null);
		newTeam.setName(tm.getName());
		newTeam.setUsers(tm.getUsers() == null? null: saveUser(tm.getUsers()));

		tmRepository.save(newTeam);
	}

	public void deleteTeam(Long id) {
		tmRepository.delete(tmRepository.findById(id).get());
	}

	public void updateTeam(Team tm) {
		Optional <Team> possibleTeam = tmRepository.findById(tm.getTeamId());
		Team existingTeam=possibleTeam.get();
		existingTeam.setName(tm.getName());
		existingTeam.setUsers(tm.getUsers() == null? null: saveUser(tm.getUsers()));

		tmRepository.save(existingTeam);
	}
	public List <Team> getAllTeams(){
		return tmRepository.findAll();
	}

	private List<User> saveUser(List<User> appliedUsers){

		//Lista goala ce va contine userii din baza de date
		List<User> existentUsers = new ArrayList<>();

		//iteram prin lista trimisa din interfata / modal
		for (User u : appliedUsers) {

			// pentru fiecare element din modal, luam id-ul si cautam pe baza lui user-ul din baza de date
			User existentUser = uRepository.findById(u.getUserId()).get();
			
			//adaugam fiecare user gasit in lista
			existentUsers.add(existentUser);
			}
		
		System.out.println(existentUsers);
		//returnam lista cu userii gasiti
		return existentUsers;
	}
}