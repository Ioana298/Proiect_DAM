package dam.tam4.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

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
		Login newLogin=new Login();
		newLogin.setId(null);
		newLogin.setUsername(l.getUsername());
		newLogin.setPassword(l.getPassword());
		
		lRepository.save(newLogin);
	}
	
	public void deleteLogin(Login l) {
		lRepository.delete(l);
	}
	
	public void updateLogin(Login l) {
		Optional <Login> possibleLogin = lRepository.findById(l.getId());
		Login existingLogin=possibleLogin.get();
		existingLogin.setUsername(l.getUsername());
		existingLogin.setPassword(l.getPassword());
		
		lRepository.save(existingLogin);
	}
}
