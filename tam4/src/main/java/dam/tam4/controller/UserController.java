package dam.tam4.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Candidate;
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
	public ModelAndView createUser(User u){
		uService.addUser(u);
		return new ModelAndView ("redirect:/user/getAllUsers");
	}

	@GetMapping("/user/getAllUsers")
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("users", uService.getAllUsers());
		
		return mv;
	}

	@GetMapping("/uUser/getUser")
	public ModelAndView getUser(@RequestParam(name = "id") Long id){
		return null;
	}
}
