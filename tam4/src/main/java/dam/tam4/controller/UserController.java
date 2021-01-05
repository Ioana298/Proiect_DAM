package dam.tam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.User;
import dam.tam4.service.RoleService;
import dam.tam4.service.UserService;

@Controller
public class UserController {
	
	private final UserService uService;
	private final RoleService rService;


	public UserController(UserService uService, RoleService rService) {
		this.uService = uService;
		this.rService= rService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/user/createUser") //terminatie URL
	public ModelAndView createUser(User u){
		System.out.println(u);
		uService.addUser(u);
		return new ModelAndView ("redirect:/user/getAllUsers");
	}

	@GetMapping("/user/getAllUsers")
	public ModelAndView getAllUsers() {
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("users", uService.getAllUsers());
		mv.addObject("roles", rService.getAllRoles());
		
		return mv;
	}

	@GetMapping("/user/getUser")
	public ModelAndView getUser(@RequestParam(name = "id") Long id){
		return null;
	}
	
	@PostMapping("/user/updateUser")
	public ModelAndView updateUser(User u) {
		uService.updateUser(u);
	
		return new ModelAndView ("redirect:/user/getAllUsers");
	}
	
	@GetMapping("/user/deleteUser")
	public ModelAndView deleteUser(@RequestParam(name = "id") Long id) {
		uService.deleteUser(id);
	
		return new ModelAndView ("redirect:/user/getAllUsers");
	}
}
