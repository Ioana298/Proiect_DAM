package dam.tam4.service;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Project;
import dam.tam4.repository.ProjectRepository;

@Service
@Transactional
public class ProjectService {
	
private final ProjectRepository pRepository;
	
	public ProjectService(ProjectRepository pRepository) {
		this.pRepository = pRepository;
	}
	
	public void addProject(Project p) {
		Project newProject=new Project();
		newProject.setProjectId(null);
		newProject.setInternships(p.getInternships());
		
		pRepository.save(newProject);
	}
	
	public void deleteProject(Project p) {
		pRepository.delete(p);
	}

}
