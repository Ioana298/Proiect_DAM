package dam.tam4.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Role;
import dam.tam4.repository.RoleRepository;

@Service
@Transactional
public class RoleService {
	static Logger log = Logger.getLogger(RoleService.class.getName());
	private final RoleRepository rRepository;

	public RoleService(RoleRepository rRepository) {
		this.rRepository = rRepository;
	}

	public void addRole(HttpServletRequest request, Role r) {
		Role newRole = new Role();
		newRole.setRoleId(null);
		newRole.setUsers(r.getUsers());

		rRepository.save(newRole);
		log.info("Role " + newRole.toString() + " was added by "+ request.getUserPrincipal().getName());
	}

	public void deleteRole(HttpServletRequest request, Role r) {
		log.info("Role " + r.toString() + " was deleted by "+ request.getUserPrincipal().getName());
		rRepository.delete(r);
	}

	public void updateRole(HttpServletRequest request, Role p) {
		Optional<Role> possibleRole = rRepository.findById(p.getRoleId());
		Role existingRole = possibleRole.get();
		existingRole.setRoleName(p.getRoleName());

		rRepository.save(existingRole);
		log.info("Role " + existingRole.toString() + " was updates by "+ request.getUserPrincipal().getName());
	}

	public List<Role> getAllRoles() {
		return rRepository.findAll();
	}
	
	public List<Role> getDefaultRole() {
		List<Role> roles = new ArrayList<>();
		roles.add(rRepository.findById(1L).get()); // Role with id 1 is ROLE_USER
		return roles;
	}
}
