package dam.tam4.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Project;
import dam.tam4.repository.ProjectRepository;

@Service
@Transactional
public class ProjectService {
	static Logger log = Logger.getLogger(ProjectService.class.getName());
	
	private final ProjectRepository pRepository;
	
	public ProjectService(ProjectRepository pRepository) {
		this.pRepository = pRepository;
	}
	
	public void addProject(HttpServletRequest request, Project p) {
		
		Project newProject=new Project();
		newProject.setProjectId(null);
		newProject.setName(p.getName());
		newProject.setDomain(p.getDomain());
		
		pRepository.save(newProject);
		log.info("Project " + newProject.toString() + " was added by "+ request.getUserPrincipal().getName());
	}
	
	public void deleteProject(HttpServletRequest request, Long id) {
		log.info("Project " + pRepository.findById(id).get().toString() + " was deleted by "+ request.getUserPrincipal().getName());
		pRepository.delete(pRepository.findById(id).get());
	}

	public void updateProject(HttpServletRequest request, Project p) {
		Optional <Project> possibleProject = pRepository.findById(p.getProjectId());
		Project existingProject=possibleProject.get();
		existingProject.setName(p.getName());
		existingProject.setDomain(p.getDomain());
		
		pRepository.save(existingProject);
		log.info("Project " + existingProject.toString() + " was updated by "+ request.getUserPrincipal().getName());
	}
	public List <Project> getAllProjects(){
		return pRepository.findAll();
	}
}
