package dam.tam4.service;

import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import dam.tam4.domain.Candidate;
import dam.tam4.domain.Internship;
import dam.tam4.repository.InternshipRepository;

@Service
@Transactional
public class InternshipService {
private final InternshipRepository iRepository;
	
	public InternshipService(InternshipRepository iRepository) {
		this.iRepository = iRepository;
	}
	
	public void addInternship(Internship i) {
		Internship newInternship=new Internship();
		newInternship.setInternshipId(null);
		newInternship.setName(i.getName());
		newInternship.setStartDate(i.getStartDate());
		newInternship.setEndDate(i.getEndDate());
		newInternship.setIsPaid(i.getIsPaid());
		newInternship.setCandidates(i.getCandidates());
		newInternship.setProject(i.getProject());
		
		iRepository.save(newInternship);
	}
	
	public void deleteInternship(Internship i) {
		iRepository.delete(i);
	}
	
	public void updateInternship(Internship i) {
		Optional <Internship> possibleInternship = iRepository.findById(i.getInternshipId());
		Internship existingInternship=possibleInternship.get();
		existingInternship.setName(i.getName());
		existingInternship.setCandidates(i.getCandidates());
		existingInternship.setProject(i.getProject());
		existingInternship.setStartDate(i.getStartDate());
		existingInternship.setEndDate(i.getEndDate());
		existingInternship.setIsPaid(i.getIsPaid());
		
		iRepository.save(existingInternship);
	}


}
