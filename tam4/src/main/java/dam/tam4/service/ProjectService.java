package dam.tam4.service;

import java.util.List;
import java.util.Optional;

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
		newProject.setName(p.getName());
		newProject.setDomain(p.getDomain());
		
		pRepository.save(newProject);
	}
	
	public void deleteProject(Long id) {
		pRepository.delete(pRepository.findById(id).get());
	}

	public void updateProject(Project p) {
		Optional <Project> possibleProject = pRepository.findById(p.getProjectId());
		Project existingProject=possibleProject.get();
		existingProject.setName(p.getName());
		existingProject.setDomain(p.getDomain());
		
		pRepository.save(existingProject);
	}
	public List <Project> getAllProjects(){
		return pRepository.findAll();
	}
}
