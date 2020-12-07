package dam.tam4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import dam.tam4.domain.Role;
import dam.tam4.service.RoleService;

@Controller
public class RoleController {
	private final RoleService cService;

	public RoleController(RoleService cService) {
		this.cService = cService;
	}

	//definim tipul de request si in interiorul metodei create, chemam metoda din service
	@PostMapping("/Role/createRole") //terminatie URL
	public void createRole(Role c){
		cService.addRole(c);
	}

	@GetMapping("/Role/getAllRoles")
	public ModelAndView getAllRoles() {
		ModelAndView mv = new ModelAndView("Role");
		mv.addObject("text", "text pentru test");
		return mv;
	}

	@GetMapping("/Role/getRole")
	public ModelAndView getRole(@RequestParam(name = "id") Long id){
		return null;
	}
}
