package dam.tam4.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.User;
import dam.tam4.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private final UserRepository uRepository;
	private final RoleService rService;

	public UserService(UserRepository uRepository, RoleService rService) {
		this.uRepository = uRepository;
		this.rService = rService;
	}

	public void addUser(User u) {
		User newUser = new User();
		newUser.setUserId(null);
		newUser.setName(u.getName());
		newUser.setEmail(u.getEmail());
		newUser.setPhoneNumber(u.getPhoneNumber());
		newUser.setBenefit(u.getBenefit());
		newUser.setLogin(LoginService.generateCredentials(u.getName()));
		newUser.setTeam(u.getTeam());
		newUser.setRoles(rService.getDefaultRole());

		uRepository.save(newUser);
	}

	public void deleteUser(Long id) {
		uRepository.delete(uRepository.findById(id).get());
	}

	public void updateUser(User u) {
		Optional<User> possibleUser = uRepository.findById(u.getUserId());
		User existingUser = possibleUser.get();
		existingUser.setName(u.getName());
		existingUser.setEmail(u.getEmail());
		existingUser.setPhoneNumber(u.getPhoneNumber());
		existingUser.setBenefit(u.getBenefit());
		existingUser.setTeam(u.getTeam());
		existingUser.setRoles(u.getRoles());

		uRepository.save(existingUser);
	}

	public List<User> getAllUsers() {
		return uRepository.findAll();
	}
}
