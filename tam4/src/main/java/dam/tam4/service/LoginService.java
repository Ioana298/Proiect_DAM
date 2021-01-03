package dam.tam4.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.config.PasswordGenerator;
import dam.tam4.domain.Login;
import dam.tam4.repository.LoginRepository;

@Service
@Transactional
public class LoginService {

	private final LoginRepository lRepository;

	public LoginService(LoginRepository lRepository) {
		this.lRepository = lRepository;
	}

	public void addLogin(Login l) {
		Login newLogin = new Login();
		newLogin.setId(null);
		newLogin.setUsername(l.getUsername());
		newLogin.setPassword(l.getPassword());
		newLogin.setActive(true);

		lRepository.save(newLogin);
	}

	public void deleteLogin(Login l) {
		lRepository.delete(l);
	}

	public void updateLogin(Login l) {
		Optional<Login> possibleLogin = lRepository.findById(l.getId());
		Login existingLogin = possibleLogin.get();
		existingLogin.setUsername(l.getUsername());
		existingLogin.setPassword(l.getPassword());

		lRepository.save(existingLogin);
	}

	public static Login generateCredentials(String name) {
		Login credentials = new Login();
		credentials.setUsername(getUsernameByName(name));
		credentials.setPassword(PasswordGenerator.getEncoddedPass("tam4"));
		return credentials;
	}

	private static String getUsernameByName(String name) {
		return name.split(" ")[0].toLowerCase() + "." + name.split(" ")[1].toLowerCase();
	}
}
