package dam.tam4.controller;

import javax.servlet.http.HttpServletRequest;

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
	public ModelAndView createUser(HttpServletRequest request, User u){
		System.out.println(u);
		uService.addUser(request, u);
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
	public ModelAndView updateUser(HttpServletRequest request, User u) {
		uService.updateUser(request, u);
	
		return new ModelAndView ("redirect:/user/getAllUsers");
	}
	
	@GetMapping("/user/deleteUser")
	public ModelAndView deleteUser(HttpServletRequest request, @RequestParam(name = "id") Long id) {
		uService.deleteUser(request, id);
	
		return new ModelAndView ("redirect:/user/getAllUsers");
	}
}
