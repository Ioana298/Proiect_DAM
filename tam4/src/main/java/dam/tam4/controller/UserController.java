package dam.tam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.User;
import dam.tam4.service.UserService;

@Controller
public class UserController {
	private final UserService cService;

	public UserController(UserService cService) {
		this.cService = cService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/User/createUser") //terminatie URL
	public void createUser(User c){
		cService.addUser(c);
	}

	@GetMapping("/User/getAllUsers")
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView("User");
		mv.addObject("text", "text pentru test");
		return mv;
	}

	@GetMapping("/User/getUser")
	public ModelAndView getUser(@RequestParam(name = "id") Long id){
		return null;
	}
}
