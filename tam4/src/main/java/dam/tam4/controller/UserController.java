package dam.tam4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.User;
import dam.tam4.service.UserService;

@Controller
public class UserController {
	
	private final UserService uService;

	public UserController(UserService uService) {
		this.uService = uService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/user/createUser") //terminatie URL
	public void createUser(User u){
		uService.addUser(u);
	}

	@GetMapping("/user/getAllUsers")
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView("user");
		
		//creare lista pentru obiecte
		List<User> users = new ArrayList<>();
		
		//creare obiect pt lista
		User myUser= new User();
		myUser.setUserId(1L);
		myUser.setName("Emily Rose");
		myUser.setEmail("emrose@gmail.com");
		myUser.setPassword("abc123");
		myUser.setPhoneNumber(7345290129L);
		myUser.setBenefit("Certificate");
		myUser.setLogin(null);
		myUser.setRoles(null);
		myUser.setTeam(null);
		
		//adaugare obiect
		users.add(myUser);
		
		//transfer obiect in frontend
		mv.addObject("users", users);
		
		return mv;
	}

	@GetMapping("/uUser/getUser")
	public ModelAndView getUser(@RequestParam(name = "id") Long id){
		return null;
	}
}
