package dam.tam4.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import dam.tam4.config.PasswordGenerator;
import dam.tam4.domain.Login;
import dam.tam4.repository.LoginRepository;

@Service
@Transactional
public class LoginService {
	static Logger log = Logger.getLogger(LoginService.class.getName());

	private final LoginRepository lRepository;

	public LoginService(LoginRepository lRepository) {
		this.lRepository = lRepository;
	}

	public void addLogin(HttpServletRequest request, Login l) {
		Login newLogin = new Login();
		newLogin.setId(null);
		newLogin.setUsername(l.getUsername());
		newLogin.setPassword(l.getPassword());
		newLogin.setActive(true);

		lRepository.save(newLogin);
		log.info("Login " + newLogin.toString() + " was added by "+ request.getUserPrincipal().getName());
	}

	public void deleteLogin(HttpServletRequest request, Login l) {
		log.info("Login " + l.toString() + " was deleted by "+ request.getUserPrincipal().getName());
		lRepository.delete(l);
	}

	public void updateLogin(HttpServletRequest request, Login l) {
		Optional<Login> possibleLogin = lRepository.findById(l.getId());
		Login existingLogin = possibleLogin.get();
		existingLogin.setUsername(l.getUsername());
		existingLogin.setPassword(l.getPassword());

		lRepository.save(existingLogin);
		log.info("Login " + existingLogin.toString() + " was updated by "+ request.getUserPrincipal().getName());
	}

	public static Login generateCredentials(String name) {
		Login credentials = new Login();
		credentials.setUsername(getUsernameByName(name));
		credentials.setPassword(PasswordGenerator.getEncoddedPass("tam4"));
		credentials.setActive(true);
		return credentials;
	}

	private static String getUsernameByName(String name) {
		return name.split(" ")[0].toLowerCase() + "." + name.split(" ")[1].toLowerCase();
	}
}
