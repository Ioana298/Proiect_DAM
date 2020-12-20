package dam.tam4.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Candidate;
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
	
	public void deleteProject(Project p) {
		pRepository.delete(p);
	}

	public void updateProject(Project p) {
		Optional <Project> possibleProject = pRepository.findById(p.getProjectId());
		Project existingProject=possibleProject.get();
		existingProject.setName(p.getName());
		existingProject.setDomain(p.getDomain());
		pRepository.save(existingProject);
	}
}
