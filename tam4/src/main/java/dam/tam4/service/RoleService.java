package dam.tam4.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dam.tam4.domain.Role;
import dam.tam4.repository.RoleRepository;
@Service
@Transactional
public class RoleService {
private final RoleRepository rRepository;
	
	public RoleService(RoleRepository rRepository) {
		this.rRepository = rRepository;
	}
	
	public void addRole(Role r) {
		Role newRole=new Role();
		newRole.setRoleId(null);
		newRole.setUsers(r.getUsers());
		
		rRepository.save(newRole);
	}
		
	public void deleteRole(Role r) {
		rRepository.delete(r);
	}
}
