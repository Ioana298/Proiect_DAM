package dam.tam4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.Role;
import dam.tam4.domain.User;
import dam.tam4.repository.RoleRepository;
import dam.tam4.repository.TeamRepository;
import dam.tam4.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository uRepository;
	private final RoleRepository rRepository;

	
	public UserService(UserRepository uRepository, RoleRepository rRepository, TeamRepository tRepository) {
		this.uRepository = uRepository;
		this.rRepository = rRepository;
		
	}
	
	public void addUser(User u) {
		User newUser=new User();
		newUser.setUserId(null);
		newUser.setName(u.getName());
		newUser.setEmail(u.getEmail());
		newUser.setPassword(u.getPassword());
		newUser.setPhoneNumber(u.getPhoneNumber());
		newUser.setBenefit(u.getBenefit());
		newUser.setLogin(u.getLogin());
		newUser.setTeam(u.getTeam());
		newUser.setRoles(u.getRoles() == null? null: saveRole(u.getRoles()));
		
		uRepository.save(newUser);
	}

	public void deleteUser(Long id) {
		uRepository.delete(uRepository.findById(id).get());
	}

	public void updateUser(User u) {
		Optional <User> possibleUser = uRepository.findById(u.getUserId());
		User existingUser=possibleUser.get();
		existingUser.setName(u.getName());
		existingUser.setEmail(u.getEmail());
		existingUser.setPassword(u.getPassword());
		existingUser.setPhoneNumber(u.getPhoneNumber());
		existingUser.setBenefit(u.getBenefit());
		existingUser.setLogin(u.getLogin());
		existingUser.setTeam(u.getTeam());
		existingUser.setRoles(u.getRoles() == null? null: saveRole(u.getRoles()));
		
		
		uRepository.save(existingUser);
	}
	public List <User> getAllUsers(){
		return uRepository.findAll();
	}
	private List<Role> saveRole(List<Role> appliedRoles){

		//Lista goala ce va contine Roleurile din baza de date
		List<Role> existentRoles = new ArrayList<>();
		
		//iteram prin lista trimisa din interfata / modal
				for (Role r: appliedRoles) {

					// pentru fiecare element din modal, luam id-ul si cautam pe baza lui Role din baza de date
					Role existentRole = rRepository.findById(r.getRoleId()).get();
					
					//adaugam fiecare Role gasit in lista
					existentRoles.add(existentRole);
					}
				
				System.out.println(existentRoles);
				//returnam lista cu Roleurile gasite
				return existentRoles;
			}
}
