package dam.tam4.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.User;
import dam.tam4.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository uRepository;

	public UserService(UserRepository uRepository) {
		this.uRepository = uRepository;
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
		newUser.setRoles(u.getRoles());
		newUser.setTeam(u.getTeam());

		uRepository.save(newUser);
	}

	public void deleteUser(User u) {
		uRepository.delete(u);
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
		existingUser.setRoles(u.getRoles());
		existingUser.setTeam(u.getTeam());
		uRepository.save(existingUser);
	}
}
