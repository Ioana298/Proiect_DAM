package dam.tam4.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Role;
import dam.tam4.domain.User;
import dam.tam4.service.RoleService;

@Controller
public class RoleController {
	private final RoleService rService;

	public RoleController(RoleService rService) {
		this.rService = rService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/role/createRole") //terminatie URL
	public void createRole(HttpServletRequest request, Role r){
		rService.addRole(request, r);
	}

	@GetMapping("/role/getAllRoles")
	public ModelAndView getAllRoles() {
		ModelAndView mv = new ModelAndView("Role");
		List<User> roles= new ArrayList<>();
		mv.addObject("roles", roles);
		return mv;
	}

	@GetMapping("/role/getRole")
	public ModelAndView getRole(@RequestParam(name = "id") Long id){
		return null;
	}
}
